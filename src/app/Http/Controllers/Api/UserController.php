<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use Illuminate\Support\Facades\Hash;
use App\Models\User;
use Ichtrojan\Otp\Otp;

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
     * Reset password using OTP (for forgot password flow)
     */
    public function reset_password(Request $request)
    {
        $validator = Validator::make($request->all(), [
            "email" => "required|string|email|exists:users,email",
            "otp" => "required|string",
            "password" => "required|confirmed|min:8"
        ]);

        if ($validator->fails()) {
            return response()->json([
                "status" => false,
                "message" => $validator->errors()->first()
            ], 400);
        }

        // Validate OTP
        $otpValidation = (new Otp)->validate($request->email, $request->otp);

        if (!$otpValidation->status) {
            return response()->json([
                "status" => false,
                "message" => "Invalid or expired OTP"
            ], 401);
        }

        // OTP is valid - update password
        $user = User::where("email", $request->email)->first();
        $user->password = Hash::make($request->password);
        $user->save();

        // Invalidate all existing tokens (logout from all devices for security)
        $user->tokens()->delete();

        return response()->json([
            "status" => true,
            "message" => "Password reset successfully"
        ], 200);
    }

    /**
     * Change password for authenticated users (requires old password)
     */
    public function change_password(Request $request)
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
