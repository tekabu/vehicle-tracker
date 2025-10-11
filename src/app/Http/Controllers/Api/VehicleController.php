<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Validator;
use Illuminate\Http\Request;
use App\Models\Vehicle;

class VehicleController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $vechicles = Vehicle::all();
        
        return response()->json([
            'success' => true,
            'message' => 'Vechicles retrieved successfully',
            'vechicles' => $vechicles
        ], 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $validator = Validator::make($request->all(),
        [
            "plate_no" => "required|string|unique:vehicles",
            "car_type" => "required|string",
            "device_id" => "nullable|exists:devices,id|unique:vehicles,device_id",
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

        $vehicle = Vehicle::create($validator->validated());

        return response()->json([
            "status" => true,
            "message" => "Vehicle created successfully",
            "vehicle" => $vehicle
        ], 200);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $vehicle = Vehicle::find($id);
        
        if (!$vehicle) {
            return response()->json([
                'success' => false,
                'message' => 'Vehicle not found'
            ], 404);
        }
        
        return response()->json([
            'success' => true,
            'message' => 'Vehicle retrieved successfully',
            'vehicle' => $vehicle
        ], 200);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $vehicle = Vehicle::find($id);
        
        if (!$vehicle) {
            return response()->json([
                'success' => false,
                'message' => 'Vehicle not found'
            ], 404);
        }

        $validator = Validator::make($request->all(),
        [
            "plate_no" => "required|string|unique:vehicles,plate_no," . $id,
            "car_type" => "required|string",
            "device_id" => "nullable|exists:devices,id|unique:vehicles,device_id",
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

        $vehicle->update($validator->validated());

        return response()->json([
            "status" => true,
            "message" => "Vehicle updated successfully",
            "vehicle" => $vehicle
        ], 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $vehicle = Vehicle::find($id);
        
        if (!$vehicle) {
            return response()->json([
                'success' => false,
                'message' => 'Vehicle not found'
            ], 404);
        }

        $vehicle->delete();
        
        return response()->json([
            'success' => true,
            'message' => 'Vehicle deleted successfully',
            'vehicle' => $vehicle
        ], 200);
    }
}
