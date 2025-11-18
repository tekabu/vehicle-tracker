#define DEVICE_ID "TRACKER0001"

#include <SoftwareSerial.h>
#include "BluetoothSerial.h"

SoftwareSerial SoftSerial(D1, D2);
BluetoothSerial SerialBT;

String at_resp;
String _OK = "OK" + String(char(13)) + String(char(10));

String clat, clng;
unsigned long last_gps_time = 0;
const unsigned long last_gps_interval = 5000;

// Bluetooth debug interval
unsigned long last_bluetooth_debug = 0;
const unsigned long bluetooth_debug_interval = 3000; // 3 seconds

void setup() {
  Serial.begin(9600);
  SerialBT.begin("ESP32_VehicleTracker"); // Bluetooth device name
  SoftSerial.begin(9600);
  SerialBT.println("Vehicle Tracker Device Started");
  Serial.println("Vehicle Tracker Device Started");
  a9_softreset();
}

void loop() {
  run();
}

void run() {
  bluetoothDebug("Starting device cycle...");
  Serial.println("Starting device cycle...");

  checkAT();
  if (!getSignal()) {
    bluetoothDebug("No network signal - returning");
    Serial.println("No network signal - returning");
    return;
  }
  if (!enableGPS()) {
    bluetoothDebug("Failed to enable GPS - returning");
    Serial.println("Failed to enable GPS - returning");
    return;
  }
  if (!checkGPS()) {
    bluetoothDebug("GPS not available - returning");
    Serial.println("GPS not available - returning");
    return;
  }
  if (!connectNetwork()) {
    bluetoothDebug("Failed to connect to network - returning");
    Serial.println("Failed to connect to network - returning");
    return;
  }

  bluetoothDebug("Attempting MQTT connection...");
  Serial.println("Attempting MQTT connection...");
  if (connectMqtt()) {
    bluetoothDebug("MQTT connected - starting to publish data");
    Serial.println("MQTT connected - starting to publish data");
    publishMqtt();
  } else {
    bluetoothDebug("MQTT connection failed");
    Serial.println("MQTT connection failed");
  }

  a9_softreset();
}

void checkAT() {
  runUntilOK("AT\r", _OK, 1000);
  delay(1000);
}

bool checkGPS() {
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
  bluetoothDebug("Checking network signal...");
  Serial.println("Checking network signal...");
  bool at = at_command("AT+CSQ\r", _OK, 1000);
  if (!at) {
    bluetoothDebug("No network signal detected");
    Serial.println("No network signal detected");
    return false;
  }
  bluetoothDebug("Network signal OK");
  Serial.println("Network signal OK");
  delay(1000);
  return true;
}

bool enableGPS() {
  bluetoothDebug("Enabling GPS...");
  Serial.println("Enabling GPS...");
  bool at = at_command("AT+GPS=1\r", _OK, 1000);
  if (!at) {
    bluetoothDebug("Failed to enable GPS");
    Serial.println("Failed to enable GPS");
    return false;
  }
  bluetoothDebug("GPS enabled successfully");
  Serial.println("GPS enabled successfully");
  delay(1000);
  return true;
}

bool connectMqtt() {
  bluetoothDebug("Attempting MQTT connection...");
  Serial.println("Attempting MQTT connection...");
  unsigned long ctime = millis();
  bool at = false;
  while (1) {
    if (millis() - ctime >= 30000) {
      bluetoothDebug("MQTT connection timeout after 30 seconds");
      Serial.println("MQTT connection timeout after 30 seconds");
      break;
    }
    at = at_command("AT+MQTTCONN=\"broker.emqx.io\",1883,\"tracker-a9g-A1b2C3d4E5f6G7h8I9j0KlMnOpQrStUvWxYzABCD\",120,0,\"\",\"\"\r", _OK, 5000);
    if (at) {
      bluetoothDebug("MQTT connected successfully");
      Serial.println("MQTT connected successfully");
      break;
    }
  }
  delay(1000);
  return at;
}

