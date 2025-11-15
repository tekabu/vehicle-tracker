# Vehicle Tracker API - cURL Examples

Base URL: `http://localhost:8031/api`

## Table of Contents
- [Authentication](#authentication)
- [Password Reset](#password-reset)
- [User Management](#user-management)
- [Devices](#devices)
- [Customers](#customers)
- [Vehicles](#vehicles)
- [Rentals](#rentals)
- [Locations](#locations)

---

## Authentication

### Register a New User
```bash
curl -X POST http://localhost:8031/api/register \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "SecurePassword123!",
    "password_confirmation": "SecurePassword123!"
  }'
```

### Login
```bash
curl -X POST http://localhost:8031/api/login \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "SecurePassword123!"
  }'
```

**Response includes:**
```json
{
  "token": "your-auth-token-here",
  "user": { ... }
}
```

### Logout
```bash
curl -X POST http://localhost:8031/api/logout \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

---

## Password Reset

### Generate OTP
```bash
curl -X POST http://localhost:8031/api/otp \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com"
  }'
```

### Validate OTP
```bash
curl -X POST http://localhost:8031/api/otp/validate \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com",
    "otp": "123456"
  }'
```

**Response includes:**
```json
{
  "reset_token": "reset-token-here"
}
```

### Reset Password
```bash
curl -X POST http://localhost:8031/api/password/reset \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com",
    "token": "reset-token-from-validation",
    "password": "NewSecurePassword123!",
    "password_confirmation": "NewSecurePassword123!"
  }'
```

---

## User Management

### Change Password (Authenticated)
```bash
curl -X POST http://localhost:8031/api/password/change \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "current_password": "OldPassword123!",
    "password": "NewPassword123!",
    "password_confirmation": "NewPassword123!"
  }'
```

---

## Devices

### List All Devices
```bash
curl -X GET http://localhost:8031/api/devices \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

### Get a Specific Device
```bash
curl -X GET http://localhost:8031/api/devices/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

### Create a Device
```bash
curl -X POST http://localhost:8031/api/devices \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "device_id": "DEV-001",
    "type": "GPS Tracker",
    "status": "active"
  }'
```

### Update a Device
```bash
curl -X PUT http://localhost:8031/api/devices/1 \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "device_id": "DEV-001-UPDATED",
    "type": "GPS Tracker Pro",
    "status": "active"
  }'
```

### Delete a Device
```bash
curl -X DELETE http://localhost:8031/api/devices/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

---

## Customers

### List All Customers
```bash
curl -X GET http://localhost:8031/api/customers \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

### Get a Specific Customer
```bash
curl -X GET http://localhost:8031/api/customers/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

### Create a Customer
```bash
curl -X POST http://localhost:8031/api/customers \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "name": "Jane Smith",
    "email": "jane@example.com",
    "phone": "+1234567890",
    "address": "123 Main Street, City, Country",
    "license_number": "DL123456"
  }'
```

### Update a Customer
```bash
curl -X PUT http://localhost:8031/api/customers/1 \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "phone": "+1234567890",
    "address": "456 Oak Avenue, City, Country",
    "license_number": "DL123456"
  }'
```

### Delete a Customer
```bash
curl -X DELETE http://localhost:8031/api/customers/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

---

## Vehicles

### List All Vehicles
```bash
curl -X GET http://localhost:8031/api/vehicles \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

### Get a Specific Vehicle
```bash
curl -X GET http://localhost:8031/api/vehicles/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

### Create a Vehicle
```bash
curl -X POST http://localhost:8031/api/vehicles \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "plate_number": "ABC-1234",
    "make": "Toyota",
    "model": "Camry",
    "year": 2023,
    "color": "Silver",
    "vin": "1HGBH41JXMN109186",
    "device_id": 1,
    "status": "available"
  }'
```

### Update a Vehicle
```bash
curl -X PUT http://localhost:8031/api/vehicles/1 \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "plate_number": "ABC-1234",
    "make": "Toyota",
    "model": "Camry Hybrid",
    "year": 2023,
    "color": "Blue",
    "vin": "1HGBH41JXMN109186",
    "device_id": 1,
    "status": "available"
  }'
```

### Delete a Vehicle
```bash
curl -X DELETE http://localhost:8031/api/vehicles/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

---

## Rentals

### List All Rentals
```bash
curl -X GET http://localhost:8031/api/rentals \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

### Get a Specific Rental
```bash
curl -X GET http://localhost:8031/api/rentals/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

### Create a Rental
```bash
curl -X POST http://localhost:8031/api/rentals \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "vehicle_id": 1,
    "customer_id": 1,
    "start_date": "2025-11-15",
    "end_date": "2025-11-20",
    "daily_rate": 50.00,
    "deposit": 200.00,
    "notes": "Customer requested child seat"
  }'
```

### Update a Rental
```bash
curl -X PUT http://localhost:8031/api/rentals/1 \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "vehicle_id": 1,
    "customer_id": 1,
    "start_date": "2025-11-15",
    "end_date": "2025-11-22",
    "daily_rate": 50.00,
    "deposit": 200.00,
    "notes": "Extended rental period"
  }'
```

### Start a Rental
```bash
curl -X POST http://localhost:8031/api/rentals/1/start \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "odometer_start": 15000
  }'
```

### End a Rental
```bash
curl -X POST http://localhost:8031/api/rentals/1/end \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "odometer_end": 15500,
    "fuel_level": "full",
    "condition_notes": "Vehicle returned in good condition"
  }'
```

### Delete a Rental
```bash
curl -X DELETE http://localhost:8031/api/rentals/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

---

## Locations

### Get Location (GPS Device Endpoint)
```bash
curl -X GET "http://localhost:8031/api/location?device_id=DEV-001&lat=40.7128&lng=-74.0060&speed=45&heading=90&altitude=10" \
  -H "Accept: application/json"
```

**Query Parameters:**
- `device_id` (required): Device identifier
- `lat` (required): Latitude
- `lng` (required): Longitude
- `speed` (optional): Speed in km/h
- `heading` (optional): Heading in degrees (0-360)
- `altitude` (optional): Altitude in meters

---

## Test Endpoint

### Test Authentication
```bash
curl -X GET http://localhost:8031/api/test \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

---

## Notes

1. **Rate Limiting:**
   - Registration and login endpoints: 10 requests per minute
   - Password reset endpoints: 5 requests per 10 minutes

2. **Authentication:**
   - Most endpoints require authentication via Bearer token
   - Include the token in the `Authorization` header as shown in the examples

3. **Response Format:**
   - All responses are in JSON format
   - Always include `Accept: application/json` header

4. **Error Responses:**
   - 401: Unauthorized (missing or invalid token)
   - 422: Validation error (check response for specific field errors)
   - 429: Too many requests (rate limit exceeded)
   - 404: Resource not found
   - 500: Server error

5. **Environment Variables:**
   - Replace `localhost:8031` with your actual server URL if different
   - Store tokens securely and never commit them to version control
