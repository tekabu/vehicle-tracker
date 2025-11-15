<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Vehicle;
use App\Http\Requests\StoreVehicleRequest;
use App\Http\Requests\UpdateVehicleRequest;

class VehicleController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $vehicles = Vehicle::all();

        return response()->json([
            'status' => true,
            'message' => 'Vehicles retrieved successfully',
            'vehicles' => $vehicles
        ], 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(StoreVehicleRequest $request)
    {
        $vehicle = Vehicle::create($request->validated());

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
                'status' => false,
                'message' => 'Vehicle not found'
            ], 404);
        }
        
        return response()->json([
            'status' => true,
            'message' => 'Vehicle retrieved successfully',
            'vehicle' => $vehicle
        ], 200);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(UpdateVehicleRequest $request, string $id)
    {
        $vehicle = Vehicle::find($id);

        if (!$vehicle) {
            return response()->json([
                'status' => false,
                'message' => 'Vehicle not found'
            ], 404);
        }

        $vehicle->update($request->validated());

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
                'status' => false,
                'message' => 'Vehicle not found'
            ], 404);
        }

        $vehicle->delete();
        
        return response()->json([
            'status' => true,
            'message' => 'Vehicle deleted successfully',
            'vehicle' => $vehicle
        ], 200);
    }
}
