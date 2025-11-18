# Vehicle Tracker with WiFi Monitoring

This project enhances the original NodeMCU vehicle tracker by adding WiFi access point capabilities and UDP status broadcasting for remote monitoring.

## Key Features Added

1. **WiFi Access Point**: NodeMCU creates its own WiFi network ("VehicleTracker_AP")
2. **UDP Status Broadcasting**: Periodic status updates sent every 5 seconds
3. **Real-time Monitoring**: See device status without needing USB connection

## Status Message Format

UDP broadcasts contain pipe-separated values:
```
DEVICE_ID:TRACKER0001|SIGNAL:15|GPS:Active|LOCATION:12.3456,78.9012|TIME:1234567
```

Where:
- `DEVICE_ID`: Unique identifier for the device
- `SIGNAL`: Signal strength from A9 module (0-31, or N/A)
- `GPS`: GPS status (Active/Inactive)
- `LOCATION`: Current GPS coordinates (lat,lng) or N/A
- `TIME`: Milliseconds since device start

## Requirements

- NodeMCU board
- A9 GPS/GSM module connected to D1/D2 pins
- Arduino IDE with ESP8266 board support

## Setup Instructions

1. Upload the modified code to your NodeMCU
2. Connect your Android device to the "VehicleTracker_AP" WiFi network