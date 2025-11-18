#define DEVICE_ID "TRACKER0001"

#include <SoftwareSerial.h>
#include <ESP8266WiFi.h>
#include <WiFiUdp.h>

SoftwareSerial SoftSerial(D1, D2);

String at_resp;
String _OK = "OK" + String(char(13)) + String(char(10));

String clat, clng;
unsigned long last_gps_time = 0;
const unsigned long last_gps_interval = 5000;

// Global variable to store signal strength
String signalStrength = "N/A";

// WiFi AP settings
const char* ssid = "VehicleTracker_AP";
const char* password = "123456789"; // At least 8 characters for WPA2

WiFiServer server(80);
WiFiUDP udpServer;

// UDP port for status updates
unsigned int localUdpPort = 8888;
char incomingPacket[255];
char udpReply[255];

// Track connected client IP
IPAddress clientIP(0, 0, 0, 0);
unsigned long lastClientActivity = 0;
const unsigned long CLIENT_TIMEOUT = 60000; // 1 minute timeout

void setup() {
  Serial.begin(9600);
  SoftSerial.begin(9600);

  // Start WiFi AP
  WiFi.softAP(ssid, password);
  IPAddress IP = WiFi.softAPIP();
  Serial.print("AP IP address: ");
  Serial.println(IP);

  // Start UDP server
  udpServer.begin(localUdpPort);
  Serial.print("UDP Server started at port: ");
  Serial.println(localUdpPort);

  a9_softreset();
}

bool quickCheckGPS() {
  // Send a quick GPS location command with short timeout to check if GPS is responding
  return at_command("AT+LOCATION=2\r", _OK, 2000);
}

void sendStatusUpdate() {
  // Only send if we have an active client
  if (clientIP[0] == 0 && clientIP[1] == 0 && clientIP[2] == 0 && clientIP[3] == 0) {
    return; // No client connected
  }

  // Check GPS status with short timeout to avoid blocking UDP
  bool gpsActive = quickCheckGPS();
  String gpsStatus = gpsActive ? "Active" : "Inactive";

  // Get current location if available
  String location = "N/A";
  if (clat.length() > 0 && clng.length() > 0) {
    location = clat + "," + clng;
  }

  // Create status message
  String status = "DEVICE_ID:" + String(DEVICE_ID) +
                  "|SIGNAL:" + signalStrength +
                  "|GPS:" + gpsStatus +
                  "|LOCATION:" + location +
                  "|TIME:" + String(millis());

  // Send UDP to the connected client
  udpServer.beginPacket(clientIP, localUdpPort);
  udpServer.print(status);
  udpServer.endPacket();
}

unsigned long lastStatusUpdate = 0;
const unsigned long statusUpdateInterval = 5000; // Send status every 5 seconds

void loop() {
  // Handle incoming UDP packets
  int packetSize = udpServer.parsePacket();
  if (packetSize) {
    // Read the packet into packetBufffer
    int len = udpServer.read(incomingPacket, 255);
    if (len > 0) {
      incomingPacket[len] = 0;
    }

    // Update client IP when we receive a packet
    clientIP = udpServer.remoteIP();
    lastClientActivity = millis();

    // Send a reply, to the IP address and port that sent us the packet
    udpServer.beginPacket(udpServer.remoteIP(), udpServer.remotePort());
    udpServer.printf("Vehicle Tracker Status: Connected to A9 module");
    udpServer.endPacket();
  }

  // Send periodic status updates only if client is active
  if (millis() - lastStatusUpdate >= statusUpdateInterval) {
    // Check if client is still active (within timeout period)
    if (millis() - lastClientActivity <= CLIENT_TIMEOUT) {
      sendStatusUpdate();
    }
    lastStatusUpdate = millis();
  }

  // run();
}

void run() {
  checkAT();
  sendStatusUpdate(); // Send status after checking AT command
  if (!getSignal()) {
    sendStatusUpdate(); // Send status showing signal failure
    return;
  }
  if (!enableGPS()) {
    sendStatusUpdate(); // Send status showing GPS enable failure
    return;
  }
  if (!checkGPS()) {
    sendStatusUpdate(); // Send status showing GPS check failure
    return;
  }
  sendStatusUpdate(); // Send status showing GPS is working
  if (!connectNetwork()) {
    sendStatusUpdate(); // Send status showing network connection failure
    return;
  }
  sendStatusUpdate(); // Send status showing network is connected
  if (connectMqtt()) {
    sendStatusUpdate(); // Send status showing MQTT connected
    publishMqtt();
    sendStatusUpdate(); // Send status showing MQTT published
  }
  a9_softreset();
}

void checkAT() {
  runUntilOK("AT\r", _OK, 1000);
  delay(1000);
}

bool checkGPS() {
  // This function is used for the main operation sequence
  // Try to get GPS data for up to 30 seconds as before
  unsigned long ctime = millis();
  bool at = false;
  while (1) {
    if (millis() - ctime >= 30000) break;
    at = at_command("AT+LOCATION=2\r", _OK, 5000);
    if (at) break;
  }
  delay(1000);
  return at;
}

