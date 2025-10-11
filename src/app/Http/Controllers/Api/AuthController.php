<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use Illuminate\Support\Facades\Hash;
use App\Models\User;

class AuthController extends Controller
{
    public function login(Request $request)
    {
        $validator = Validator::make($request->all(), [
            "email" => "required",
            "password" => "required"
        ]);
 
        if ($validator->fails()) 
        {
            $errorMessage = $validator->errors()->first();
            
            $response = [
                'status'  => false,
                'message' => $errorMessage,
            ];
            
            return response()->json($response, 401);
        }
 
        $user = User::where("email", $request->email)->first();

        if (!$user || !Hash::check($request->password, $user->password))
        {
            return response()->json([
                "status" => false,
                "message" => "Invalid credentials"
            ]);
        }
 
        $token = $user->createToken("auth_token")->plainTextToken;

        return response()->json([
            "status" => true,
            "message" => "Login successful",
            "access_token" => $token, 
            "token_type" => "Bearer",
            "user" => $user->only(['id', 'name', 'email'])
        ]);
    }

    public function logout(Request $request)
    {
        $request->user()->currentAccessToken()->delete();

        return response()->json([
            'status' => true,
            'message' => 'Logout successful'
        ]);
    }
}
