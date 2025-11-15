<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Validator;
use Illuminate\Http\Request;
use Ichtrojan\Otp\Otp;
use App\Mail\OtpMail;
use Illuminate\Support\Facades\Mail;

class OtpController extends Controller
{
    public function generate_otp(Request $request) 
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
        
        $otp = (new Otp)->validate($request->email, $request->otp);
        
        if (!$otp->status) {
            return response()->json([
                "status" => false,
                "message" => $otp->message
            ], 400);
        }
        
        return response()->json([
            "status" => true,
            "message" => "OTP is valid"
        ], 200);
    }
}
