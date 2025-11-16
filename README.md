# Vehicle Tracker Mobile

A React Native mobile application for managing vehicle tracking, rentals, customers, and devices. Built with Expo for cross-platform compatibility (iOS, Android, and Web).

## Features

- **Authentication**: Login, registration, password recovery with OTP validation
- **Customer Management**: Create, view, edit, and manage customer records
- **Vehicle Management**: Track and manage vehicle inventory
- **Device Management**: Manage tracking devices
- **Rental Management**: Handle vehicle rental operations
- **User Profile**: View and update user profile information

## Tech Stack

- **React Native** 0.81.5
- **Expo** ~54.0.23
- **React Navigation** (Drawer & Stack navigators)
- **AsyncStorage** for local data persistence
- **React** 19.1.0

## Prerequisites

Before you begin, ensure you have the following installed:

- **Node.js** (v18 or higher recommended)
- **npm** or **yarn**
- **Expo CLI** (will be installed with dependencies)

### Platform-Specific Requirements

#### For iOS Development:
- macOS with Xcode installed
- iOS Simulator or physical iOS device with Expo Go app

#### For Android Development:
- Android Studio with Android SDK
- Android Emulator or physical Android device with Expo Go app

#### For Web Development:
- Modern web browser (Chrome, Firefox, Safari, Edge)

## Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd vehicle-tracker-mobile
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Configure environment variables**

   Copy the `.env.example` file to create your `.env` file:
   ```bash
   cp .env.example .env
   ```

   Edit the `.env` file and set your API base URL:
   ```env
   EXPO_PUBLIC_API_BASE_URL=https://your-api-url.com/api
   ```

   Replace `https://your-api-url.com/api` with your actual backend API URL.

## Running the Application

### Start the Development Server

```bash
npm start
```

This will start the Expo development server and display a QR code in your terminal.

### Run on Specific Platforms

#### Android
```bash
npm run android
```

This will:
- Start the Metro bundler
- Open the app in an Android emulator (if available)
- Or prompt you to scan a QR code with the Expo Go app on your physical device

#### iOS
```bash
npm run ios
```

This will:
- Start the Metro bundler
- Open the app in an iOS simulator (macOS only)
- Or prompt you to scan a QR code with the Expo Go app on your physical device

#### Web
```bash
npm run web
```

This will start the app in your default web browser at `http://localhost:19006` (or similar).

## Running on Physical Devices

1. Install the **Expo Go** app from:
   - [App Store (iOS)](https://apps.apple.com/app/expo-go/id982107779)
   - [Google Play Store (Android)](https://play.google.com/store/apps/details?id=host.exp.exponent)

2. Run `npm start` to start the development server

3. Scan the QR code:
   - **iOS**: Use the Camera app to scan the QR code
   - **Android**: Use the Expo Go app to scan the QR code

4. The app will load on your device

## Project Structure

```
vehicle-tracker-mobile/
├── src/
│   ├── screens/          # Application screens
│   │   ├── auth/        # Authentication screens
│   │   ├── customers/   # Customer management screens
│   │   ├── devices/     # Device management screens
│   │   ├── vehicles/    # Vehicle management screens
│   │   └── rentals/     # Rental management screens
│   └── services/        # API and service layers
│       ├── api.js       # API service configuration
│       └── authService.js
├── App.js               # Main application component
├── package.json         # Project dependencies
├── .env.example         # Environment variables template
└── README.md           # This file
```

## Available Screens

### Authentication
- Login
- Register
- Forgot Password
- OTP Validation
- Reset Password
- Profile

### Main Features
- **Home**: Dashboard/home screen
- **Customers**: List, view, create, and edit customers
- **Devices**: Manage tracking devices
- **Vehicles**: Manage vehicle inventory
- **Rentals**: Handle rental operations

## API Configuration

The application communicates with a backend API. The API base URL is configured via environment variables:

- **Environment Variable**: `EXPO_PUBLIC_API_BASE_URL`
- **Default Fallback**: `http://localhost:8031/api`
- **Configuration File**: [src/services/api.js](src/services/api.js)

Make sure your backend API is running and accessible before using the app.

## Troubleshooting

### Common Issues

1. **"Unable to resolve module" errors**
   ```bash
   npm install
   npx expo start --clear
   ```

2. **Metro bundler issues**
   ```bash
   watchman watch-del-all
   rm -rf node_modules
   npm install
   npm start -- --reset-cache
   ```

3. **Environment variables not loading**
   - Ensure your `.env` file exists and has the correct format
   - Restart the Expo development server after changing environment variables
   - Use the `EXPO_PUBLIC_` prefix for all environment variables

4. **Network request failed**
   - Check that your API URL is correct in the `.env` file
   - Ensure your backend server is running
   - If testing on a physical device, make sure it's on the same network as your development machine

## Development Tips

- Use `npm start` and press `r` to reload the app
- Press `m` to toggle the menu
- Press `j` to open debugger
- Shake your device (or press Cmd+D on iOS simulator / Cmd+M on Android emulator) to open the developer menu

## Building for Production

For production builds, refer to the [Expo build documentation](https://docs.expo.dev/build/introduction/).

### EAS Build (Recommended)

```bash
npm install -g eas-cli
eas build --platform android
eas build --platform ios
```

## License

[Add your license information here]

## Contributing

[Add contribution guidelines here]

## Support

For issues and questions, please [create an issue](link-to-issues) in the repository.