void disconnectMqtt() {
  bluetoothDebug("Disconnecting from MQTT...");
  Serial.println("Disconnecting from MQTT...");
  runUntilOK("AT+MQTTDISCONN\r", _OK, 1000);
  bluetoothDebug("MQTT disconnected");
  Serial.println("MQTT disconnected");
  delay(1000);
}

void publishMqtt() {
  bluetoothDebug("Starting MQTT publishing loop...");
  Serial.println("Starting MQTT publishing loop...");
  while (1) {
    delay(1000);
    if (!readGPS()) {
      bluetoothDebug("Failed to read GPS - trying again...");
      Serial.println("Failed to read GPS - trying again...");
      continue;
    }
    bluetoothDebug("Publishing GPS data via MQTT: " + clat + "," + clng);
    Serial.println("Publishing GPS data via MQTT: " + clat + "," + clng);
    String command = "AT+MQTTPUB=\"tracker-A1b2C3d4E5f6G7h8I9j0KlMnOpQrStUvWxYzABCD\",\"$@id,@lat,@lng,@time#\",0,0,0\r";
    command.replace("@id", DEVICE_ID);
    command.replace("@lat", clat);
    command.replace("@lng", clng);
    command.replace("@time", String(millis()));
    if (!at_command(command, _OK, 5000)) {
      bluetoothDebug("MQTT publish failed - attempting to reconnect...");
      Serial.println("MQTT publish failed - attempting to reconnect...");
      if (!connectMqtt()) break;
    }
  }
  delay(1000);
  disconnectMqtt();
}

bool connectNetwork() {
  bluetoothDebug("Connecting to network...");
  Serial.println("Connecting to network...");
  delay(1000);
  if (!at_command("AT+CGATT=1\r", _OK, 2500)) {
    bluetoothDebug("Network attachment failed");
    Serial.println("Network attachment failed");
    return false;
  }
  bluetoothDebug("Network attached successfully");
  Serial.println("Network attached successfully");
  delay(1000);
  if (!at_command("AT+CGDCONT=1,\"IP\",\"www\"\r", _OK, 2500)) {
    bluetoothDebug("PDP context configuration failed");
    Serial.println("PDP context configuration failed");
    return false;
  }
  bluetoothDebug("PDP context configured");
  Serial.println("PDP context configured");
  delay(1000);
  if (!at_command("AT+CGACT=1,1\r", _OK, 2500)) {
    bluetoothDebug("PDP context activation failed");
    Serial.println("PDP context activation failed");
    return false;
  }
  bluetoothDebug("PDP context activated - Network connection successful");
  Serial.println("PDP context activated - Network connection successful");
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
    bluetoothDebug("Failed to read GPS location");
    Serial.println("Failed to read GPS location");
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

  if (clat.toFloat() <= 0.0 || clng.toFloat() <= 0.0) {
    bluetoothDebug("Invalid GPS coordinates: " + clat + "," + clng);
    Serial.println("Invalid GPS coordinates: " + clat + "," + clng);
    return false;
  }

  bluetoothDebug("Valid GPS coordinates: " + clat + "," + clng);
  Serial.println("Valid GPS coordinates: " + clat + "," + clng);
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
  bluetoothDebug("Performing A9 soft reset...");
  Serial.println("A9 Soft Reset...");
  at_command("AT+RST=1\r", _OK, 1000);
  bluetoothDebug("A9 reset complete - waiting 15 seconds...");
  Serial.println("Waiting for reset completion...");
  delay(15000);
  bluetoothDebug("Device reset complete");
  Serial.println("Device reset complete");
}

void log(String s) {
  Serial.println("----------------------------------------------------");
  Serial.println(s);
  Serial.println("----------------------------------------------------");
}

void bluetoothDebug(String message, bool use_non_blocking_delay = true) {
  if (use_non_blocking_delay) {
    unsigned long current_time = millis();
    if (current_time - last_bluetooth_debug >= bluetooth_debug_interval) {
      SerialBT.println(message);
      last_bluetooth_debug = current_time;
    }
  } else {
    SerialBT.println(message);
  }
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