<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class LocationController extends Controller
{
    public function location(Request $request)
    {
        $lat = $request->query('lat');
        $lng = $request->query('lng');

        return response()->json([
            'success' => true,
            'message' => 'Location saved',
            'location' => [
                'lat' => $lat,
                'lng' => $lng,
            ]
        ], 200);
    }
}
