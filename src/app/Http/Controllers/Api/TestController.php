<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;

class TestController extends Controller
{
    /**
     * Simple health check endpoint to verify API connectivity
     */
    public function index()
    {
        return response()->json([
            'status' => true,
            'message' => 'API is online',
            'datetime' => now()->toDateTimeString(),
            'timezone' => config('app.timezone')
        ], 200);
    }
}
