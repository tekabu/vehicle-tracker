#define TINY_GSM_MODEM_SIM800  // Define modem type

#include <TinyGsmClient.h>

#define SIM800_TX 17
#define SIM800_RX 16

const char apn[]  = "internet";
const char user[] = "";
const char pass[] = "";

const char server[] = "jsonplaceholder.typicode.com";
const char resource[] = "/posts/1";
const int port = 80;

#define SerialAT Serial2

TinyGsm modem(SerialAT);
TinyGsmClient client(modem);

void setup() {
  Serial.begin(115200);
  delay(1000);

  SerialAT.begin(115200);
  delay(3000);
  
  Serial.println(F("Initializing modem..."));
  modem.restart();
  delay(3000);

  Serial.println(F("Ready"));
}

void loop() {
  download();
  delay(5000);
}

void download() {
  Serial.print("Waiting for network...");
  
  if (!modem.waitForNetwork(10000L)) {
    Serial.println(" failed");
    return;
  }
  Serial.println(" OK");
  
  int signal = modem.getSignalQuality();
  Serial.print("Signal quality: ");
  Serial.println(signal);
  
  Serial.print("Connecting to ");
  Serial.print(apn);
  if (!modem.gprsConnect(apn, user, pass)) {
    Serial.println(" failed");
    return;
  }
  Serial.println(" OK");
  
  if (modem.isGprsConnected()) {
    Serial.println("GPRS connected");
  }
  else {
    Serial.println("GPRS not connected");
  }
  
  Serial.print("Connecting to ");
  Serial.print(server);
  Serial.print(":");
  Serial.println(port);
  
  if (!client.connect(server, port)) {
    Serial.print(" failed");
    return;
  }
  Serial.println(" OK");
  
  client.print(String("GET ") + resource + " HTTP/1.1\r\n");
  client.print(String("Host: ") + server + "\r\n");
  client.print("Connection: close\r\n\r\n");
  
  Serial.println("Waiting for response...");
  unsigned long timeout = millis();
  while (client.connected() && millis() - timeout < 10000L) {
    String line = client.readStringUntil('\n');
    Serial.println(line);
    timeout = millis();
    if (line == "\r") {
      break;
    }
  }
  
  Serial.println("Reading response");
  String body = "";
  timeout = millis();
  while (client.available() && millis() - timeout < 10000L) {
    char c = client.read();
    body += c;
    Serial.write(c);
    timeout = millis();
  }
  Serial.println("End of response");
  
  client.stop();
  Serial.println("Connection closed");
  
  modem.gprsDisconnect();
  Serial.println("GPRS disconnected");
}