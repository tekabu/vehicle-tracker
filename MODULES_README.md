# Vehicle Tracker Mobile - New Modules

This document provides an overview of the newly created modules for the Vehicle Tracker mobile application.

## Overview

Four new modules have been added to the application:
1. **Customers** - Manage customer information
2. **Devices** - Manage GPS tracking devices
3. **Vehicles** - Manage vehicle inventory
4. **Rentals** - Manage vehicle rentals with start/end tracking

## Project Structure

```
src/
├── components/
│   ├── Card.js              # Reusable card component with header, rows, sections
│   ├── Header.js            # Reusable header component with menu button
│   └── CustomDrawer.js      # Custom drawer/sidebar component
├── services/
│   ├── api.js               # Base API service with fetch wrapper
│   ├── authService.js       # Authentication methods
│   ├── customerService.js   # Customer CRUD operations
│   ├── deviceService.js     # Device CRUD operations
│   ├── vehicleService.js    # Vehicle CRUD operations
│   └── rentalService.js     # Rental CRUD + start/end operations
└── screens/
    ├── customers/
    │   ├── CustomersListScreen.js    # List all customers with cards
    │   ├── CustomerDetailScreen.js   # View customer details
    │   └── CustomerFormScreen.js     # Create/edit customer
    ├── devices/
    │   ├── DevicesListScreen.js      # List all devices with cards
    │   ├── DeviceDetailScreen.js     # View device details
    │   └── DeviceFormScreen.js       # Create/edit device
    ├── vehicles/
    │   ├── VehiclesListScreen.js     # List all vehicles with cards
    │   ├── VehicleDetailScreen.js    # View vehicle details
    │   └── VehicleFormScreen.js      # Create/edit vehicle
    └── rentals/
        ├── RentalsListScreen.js      # List all rentals with cards
        ├── RentalDetailScreen.js     # View rental + start/end actions
        └── RentalFormScreen.js       # Create/edit rental
```

## Features

### Common Features (All Modules)
- **Card-based UI** - Clean, modern card layout instead of tables
- **CRUD Operations** - Create, Read, Update, Delete functionality
- **Pull to Refresh** - Swipe down to reload data
- **Error Handling** - User-friendly error messages
- **Loading States** - Activity indicators during data fetch
- **Empty States** - Helpful messages when no data exists
- **Validation** - Form validation with error messages
- **Responsive Design** - Optimized for mobile devices

### Customers Module
- Manage customer information (name, email, phone, address, license number)
- View customer details
- Create and edit customers
- Delete customers with confirmation

### Devices Module
- Manage GPS tracking devices
- Device status indicators (active/inactive)
- View device details
- Create and edit devices
- Delete devices with confirmation

### Vehicles Module
- Manage vehicle inventory
- Vehicle status badges (available/rented/maintenance)
- Link vehicles to GPS devices
- Comprehensive vehicle information (make, model, year, color, VIN, plate number)
- View device information attached to vehicle
- Create and edit vehicles
- Delete vehicles with confirmation

### Rentals Module
- Manage vehicle rentals
- Create rentals with vehicle and customer selection
- **Start Rental** - Record odometer at pickup
- **End Rental** - Record odometer, fuel level, and condition notes
- Rental status tracking (pending/active/completed/cancelled)
- Financial tracking (daily rate, total amount, deposit)
- View customer and vehicle information
- Create and edit rentals
- Delete rentals with confirmation

## API Integration

The app connects to a Laravel backend API at `http://localhost:8031/api`

### Authentication
- Bearer token-based authentication
- Token stored in API service after login/register

### Available Endpoints

#### Customers
- `GET /api/customers` - List all customers
- `GET /api/customers/:id` - Get customer details
- `POST /api/customers` - Create customer
- `PUT /api/customers/:id` - Update customer
- `DELETE /api/customers/:id` - Delete customer

#### Devices
- `GET /api/devices` - List all devices
- `GET /api/devices/:id` - Get device details
- `POST /api/devices` - Create device
- `PUT /api/devices/:id` - Update device
- `DELETE /api/devices/:id` - Delete device

#### Vehicles
- `GET /api/vehicles` - List all vehicles
- `GET /api/vehicles/:id` - Get vehicle details (includes device info)
- `POST /api/vehicles` - Create vehicle
- `PUT /api/vehicles/:id` - Update vehicle
- `DELETE /api/vehicles/:id` - Delete vehicle

#### Rentals
- `GET /api/rentals` - List all rentals (includes vehicle and customer info)
- `GET /api/rentals/:id` - Get rental details
- `POST /api/rentals` - Create rental
- `PUT /api/rentals/:id` - Update rental
- `DELETE /api/rentals/:id` - Delete rental
- `POST /api/rentals/:id/start` - Start rental (sets actual_start_date and odometer_start)
- `POST /api/rentals/:id/end` - End rental (sets actual_end_date, odometer_end, fuel_level_end)

## Navigation

All modules are accessible from the sidebar drawer:
- Home
- Page 1
- Page 2
- **Customers** ← NEW
- **Devices** ← NEW
- **Vehicles** ← NEW
- **Rentals** ← NEW

### Navigation Flow

**Customers:**
- List → Detail → Edit
- List → Create

**Devices:**
- List → Detail → Edit
- List → Create

**Vehicles:**
- List → Detail → Edit
- List → Create

**Rentals:**
- List → Detail → Start/End → List
- List → Create

## Setup Instructions

1. **Install Dependencies**
   ```bash
   npm install
   ```

2. **Configure API URL**
   Update the `API_BASE_URL` in `src/services/api.js` to match your Laravel backend:
   ```javascript
   const API_BASE_URL = 'http://your-backend-url/api';
   ```

3. **Run the App**
   ```bash
   npm start
   # Then press 'a' for Android or 'i' for iOS
   ```

## Components Reference

### Card Component
Reusable card component with sub-components:
- `<Card>` - Main card wrapper (supports onPress for clickable cards)
- `<CardHeader>` - Card title and subtitle with optional right element
- `<CardRow>` - Label-value row display
- `<CardSection>` - Section wrapper for grouping content

### Header Component
Standard header with:
- Menu button (opens drawer)
- Title
- Optional right element (e.g., Add button, Edit button)

## Styling

The app uses a consistent design system:
- **Primary Color:** #007AFF (iOS blue)
- **Success Color:** #34C759 (green)
- **Warning Color:** #FF9500 (orange)
- **Danger Color:** #FF3B30 (red)
- **Background:** #f5f5f5
- **Card Background:** #fff
- **Text Primary:** #333
- **Text Secondary:** #666
- **Border Radius:** 8-12px
- **Shadows:** Subtle shadows for depth

## Next Steps

1. **Update API URL** - Change `localhost:8031` to your actual backend URL
2. **Test Authentication** - Ensure login works and token is stored
3. **Test CRUD Operations** - Verify all create, read, update, delete operations
4. **Test Rental Flow** - Test the complete rental lifecycle (create → start → end)
5. **Error Handling** - Test error scenarios and network failures
6. **Add Features** - Consider adding search, filters, pagination as needed

## Dependencies

New dependency added:
- `@react-native-picker/picker` - For dropdown selectors in forms

## Notes

- All forms include validation
- Delete operations require confirmation
- Status badges use color coding for quick visual identification
- The rental start/end functionality is only available in the detail screen
- All API responses follow the Laravel API format documented in `API_CURL_EXAMPLES.md`
