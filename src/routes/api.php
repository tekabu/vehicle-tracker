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

// Public routes with rate limiting
Route::middleware(['throttle:10,1'])->group(function () {
    Route::post('/register', [UserController::class, 'register']);
    Route::post('/login', [AuthController::class, 'login'])->name('login');
});

// Password reset flow (public - uses OTP for security)
Route::middleware(['throttle:5,10'])->group(function () {
    Route::post('/otp', [OtpController::class, 'generateOtp']);
    Route::post('/otp/validate', [OtpController::class, 'validate']);
    Route::post('/password/reset', [UserController::class, 'resetPassword']);
});

// Location endpoint (public - for GPS devices)
Route::get('/location', [LocationController::class, 'location']);

// Protected routes (require authentication)
Route::middleware('auth:sanctum')->group(function ()
{
    Route::get('/test', [TestController::class, 'index']);

    Route::post('/logout', [AuthController::class, 'logout']);

    // Password change for authenticated users
    Route::post('/password/change', [UserController::class, 'changePassword']);

    // Resource routes
    Route::apiResource('devices', DeviceController::class);
    Route::apiResource('customers', CustomerController::class);
    Route::apiResource('vehicles', VehicleController::class);
    Route::apiResource('rentals', RentalController::class);

    // Rental start/end routes
    Route::post('/rentals/{id}/start', [RentalController::class, 'start']);
    Route::post('/rentals/{id}/end', [RentalController::class, 'end']);
});