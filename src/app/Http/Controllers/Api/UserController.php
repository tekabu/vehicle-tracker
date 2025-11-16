<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use App\Models\User;
use App\Models\PasswordResetToken;
use App\Http\Requests\RegisterUserRequest;
use App\Http\Requests\ResetPasswordRequest;
use App\Http\Requests\ChangePasswordRequest;
use App\Http\Requests\UpdateProfileRequest;

class UserController extends Controller
{
    public function register(RegisterUserRequest $request)
    {
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
    public function resetPassword(ResetPasswordRequest $request)
    {
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
    public function changePassword(ChangePasswordRequest $request)
    {
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

    /**
     * Get authenticated user's profile
     */
    public function profile(Request $request)
    {
        return response()->json([
            "status" => true,
            "user" => $request->user()
        ], 200);
    }

    /**
     * Update authenticated user's profile (name and/or email)
     */
    public function updateProfile(UpdateProfileRequest $request)
    {
        $user = $request->user();

        // Update only the fields that are present in the request
        if ($request->has('name')) {
            $user->name = $request->name;
        }

        if ($request->has('email')) {
            $user->email = $request->email;
        }

        $user->save();

        return response()->json([
            "status" => true,
            "message" => "Profile updated successfully",
            "user" => $user
        ], 200);
    }
}
