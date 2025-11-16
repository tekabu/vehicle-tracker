import 'react-native-gesture-handler';
import React, { useState } from 'react';
import { Alert, Platform, LogBox } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createDrawerNavigator } from '@react-navigation/drawer';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import authService from './src/services/authService';

// Suppress specific warnings/errors that we handle gracefully
LogBox.ignoreLogs([
  'Non-serializable values were found in the navigation state',
]);

import LoginScreen from './src/screens/LoginScreen';
import HomeScreen from './src/screens/HomeScreen';
import Page1 from './src/screens/Page1';
import Page2 from './src/screens/Page2';

// Customers
import CustomersListScreen from './src/screens/customers/CustomersListScreen';
import CustomerDetailScreen from './src/screens/customers/CustomerDetailScreen';
import CustomerFormScreen from './src/screens/customers/CustomerFormScreen';

// Devices
import DevicesListScreen from './src/screens/devices/DevicesListScreen';
import DeviceDetailScreen from './src/screens/devices/DeviceDetailScreen';
import DeviceFormScreen from './src/screens/devices/DeviceFormScreen';

// Vehicles
import VehiclesListScreen from './src/screens/vehicles/VehiclesListScreen';
import VehicleDetailScreen from './src/screens/vehicles/VehicleDetailScreen';
import VehicleFormScreen from './src/screens/vehicles/VehicleFormScreen';

// Rentals
import RentalsListScreen from './src/screens/rentals/RentalsListScreen';
import RentalDetailScreen from './src/screens/rentals/RentalDetailScreen';
import RentalFormScreen from './src/screens/rentals/RentalFormScreen';

// Auth (Forgot Password Flow)
import RegisterScreen from './src/screens/auth/RegisterScreen';
import ForgotPasswordScreen from './src/screens/auth/ForgotPasswordScreen';
import OTPValidationScreen from './src/screens/auth/OTPValidationScreen';
import ResetPasswordScreen from './src/screens/auth/ResetPasswordScreen';
import ProfileScreen from './src/screens/auth/ProfileScreen';

const Drawer = createDrawerNavigator();
const Stack = createNativeStackNavigator();

function DrawerNavigator({ navigation }) {
  const performLogout = async () => {
    try {
      await authService.logout();
      navigation.reset({
        index: 0,
        routes: [{ name: 'Login' }],
      });
    } catch (error) {
      console.error('Logout error:', error);
      // Navigate to login anyway
      navigation.reset({
        index: 0,
        routes: [{ name: 'Login' }],
      });
    }
  };

  const handleLogout = async () => {
    // For web, use window.confirm
    if (Platform.OS === 'web') {
      const confirmed = window.confirm('Are you sure you want to logout?');
      if (confirmed) {
        await performLogout();
      }
    } else {
      // For mobile, use Alert
      Alert.alert(
        'Logout',
        'Are you sure you want to logout?',
        [
          {
            text: 'No',
            style: 'cancel',
          },
          {
            text: 'Yes',
            onPress: performLogout,
          },
        ],
        { cancelable: false }
      );
    }
  };

  return (
    <Drawer.Navigator
      screenOptions={{
        headerShown: false,
        drawerStyle: {
          backgroundColor: '#fff',
          width: 250,
        },
        drawerActiveTintColor: '#007AFF',
        drawerInactiveTintColor: '#666',
        drawerLabelStyle: {
          fontSize: 16,
          fontWeight: '600',
        },
      }}
    >
      <Drawer.Screen
        name="Home"
        component={HomeScreen}
        options={{
          drawerLabel: 'Home',
        }}
      />
      {/* <Drawer.Screen
        name="Page1"
        component={Page1}
        options={{
          drawerLabel: 'Page 1',
        }}
      />
      <Drawer.Screen
        name="Page2"
        component={Page2}
        options={{
          drawerLabel: 'Page 2',
        }}
      /> */}
      <Drawer.Screen
        name="Customers"
        component={CustomersListScreen}
        options={{
          drawerLabel: 'Customers',
        }}
      />
      <Drawer.Screen
        name="Devices"
        component={DevicesListScreen}
        options={{
          drawerLabel: 'Devices',
        }}
      />
      <Drawer.Screen
        name="Vehicles"
        component={VehiclesListScreen}
        options={{
          drawerLabel: 'Vehicles',
        }}
      />
      <Drawer.Screen
        name="Rentals"
        component={RentalsListScreen}
        options={{
          drawerLabel: 'Rentals',
        }}
      />
      <Drawer.Screen
        name="Profile"
        component={ProfileScreen}
        options={{
          drawerLabel: 'Profile',
        }}
      />
      <Drawer.Screen
        name="Logout"
        component={HomeScreen}
        listeners={({ navigation: drawerNav }) => ({
          drawerItemPress: (e) => {
            e.preventDefault();
            // Close the drawer first
            drawerNav.closeDrawer();
            // Then show logout confirmation
            setTimeout(() => {
              handleLogout();
            }, 300);
          },
        })}
        options={{
          drawerLabel: 'Logout',
        }}
      />
    </Drawer.Navigator>
  );
}

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator screenOptions={{ headerShown: false }}>
        <Stack.Screen name="Login" component={LoginScreen} />
        <Stack.Screen name="Main" component={DrawerNavigator} />

        {/* Auth Screens */}
        <Stack.Screen name="Register" component={RegisterScreen} />
        <Stack.Screen name="ForgotPassword" component={ForgotPasswordScreen} />
        <Stack.Screen name="OTPValidation" component={OTPValidationScreen} />
        <Stack.Screen name="ResetPassword" component={ResetPasswordScreen} />

        {/* Customer Screens */}
        <Stack.Screen name="CustomerDetail" component={CustomerDetailScreen} />
        <Stack.Screen name="CustomerForm" component={CustomerFormScreen} />

        {/* Device Screens */}
        <Stack.Screen name="DeviceDetail" component={DeviceDetailScreen} />
        <Stack.Screen name="DeviceForm" component={DeviceFormScreen} />

        {/* Vehicle Screens */}
        <Stack.Screen name="VehicleDetail" component={VehicleDetailScreen} />
        <Stack.Screen name="VehicleForm" component={VehicleFormScreen} />

        {/* Rental Screens */}
        <Stack.Screen name="RentalDetail" component={RentalDetailScreen} />
        <Stack.Screen name="RentalForm" component={RentalFormScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
