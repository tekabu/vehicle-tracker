# Forgot Password Implementation

This document describes the forgot password flow implementation with OTP validation.

## Overview

The forgot password flow consists of three screens:
1. **ForgotPasswordScreen** - User enters email to receive OTP
2. **OTPValidationScreen** - User enters 6-digit OTP received via email
3. **ResetPasswordScreen** - User sets new password

## Flow Diagram

```
LoginScreen
    |
    | (Click "Forgot Password?")
    v
ForgotPasswordScreen (Enter Email)
    |
    | (API: POST /api/otp)
    | Success: Show message -> Click "Continue"
    v
OTPValidationScreen (Enter 6-digit OTP)
    |
    | (API: POST /api/otp/validate)
    | Success: Show message -> Click "Continue"
    v
ResetPasswordScreen (Enter New Password)
    |
    | (API: POST /api/password/reset)
    | Success: Show message -> Click "OK"
    v
LoginScreen (Navigation resets)
```

## Screen Details

### 1. ForgotPasswordScreen

**Location:** [src/screens/auth/ForgotPasswordScreen.js](src/screens/auth/ForgotPasswordScreen.js)

**Features:**
- Email input with validation
- Send OTP button with loading state
- Back to Login button
- API call to `/api/otp`

**User Flow:**
1. User enters email address
2. Clicks "Send OTP"
3. On success: Alert shows API message (or "OTP has been sent to your email")
4. User clicks "Continue" -> Navigates to OTPValidationScreen

**Error Handling:**
- Network errors: "Unable to connect to server. Please check your internet connection."
- 404 (User not found): Shows API message or "No account found with this email address"
- 429 (Rate limit): Shows API message or "Too many attempts. Please try again later."
- Other errors: Shows API message or "Something went wrong. Please try again."

**API Request:**
```javascript
POST /api/otp
{
  "email": "user@example.com"
}
```

**API Response (Success):**
```json
{
  "message": "OTP sent to your email"
}
```

### 2. OTPValidationScreen

**Location:** [src/screens/auth/OTPValidationScreen.js](src/screens/auth/OTPValidationScreen.js)

**Features:**
- 6-digit OTP input (number pad)
- Validate OTP button with loading state
- Resend OTP functionality
- Back button
- API call to `/api/otp/validate`

**User Flow:**
1. User enters 6-digit OTP received via email
2. Clicks "Validate OTP"
3. On success: Alert shows API message (or "OTP validated successfully")
4. User clicks "Continue" -> Navigates to ResetPasswordScreen with reset_token

**Additional Features:**
- **Resend OTP**: If user didn't receive code, they can click "Resend OTP"
- Displays email address for user confirmation
- Large, centered input with letter spacing for easy reading

**Error Handling:**
- Network errors: "Unable to connect to server. Please check your internet connection."
- 400 (Invalid OTP): Shows API message or "Invalid or expired OTP. Please try again."
- 404 (User not found): Shows API message or "User not found"
- Other errors: Shows API message or "Something went wrong. Please try again."

**API Request:**
```javascript
POST /api/otp/validate
{
  "email": "user@example.com",
  "otp": "123456"
}
```

**API Response (Success):**
```json
{
  "message": "OTP validated successfully",
  "reset_token": "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6"
}
```

### 3. ResetPasswordScreen

**Location:** [src/screens/auth/ResetPasswordScreen.js](src/screens/auth/ResetPasswordScreen.js)

**Features:**
- New password input (secure)
- Confirm password input (secure)
- Password validation (minimum 8 characters)
- Reset Password button with loading state
- Back button
- API call to `/api/password/reset`

**User Flow:**
1. User enters new password (min 8 characters)
2. User confirms password
3. Clicks "Reset Password"
4. On success: Alert shows API message (or "Password reset successfully")
5. User clicks "OK" -> Navigation resets to LoginScreen

**Validation:**
- Password must not be empty
- Password must be at least 8 characters
- Confirm password must not be empty
- Passwords must match

**Error Handling:**
- Network errors: "Unable to connect to server. Please check your internet connection."
- 400 (Invalid token): Shows API message or "Reset token is invalid or expired. Please request a new OTP."
- 422 (Validation error): Shows specific field error or API message
- Other errors: Shows API message or "Something went wrong. Please try again."