bool getSignal() {
  bool at = at_command("AT+CSQ\r", _OK, 1000);
  if (!at) return false;

  // Extract signal strength from response
  int signalStart = at_resp.indexOf("+CSQ:");
  if (signalStart != -1) {
    int signalEnd = at_resp.indexOf(',', signalStart);
    if (signalEnd != -1) {
      signalStrength = at_resp.substring(signalStart + 5, signalEnd);
      signalStrength.trim();
    }
  }

  delay(1000);
  return true;
}

bool enableGPS() {
  bool at = at_command("AT+GPS=1\r", _OK, 1000);
  if (!at) return false;
  delay(1000);
  return true;
}

bool connectMqtt() {
  unsigned long ctime = millis();
  bool at = false;
  while (1) {
    if (millis() - ctime >= 30000) break;
    at = at_command("AT+MQTTCONN=\"broker.emqx.io\",1883,\"tracker-a9g-A1b2C3d4E5f6G7h8I9j0KlMnOpQrStUvWxYzABCD\",120,0,\"\",\"\"\r", _OK, 5000);
    if (at) break;
  }
  delay(1000);
  return at;
}

void disconnectMqtt() {
  runUntilOK("AT+MQTTDISCONN\r", _OK, 1000);
  delay(1000);
}

void publishMqtt() {
  while (1) {
    delay(1000);
    if (!readGPS()) continue;
    String command = "AT+MQTTPUB=\"tracker-A1b2C3d4E5f6G7h8I9j0KlMnOpQrStUvWxYzABCD\",\"$@id,@lat,@lng,@time#\",0,0,0\r";
    command.replace("@id", DEVICE_ID);
    command.replace("@lat", clat);
    command.replace("@lng", clng);
    command.replace("@time", String(millis()));
    if (!at_command(command, _OK, 5000)) {
      if (!connectMqtt()) break;
    }
  }
  delay(1000);
  disconnectMqtt();
}

bool connectNetwork() {
  delay(1000);
  if (!at_command("AT+CGATT=1\r", _OK, 2500)) {
    return false;
  }
  delay(1000);
  if (!at_command("AT+CGDCONT=1,\"IP\",\"www\"\r", _OK, 2500)) {
    return false;
  }
  delay(1000);
  if (!at_command("AT+CGACT=1,1\r", _OK, 2500)) {
    return false;
  }
  delay(1000);
  return true;
}

void runUntilOK(String command, String wait_for, long timeout) {
  while (1) {
    bool at = at_command(command, wait_for, timeout);
    delay(1000);
    if (at) break;
  }
}

bool readGPS() {
  if (!at_command("AT+LOCATION=2\r", _OK, 1000)) {
    return false;
  }
  int r1Index = at_resp.indexOf('\r');
  int cIndex = at_resp.indexOf(',', r1Index + 1);
  int r2Index = at_resp.indexOf('\r', cIndex + 1);

  clat = at_resp.substring(r1Index, cIndex);
  clng = at_resp.substring(cIndex + 1, r2Index);

  clat.trim();
  clng.trim();

  Serial.print(clat);
  Serial.print(", ");
  Serial.print(clng);
  Serial.print(", ");
  Serial.print(clat.toFloat());
  Serial.print(", ");
  Serial.println(clng.toFloat());

  if (clat.toFloat() <= 0.0 || clng.toFloat() <= 0.0) return false;

  return true;
}

bool at_command(String command, String wait_for, long timeout) {
  SoftSerial.print(command);
  unsigned long ptime = millis();
  bool ret = false;
  String res;
  at_resp = "";
  while (true) {
    if (ret) break;
    if (millis() - ptime >= timeout) break;
    while (SoftSerial.available()) {
      char c = SoftSerial.read();
      res += String(c);
      if (res.endsWith(wait_for)) {
        ret = true;
        at_resp = res;
      }
    }
  }
  command.trim();
  Serial.print(command);
  Serial.print(": ");
  Serial.println(ret ? "success" : "failed");

  // Send UDP status message if AT command fails
  if (!ret) {
    // Only send to client if we have an active client
    if (!(clientIP[0] == 0 && clientIP[1] == 0 && clientIP[2] == 0 && clientIP[3] == 0)) {
      String failMsg = "AT_FAILED:" + command + "|TIME:" + String(millis());
      udpServer.beginPacket(clientIP, localUdpPort);
      udpServer.print(failMsg);
      udpServer.endPacket();
    }
  }

  log(res);
  flush_softser();
  return ret;
}

void flush_softser() {
  // Serial.println("********************************************************");
  while (SoftSerial.available()) {
    Serial.write(SoftSerial.read());
    delay(10);
  }
  Serial.println();
  // Serial.println("********************************************************");
}

void a9_softreset() {
  Serial.println("A9 Soft Reset...");
  at_command("AT+RST=1\r", _OK, 1000);
  delay(15000);
}

void log(String s) {
  Serial.println("----------------------------------------------------");
  Serial.println(s);
  Serial.println("----------------------------------------------------");
}

void readSoftSerX(unsigned long time) {
  unsigned long ctime = millis();
  while (1) {
    if (millis() - ctime >= time) {
      break;
    }
    while (SoftSerial.available()) {
      Serial.write(SoftSerial.read());
      delay(10);
      ctime = millis();
    }
  }
}