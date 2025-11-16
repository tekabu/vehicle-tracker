# Vehicle Tracker API - cURL Examples

Base URL: `http://localhost:8031/api`

## Table of Contents
- [Authentication](#authentication)
- [Email Verification](#email-verification)
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

**Success Response (200):**
```json
{
  "status": true,
  "message": "User registered successfully. Please verify your email.",
  "action": "email_verification",
  "user": {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "email_verified_at": null,
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Note:** After registration, an OTP is automatically sent to the user's email for verification. The user must verify their email before they can login.

**Error Response (422 - Validation Error):**
```json
{
  "message": "The email has already been taken.",
  "errors": {
    "email": [
      "The email has already been taken."
    ]
  }
}
```

**Error Response (422 - Password Mismatch):**
```json
{
  "message": "The password field confirmation does not match.",
  "errors": {
    "password": [
      "The password field confirmation does not match."
    ]
  }
}
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

**Success Response (200):**
```json
{
  "status": true,
  "message": "Login successful",
  "access_token": "2|xyz789abc456def123ghi890jkl567mno234pqr901stu678vwx",
  "token_type": "Bearer",
  "user": {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com"
  }
}
```

**Error Response (401 - Invalid Credentials):**
```json
{
  "status": false,
  "message": "Invalid credentials"
}
```

**Error Response (403 - Email Not Verified):**
```json
{
  "status": false,
  "message": "Please verify your email address to continue",
  "action": "email_verification"
}
```

**Note:** If email is not verified, the app should allow the user to request a new OTP using the `/api/otp` endpoint.

**Error Response (429 - Rate Limit):**
```json
{
  "message": "Too Many Attempts."
}
```

### Logout
```bash
curl -X POST http://localhost:8031/api/logout \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Logout successful"
}
```

**Error Response (401 - Unauthenticated):**
```json
{
  "message": "Unauthenticated."
}
```

---

## Email Verification

After registering, users must verify their email address before they can login. This section covers the email verification flow.

### Request Email Verification OTP
This endpoint can be used to request a new OTP for email verification (e.g., if the initial OTP expired or the user didn't receive it).

```bash
curl -X POST http://localhost:8031/api/otp \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "OTP successfully sent to jo**@example.com"
}
```

**Error Response (400 - User Not Found):**
```json
{
  "status": false,
  "message": "The email field is required."
}
```

**Error Response (429 - Rate Limit):**
```json
{
  "message": "Too Many Attempts."
}
```

### Verify Email with OTP
Once the user receives the OTP via email, they can verify their email address using this endpoint.

```bash
curl -X POST http://localhost:8031/api/otp/validate \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com",
    "otp": "123456",
    "type": "email_verification"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Email verified successfully. You can now login."
}
```

**Error Response (401 - Invalid OTP):**
```json
{
  "status": false,
  "message": "Invalid or expired OTP"
}
```

**Error Response (400 - User Not Found):**
```json
{
  "status": false,
  "message": "The selected email is invalid."
}
```

**Flow:**
1. User registers → receives OTP email automatically
2. User submits OTP with `type=email_verification`
3. Email is verified (`email_verified_at` is set)
4. User can now login successfully

---

## Password Reset

The password reset flow is used when users forget their password. This is different from email verification.

### Generate OTP for Password Reset
```bash
curl -X POST http://localhost:8031/api/otp \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "OTP successfully sent to jo**@example.com"
}
```

**Error Response (400 - User Not Found):**
```json
{
  "status": false,
  "message": "The selected email is invalid."
}
```

**Error Response (429 - Rate Limit):**
```json
{
  "message": "Too Many Attempts."
}
```

### Validate OTP for Password Reset
**Note:** The `type` parameter is optional and defaults to `password_reset`. For password reset flow, you can omit it or explicitly set it to `password_reset`.

```bash
curl -X POST http://localhost:8031/api/otp/validate \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com",
    "otp": "123456",
    "type": "password_reset"
  }'
```

Or simply omit the `type` parameter (defaults to password_reset):
```bash
curl -X POST http://localhost:8031/api/otp/validate \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com",
    "otp": "123456"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "OTP is valid. You can now reset your password.",
  "reset_token": "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6",
  "expires_in": 900
}
```

**Error Response (401 - Invalid OTP):**
```json
{
  "status": false,
  "message": "Invalid or expired OTP"
}
```

**Error Response (400 - User Not Found):**
```json
{
  "status": false,
  "message": "The selected email is invalid."
}
```

### Reset Password
After receiving the `reset_token` from the OTP validation step, use it to reset the password.

```bash
curl -X POST http://localhost:8031/api/password/reset \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "email": "john@example.com",
    "reset_token": "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6",
    "password": "NewSecurePassword123!",
    "password_confirmation": "NewSecurePassword123!"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Password reset successfully. Please login with your new password."
}
```

**Error Response (401 - Invalid Token):**
```json
{
  "status": false,
  "message": "Invalid reset token"
}
```

**Error Response (401 - Expired Token):**
```json
{
  "status": false,
  "message": "Reset token has expired. Please request a new OTP."
}
```

**Error Response (400 - Validation Error):**
```json
{
  "status": false,
  "message": "The password field confirmation does not match."
}
```

**Password Reset Flow:**
1. User requests OTP via `/api/otp`
2. User validates OTP via `/api/otp/validate` (without `type` or with `type=password_reset`)
3. User receives `reset_token` (valid for 15 minutes)
4. User submits new password with `reset_token` to `/api/password/reset`
5. All user sessions are invalidated for security

---

## User Management

### Get User Profile
```bash
curl -X GET http://localhost:8031/api/profile \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "user": {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "email_verified_at": null,
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Error Response (401 - Unauthenticated):**
```json
{
  "message": "Unauthenticated."
}
```

### Update User Profile
```bash
curl -X PUT http://localhost:8031/api/profile \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "name": "John Updated",
    "email": "john.updated@example.com"
  }'
```

**Note:** You can also use PATCH method and update fields individually:
```bash
# Update only name
curl -X PATCH http://localhost:8031/api/profile \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "name": "John Updated"
  }'

# Update only email
curl -X PATCH http://localhost:8031/api/profile \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "email": "john.updated@example.com"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Profile updated successfully",
  "user": {
    "id": 1,
    "name": "John Updated",
    "email": "john.updated@example.com",
    "email_verified_at": null,
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T15:45:00.000000Z"
  }
}
```

**Error Response (400 - Validation Error):**
```json
{
  "status": false,
  "message": "The email has already been taken."
}
```

**Error Response (401 - Unauthenticated):**
```json
{
  "message": "Unauthenticated."
}
```

### Change Password (Authenticated)
```bash
curl -X POST http://localhost:8031/api/password/change \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "old_password": "OldPassword123!",
    "password": "NewPassword123!",
    "password_confirmation": "NewPassword123!"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Password changed successfully"
}
```

**Error Response (401 - Incorrect Old Password):**
```json
{
  "status": false,
  "message": "Old password is incorrect"
}
```

**Error Response (400 - Validation Error):**
```json
{
  "status": false,
  "message": "The password field confirmation does not match."
}
```

---

## Devices

### List All Devices
```bash
curl -X GET http://localhost:8031/api/devices \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Devices retrieved successfully",
  "devices": [
    {
      "id": 1,
      "device": "DEV-001",
      "created_at": "2025-11-16T10:30:00.000000Z",
      "updated_at": "2025-11-16T10:30:00.000000Z"
    },
    {
      "id": 2,
      "device": "DEV-002",
      "created_at": "2025-11-16T11:00:00.000000Z",
      "updated_at": "2025-11-16T11:00:00.000000Z"
    }
  ]
}
```

**Error Response (401 - Unauthenticated):**
```json
{
  "message": "Unauthenticated."
}
```

### Get a Specific Device
```bash
curl -X GET http://localhost:8031/api/devices/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Device retrieved successfully",
  "device": {
    "id": 1,
    "device": "DEV-001",
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Device not found"
}
```

### Create a Device
```bash
curl -X POST http://localhost:8031/api/devices \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "device": "DEV-001"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Device created successfully",
  "device": {
    "id": 1,
    "device": "DEV-001",
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Error Response (400 - Validation Error):**
```json
{
  "status": false,
  "message": "The device has already been taken."
}
```

### Update a Device
```bash
curl -X PUT http://localhost:8031/api/devices/1 \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "device": "DEV-001-UPDATED"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Device updated successfully",
  "device": {
    "id": 1,
    "device": "DEV-001-UPDATED",
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T12:00:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Device not found"
}
```

### Delete a Device
```bash
curl -X DELETE http://localhost:8031/api/devices/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Device deleted successfully",
  "device": {
    "id": 1,
    "device": "DEV-001",
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Device not found"
}
```

---

## Customers

### List All Customers
```bash
curl -X GET http://localhost:8031/api/customers \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Customers retrieved successfully",
  "customers": [
    {
      "id": 1,
      "name": "Jane Smith",
      "contact_no": "+1234567890",
      "address": "123 Main Street, City, Country",
      "created_at": "2025-11-16T10:30:00.000000Z",
      "updated_at": "2025-11-16T10:30:00.000000Z"
    }
  ]
}
```

**Error Response (401 - Unauthenticated):**
```json
{
  "message": "Unauthenticated."
}
```

### Get a Specific Customer
```bash
curl -X GET http://localhost:8031/api/customers/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "customer retrieved successfully",
  "customer": {
    "id": 1,
    "name": "Jane Smith",
    "contact_no": "+1234567890",
    "address": "123 Main Street, City, Country",
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "customer not found"
}
```

### Create a Customer
```bash
curl -X POST http://localhost:8031/api/customers \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "name": "Jane Smith",
    "contact_no": "+1234567890",
    "address": "123 Main Street, City, Country"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Customer created successfully",
  "customer": {
    "id": 1,
    "name": "Jane Smith",
    "contact_no": "+1234567890",
    "address": "123 Main Street, City, Country",
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Error Response (400 - Validation Error):**
```json
{
  "status": false,
  "message": "The name field is required."
}
```

### Update a Customer
```bash
curl -X PUT http://localhost:8031/api/customers/1 \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "name": "Jane Doe",
    "contact_no": "+1234567890",
    "address": "456 Oak Avenue, City, Country"
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Customer updated successfully",
  "customer": {
    "id": 1,
    "name": "Jane Doe",
    "contact_no": "+1234567890",
    "address": "456 Oak Avenue, City, Country",
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T12:00:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Customer not found"
}
```

### Delete a Customer
```bash
curl -X DELETE http://localhost:8031/api/customers/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Customer deleted successfully",
  "customer": {
    "id": 1,
    "name": "Jane Smith",
    "contact_no": "+1234567890",
    "address": "123 Main Street, City, Country",
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Customer not found"
}
```

---

## Vehicles

### List All Vehicles
```bash
curl -X GET http://localhost:8031/api/vehicles \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Vehicles retrieved successfully",
  "vehicles": [
    {
      "id": 1,
      "plate_no": "ABC-1234",
      "car_type": "Toyota Camry",
      "device_id": 1,
      "created_at": "2025-11-16T10:30:00.000000Z",
      "updated_at": "2025-11-16T10:30:00.000000Z",
      "device": {
        "id": 1,
        "device": "DEV-001",
        "created_at": "2025-11-16T10:00:00.000000Z",
        "updated_at": "2025-11-16T10:00:00.000000Z"
      }
    }
  ]
}
```

**Error Response (401 - Unauthenticated):**
```json
{
  "message": "Unauthenticated."
}
```

### Get a Specific Vehicle
```bash
curl -X GET http://localhost:8031/api/vehicles/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Vehicle retrieved successfully",
  "vehicle": {
    "id": 1,
    "plate_no": "ABC-1234",
    "car_type": "Toyota Camry",
    "device_id": 1,
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z",
    "device": {
      "id": 1,
      "device": "DEV-001",
      "created_at": "2025-11-16T10:00:00.000000Z",
      "updated_at": "2025-11-16T10:00:00.000000Z"
    }
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Vehicle not found"
}
```

### Create a Vehicle
```bash
curl -X POST http://localhost:8031/api/vehicles \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "plate_no": "ABC-1234",
    "car_type": "Toyota Camry",
    "device_id": 1
  }'
