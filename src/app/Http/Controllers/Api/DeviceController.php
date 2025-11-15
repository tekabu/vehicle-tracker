<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Device;
use App\Http\Requests\StoreDeviceRequest;
use App\Http\Requests\UpdateDeviceRequest;

class DeviceController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $devices = Device::all();
        
        return response()->json([
            'status' => true,
            'message' => 'Devices retrieved successfully',
            'devices' => $devices
        ], 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(StoreDeviceRequest $request)
    {
        $device = Device::create($request->validated());

        return response()->json([
            "status" => true,
            "message" => "Device created successfully",
            "device" => $device
        ], 200);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $device = Device::find($id);
        
        if (!$device) {
            return response()->json([
                'status' => false,
                'message' => 'Device not found'
            ], 404);
        }

        return response()->json([
            'status' => true,
            'message' => 'Device retrieved successfully',
            'device' => $device
        ], 200);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(UpdateDeviceRequest $request, string $id)
    {
        $device = Device::find($id);

        if (!$device) {
            return response()->json([
                'status' => false,
                'message' => 'Device not found'
            ], 404);
        }

        $device->update($request->validated());

        return response()->json([
            'status' => true,
            'message' => 'Device updated successfully',
            'device' => $device
        ], 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $device = Device::find($id);
        
        if (!$device) {
            return response()->json([
                'status' => false,
                'message' => 'Device not found'
            ], 404);
        }

        $device->delete();

        return response()->json([
            'status' => true,
            'message' => 'Device deleted successfully',
            'device' => $device
        ], 200);
    }
}
