<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use Illuminate\Support\Facades\Hash;
use App\Models\User;
use App\Models\PasswordResetToken;

class UserController extends Controller
{
    public function register(Request $request)
    {
        $validator = Validator::make($request->all(),
        [
            "name" => "required|string|max:255",
            "email" => "required|string|email|unique:users|max:255",
            "password" => "required|confirmed|min:8"
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

        $user = User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
        ]);

        return response()->json([
            "status" => true,
            "message" => "User registered successfully",
            "user" => $user
        ]);
    }
    /**
     * Reset password using reset token (for forgot password flow)
     *
     * Flow:
     * 1. User requests OTP via /otp endpoint
     * 2. User validates OTP via /otp/validate - receives reset_token
     * 3. User submits reset_token + new password to this endpoint
     */
    public function resetPassword(Request $request)
    {
        $validator = Validator::make($request->all(), [
            "email" => "required|string|email|exists:users,email",
            "reset_token" => "required|string",
            "password" => "required|confirmed|min:8"
        ]);

        if ($validator->fails()) {
            return response()->json([
                "status" => false,
                "message" => $validator->errors()->first()
            ], 400);
        }

        // Clean up expired tokens first
        PasswordResetToken::deleteExpired();

        // Find the reset token (remember it's hashed in database)
        $hashedToken = hash('sha256', $request->reset_token);

        $resetRecord = PasswordResetToken::where('email', $request->email)
            ->where('token', $hashedToken)
            ->first();

        if (!$resetRecord) {
            return response()->json([
                "status" => false,
                "message" => "Invalid reset token"
            ], 401);
        }

        // Check if token is expired
        if ($resetRecord->isExpired()) {
            $resetRecord->delete();
            return response()->json([
                "status" => false,
                "message" => "Reset token has expired. Please request a new OTP."
            ], 401);
        }

        // Token is valid - update password
        $user = User::where("email", $request->email)->first();
        $user->password = Hash::make($request->password);
        $user->save();

        // Delete the used reset token
        $resetRecord->delete();

        // Invalidate all existing tokens (logout from all devices for security)
        $user->tokens()->delete();

        return response()->json([
            "status" => true,
            "message" => "Password reset successfully. Please login with your new password."
        ], 200);
    }

    /**
     * Change password for authenticated users (requires old password)
     */
    public function changePassword(Request $request)
    {
        $validator = Validator::make($request->all(), [
            "old_password" => "required",
            "password" => "required|confirmed|min:8"
        ]);

        if ($validator->fails()) {
            return response()->json([
                "status" => false,
                "message" => $validator->errors()->first()
            ], 400);
        }

        $user = $request->user();

        if (!Hash::check($request->old_password, $user->password)) {
            return response()->json([
                "status" => false,
                "message" => "Old password is incorrect"
            ], 401);
        }

        $user->password = Hash::make($request->password);
        $user->save();

        // Invalidate all other tokens (keep current session)
        $user->tokens()->where('id', '!=', $request->user()->currentAccessToken()->id)->delete();

        return response()->json([
            "status" => true,
            "message" => "Password changed successfully"
        ], 200);
    }
}
