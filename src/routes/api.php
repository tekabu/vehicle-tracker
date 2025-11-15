<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\TestController;
use App\Http\Controllers\Api\UserController;
use App\Http\Controllers\Api\AuthController;
use App\Http\Controllers\Api\DeviceController;
use App\Http\Controllers\Api\CustomerController;
use App\Http\Controllers\Api\VehicleController;
use App\Http\Controllers\Api\RentalController;
use App\Http\Controllers\Api\LocationController;
use App\Http\Controllers\Api\OtpController;

Route::post('/register', [UserController::class, 'register']);

Route::post('/login', [AuthController::class, 'login']);

Route::post('/password/update', [UserController::class, 'update_password']);

Route::middleware('auth:sanctum')->group(function () 
{
    Route::get('/test', [TestController::class, 'index']);

    Route::post('/logout', [AuthController::class, 'logout']);

    Route::apiResource('devices', DeviceController::class);

    Route::apiResource('customers', CustomerController::class);

    Route::apiResource('vehicles', VehicleController::class);
    
    Route::apiResource('rentals', RentalController::class);
});

Route::get('/location', [LocationController::class, 'location']);

Route::post('/otp', [OtpController::class, 'generate_otp']);

Route::post('/otp/validate', [OtpController::class, 'validate']);