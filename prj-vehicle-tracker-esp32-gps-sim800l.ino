#define DEVICE_ID "TRACKER0001"

#include <SoftwareSerial.h>

SoftwareSerial SoftSerial(D1, D2);

String at_resp;
String _OK = "OK" + String(char(13)) + String(char(10));

String clat, clng;
unsigned long last_gps_time = 0;
const unsigned long last_gps_interval = 5000;

void setup() {
  Serial.begin(9600);
  SoftSerial.begin(9600);
  a9_softreset();
}

void loop() {
  run();
}

void run() {
  checkAT();
  if (!getSignal()) return;
  if (!enableGPS()) return;
  if (!checkGPS()) return;
  if (!connectNetwork()) return;
  if (connectMqtt()) publishMqtt();
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
  bool at = at_command("AT+CSQ\r", _OK, 1000);
  if (!at) return false;
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