**API Request:**
```javascript
POST /api/password/reset
{
  "email": "user@example.com",
  "token": "reset-token-from-validation",
  "password": "NewSecurePassword123!",
  "password_confirmation": "NewSecurePassword123!"
}
```

**API Response (Success):**
```json
{
  "message": "Password reset successfully"
}
```

## Updated Components

### LoginScreen Updates

**Location:** [src/screens/LoginScreen.js](src/screens/LoginScreen.js)

**Changes:**
1. Added `authService` import
2. Updated `handleLogin` to use API authentication
3. Added loading state with ActivityIndicator
4. Added "Forgot Password?" link navigation
5. Improved error handling with specific messages

**Features:**
- API integration with `/api/login`
- Loading indicator during login
- Success message alert before navigation
- Comprehensive error handling:
  - Network errors
  - Invalid credentials (401)
  - Rate limiting (429)
  - Server errors

## Navigation Setup

All auth screens are added to the Stack Navigator in [App.js](App.js):

```javascript
// Auth Screens (Forgot Password Flow)
<Stack.Screen name="ForgotPassword" component={ForgotPasswordScreen} />
<Stack.Screen name="OTPValidation" component={OTPValidationScreen} />
<Stack.Screen name="ResetPassword" component={ResetPasswordScreen} />
```

## Error Message Strategy

The implementation follows a consistent error handling pattern:

1. **Check for network errors** (status === 0):
   - Display: "Unable to connect to server. Please check your internet connection."

2. **Check for specific HTTP status codes**:
   - 400: Invalid data or expired tokens
   - 401: Invalid credentials
   - 404: Resource not found (user doesn't exist)
   - 422: Validation errors
   - 429: Rate limiting

3. **Use API message if available**:
   - All API responses include a `message` field
   - Display this message to the user

4. **Fallback message**:
   - If no specific message: "Something went wrong. Please try again."

## Design Consistency

All auth screens follow the same design pattern:

- **Colors:**
  - Primary: #007AFF (iOS blue)
  - Background: #f5f5f5
  - Text: #333 (primary), #666 (secondary)
  - Input background: #fff

- **Layout:**
  - Centered content with padding
  - Title and subtitle header
  - Form inputs with labels
  - Primary action button
  - Secondary action link/button

- **Typography:**
  - Title: 28px, bold
  - Subtitle: 14px, regular
  - Labels: 14px, semibold
  - Input text: 16px

- **Components:**
  - KeyboardAvoidingView for iOS
  - ActivityIndicator for loading states
  - Alert for success/error messages

## API Configuration

The base API URL is configured in [src/services/api.js:3](src/services/api.js#L3):

```javascript
const API_BASE_URL = 'http://localhost:8031/api';
```

**To change the API URL:**
1. Open `src/services/api.js`
2. Update the `API_BASE_URL` constant
3. Save the file

## Testing the Flow

1. **Test Forgot Password (Email Entry):**
   - Open the app
   - Click "Forgot Password?"
   - Enter a valid email
   - Click "Send OTP"
   - Verify OTP email is received

2. **Test OTP Validation:**
   - Enter the 6-digit OTP from email
   - Click "Validate OTP"
   - Verify success message

3. **Test Password Reset:**
   - Enter new password (min 8 chars)
   - Confirm password
   - Click "Reset Password"
   - Verify success message
   - Verify navigation to Login screen

4. **Test Resend OTP:**
   - On OTP screen, click "Resend OTP"
   - Verify new OTP is sent

5. **Test Error Scenarios:**
   - Invalid email format
   - Non-existent email
   - Wrong OTP
   - Expired OTP
   - Mismatched passwords
   - Short password

## Security Features

1. **OTP Expiration:** OTPs expire after a certain time (configured on backend)
2. **Rate Limiting:** API prevents brute force attacks with rate limits
3. **Token-based Reset:** Reset token required for password change
4. **Password Validation:** Minimum 8 characters enforced
5. **Secure Text Entry:** Password fields use `secureTextEntry`

## Next Steps

1. **Configure Backend URL:** Update `API_BASE_URL` in api.js
2. **Test with Real Backend:** Ensure all endpoints are working
3. **Customize Messages:** Adjust error messages to match your brand
4. **Add Analytics:** Track forgot password flow usage
5. **Email Template:** Ensure OTP email template is user-friendly
