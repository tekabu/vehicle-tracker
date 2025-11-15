<!DOCTYPE html>
<html>
<head>
    <style>
        body { font-family: Arial, sans-serif; line-height: 1.6; }
        .container { max-width: 600px; margin: 0 auto; padding: 20px; }
        .otp-box { background: #f4f4f4; padding: 20px; text-align: center; font-size: 32px; font-weight: bold; letter-spacing: 8px; margin: 20px 0; }
        .footer { color: #666; font-size: 12px; margin-top: 20px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Your OTP Code</h2>
        <p>Use the following code to verify your email:</p>
        <div class="otp-box">{{ $otp }}</div>
        <p>This code will expire in {{ $minutes }} minutes.</p>
        <p class="footer">If you didn't request this code, please ignore this email.</p>
    </div>
</body>
</html>