```

**Note:** The `device_id` field is optional. If provided, it must reference a valid device ID.

**Success Response (200):**
```json
{
  "status": true,
  "message": "Vehicle created successfully",
  "vehicle": {
    "id": 1,
    "plate_no": "ABC-1234",
    "car_type": "Toyota Camry",
    "device_id": 1,
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Error Response (400 - Validation Error):**
```json
{
  "status": false,
  "message": "The plate no has already been taken."
}
```

### Update a Vehicle
```bash
curl -X PUT http://localhost:8031/api/vehicles/1 \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "plate_no": "ABC-1234",
    "car_type": "Toyota Camry Hybrid",
    "device_id": 2
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Vehicle updated successfully",
  "vehicle": {
    "id": 1,
    "plate_no": "ABC-1234",
    "car_type": "Toyota Camry Hybrid",
    "device_id": 2,
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T12:00:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Vehicle not found"
}
```

### Delete a Vehicle
```bash
curl -X DELETE http://localhost:8031/api/vehicles/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Vehicle deleted successfully",
  "vehicle": {
    "id": 1,
    "plate_no": "ABC-1234",
    "car_type": "Toyota Camry",
    "device_id": 1,
    "created_at": "2025-11-16T10:30:00.000000Z",
    "updated_at": "2025-11-16T10:30:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Vehicle not found"
}
```

---

## Rentals

### List All Rentals
```bash
curl -X GET http://localhost:8031/api/rentals \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Rentals retrieved successfully",
  "rentals": [
    {
      "id": 1,
      "customer_id": 1,
      "vehicle_id": 1,
      "started_at": "2025-11-15T09:00:00.000000Z",
      "ended_at": null,
      "created_at": "2025-11-15T08:30:00.000000Z",
      "updated_at": "2025-11-15T09:00:00.000000Z"
    }
  ]
}
```

**Note:** To include related customer and vehicle data, add the `include` query parameter:
```bash
curl -X GET "http://localhost:8031/api/rentals?include=customer,vehicle" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Response with includes:**
```json
{
  "status": true,
  "message": "Rentals retrieved successfully",
  "rentals": [
    {
      "id": 1,
      "customer_id": 1,
      "vehicle_id": 1,
      "started_at": "2025-11-15T09:00:00.000000Z",
      "ended_at": null,
      "created_at": "2025-11-15T08:30:00.000000Z",
      "updated_at": "2025-11-15T09:00:00.000000Z",
      "customer": {
        "id": 1,
        "name": "Jane Smith",
        "contact_no": "+1234567890",
        "address": "123 Main Street, City, Country"
      },
      "vehicle": {
        "id": 1,
        "plate_no": "ABC-1234",
        "car_type": "Toyota Camry",
        "device_id": 1
      }
    }
  ]
}
```

**Error Response (401 - Unauthenticated):**
```json
{
  "message": "Unauthenticated."
}
```

### Get a Specific Rental
```bash
curl -X GET http://localhost:8031/api/rentals/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Rental retrieved successfully",
  "rental": {
    "id": 1,
    "customer_id": 1,
    "vehicle_id": 1,
    "started_at": "2025-11-15T09:00:00.000000Z",
    "ended_at": null,
    "created_at": "2025-11-15T08:30:00.000000Z",
    "updated_at": "2025-11-15T09:00:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Rental not found"
}
```

### Create a Rental
```bash
curl -X POST http://localhost:8031/api/rentals \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "customer_id": 1,
    "vehicle_id": 1
  }'
```

**Success Response (201):**
```json
{
  "status": true,
  "message": "Rental created successfully",
  "rental": {
    "id": 1,
    "customer_id": 1,
    "vehicle_id": 1,
    "started_at": null,
    "ended_at": null,
    "created_at": "2025-11-15T08:30:00.000000Z",
    "updated_at": "2025-11-15T08:30:00.000000Z"
  }
}
```

**Error Response (400 - Validation Error):**
```json
{
  "status": false,
  "message": "The customer id field is required."
}
```

**Error Response (409 - Vehicle Already Rented):**
```json
{
  "status": false,
  "message": "This vehicle is already rented and not available"
}
```

### Update a Rental
```bash
curl -X PUT http://localhost:8031/api/rentals/1 \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -d '{
    "customer_id": 1,
    "vehicle_id": 2
  }'
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Rental updated successfully",
  "rental": {
    "id": 1,
    "customer_id": 1,
    "vehicle_id": 2,
    "started_at": null,
    "ended_at": null,
    "created_at": "2025-11-15T08:30:00.000000Z",
    "updated_at": "2025-11-15T10:00:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Rental not found"
}
```

### Start a Rental
```bash
curl -X POST http://localhost:8031/api/rentals/1/start \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Rental started successfully",
  "rental": {
    "id": 1,
    "customer_id": 1,
    "vehicle_id": 1,
    "started_at": "2025-11-15T09:00:00.000000Z",
    "ended_at": null,
    "created_at": "2025-11-15T08:30:00.000000Z",
    "updated_at": "2025-11-15T09:00:00.000000Z"
  }
}
```

**Error Response (400 - Already Started):**
```json
{
  "status": false,
  "message": "Rental already started",
  "rental": {
    "id": 1,
    "customer_id": 1,
    "vehicle_id": 1,
    "started_at": "2025-11-15T09:00:00.000000Z",
    "ended_at": null,
    "created_at": "2025-11-15T08:30:00.000000Z",
    "updated_at": "2025-11-15T09:00:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Rental not found"
}
```

### End a Rental
```bash
curl -X POST http://localhost:8031/api/rentals/1/end \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Rental ended successfully",
  "rental": {
    "id": 1,
    "customer_id": 1,
    "vehicle_id": 1,
    "started_at": "2025-11-15T09:00:00.000000Z",
    "ended_at": "2025-11-20T17:00:00.000000Z",
    "created_at": "2025-11-15T08:30:00.000000Z",
    "updated_at": "2025-11-20T17:00:00.000000Z"
  }
}
```

**Error Response (400 - Not Started):**
```json
{
  "status": false,
  "message": "Rental not yet started",
  "rental": {
    "id": 1,
    "customer_id": 1,
    "vehicle_id": 1,
    "started_at": null,
    "ended_at": null,
    "created_at": "2025-11-15T08:30:00.000000Z",
    "updated_at": "2025-11-15T08:30:00.000000Z"
  }
}
```

**Error Response (400 - Already Ended):**
```json
{
  "status": false,
  "message": "Rental already ended",
  "rental": {
    "id": 1,
    "customer_id": 1,
    "vehicle_id": 1,
    "started_at": "2025-11-15T09:00:00.000000Z",
    "ended_at": "2025-11-20T17:00:00.000000Z",
    "created_at": "2025-11-15T08:30:00.000000Z",
    "updated_at": "2025-11-20T17:00:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Rental not found"
}
```

### Delete a Rental
```bash
curl -X DELETE http://localhost:8031/api/rentals/1 \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "status": true,
  "message": "Rental deleted successfully",
  "rental": {
    "id": 1,
    "customer_id": 1,
    "vehicle_id": 1,
    "started_at": "2025-11-15T09:00:00.000000Z",
    "ended_at": "2025-11-20T17:00:00.000000Z",
    "created_at": "2025-11-15T08:30:00.000000Z",
    "updated_at": "2025-11-20T17:00:00.000000Z"
  }
}
```

**Error Response (404 - Not Found):**
```json
{
  "status": false,
  "message": "Rental not found"
}
```

---

## Locations

### Get Location (GPS Device Endpoint)
```bash
curl -X GET "http://localhost:8031/api/location?lat=40.7128&lng=-74.0060" \
  -H "Accept: application/json"
```

**Query Parameters:**
- `lat` (optional): Latitude
- `lng` (optional): Longitude

**Note:** This is currently a mock endpoint for testing purposes. Location data is NOT persisted to the database.

**Success Response (200):**
```json
{
  "success": true,
  "message": "Location saved",
  "location": {
    "lat": "40.7128",
    "lng": "-74.0060"
  }
}
```

---

## Test Endpoint

### Test Authentication
```bash
curl -X GET http://localhost:8031/api/test \
  -H "Accept: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

**Success Response (200):**
```json
{
  "message": "API is working",
  "authenticated": true,
  "user": {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com"
  }
}
```

**Error Response (401 - Unauthenticated):**
```json
{
  "message": "Unauthenticated."
}
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
