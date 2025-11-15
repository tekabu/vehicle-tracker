<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Validator;
use Illuminate\Http\Request;
use Ichtrojan\Otp\Otp;
use App\Mail\OtpMail;
use Illuminate\Support\Facades\Mail;
use App\Models\PasswordResetToken;
use Illuminate\Support\Str;

class OtpController extends Controller
{
    public function generateOtp(Request $request) 
    {
        $validator = Validator::make($request->all(),
        [
            "email" => "required|string|email|exists:users,email",
        ]);

        if ($validator->fails()) 
        {
            $errorMessage = $validator->errors()->first();
            
            $response = [
                "status" => false,
                "message" => $errorMessage
            ];
            
            return response()->json($response, 400);
        }
        
        $otp = (new Otp)->generate($request->email, 'numeric', env('OTP_LENGTH', 6), env('OTP_EXPIRATION', 10));
        
        Mail::to($request->email)->send(
            new OtpMail(
                otp: $otp->token,
                minutes: env('OTP_EXPIRATION', 10)
                )
            );
        
        return response()->json([
            "status" => true,
            "message" => "OTP successfully sent to ".mask_email($request->email, 4),
        ], 200);
    }
    public function validate(Request $request)
    {
        $validator = Validator::make($request->all(),
        [
            "email" => "required|string|email|exists:users,email",
            "otp" => "required|string"
        ]);

        if ($validator->fails())
        {
            $errorMessage = $validator->errors()->first();

            $response = [
                "status" => false,
                "message" => $errorMessage
            ];

            return response()->json($response, 400);
        }

        // Clean up expired tokens first
        PasswordResetToken::deleteExpired();

        // Validate OTP
        $otp = (new Otp)->validate($request->email, $request->otp);

        if (!$otp->status) {
            return response()->json([
                "status" => false,
                "message" => $otp->message
            ], 401);
        }

        // OTP is valid - delete any existing reset tokens for this email
        PasswordResetToken::where('email', $request->email)->delete();

        // Generate a secure reset token (valid for 15 minutes)
        $resetToken = Str::random(64);

        PasswordResetToken::create([
            'email' => $request->email,
            'token' => hash('sha256', $resetToken), // Hash token for security
            'expires_at' => now()->addMinutes(15),
            'created_at' => now(),
        ]);

        return response()->json([
            "status" => true,
            "message" => "OTP is valid. You can now reset your password.",
            "reset_token" => $resetToken, // Send plain token to app
            "expires_in" => 900 // 15 minutes in seconds
        ], 200);
    }
}
