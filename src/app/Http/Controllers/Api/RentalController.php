<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use App\Models\Rental;
use App\Models\Customer;
use App\Models\Vehicle;
use Carbon\Carbon;

class RentalController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Request $request)
    {
        $query = Rental::query();

        $includes = explode(',', $request->get('include', ''));

        if (in_array('customer', $includes)) {
            $query->with('customer');
        }

        if (in_array('vehicle', $includes)) {
            $query->with('vehicle');
        }

        $rentals = $query->get();
        
        return response()->json([
            'status' => true,
            'message' => 'Rentals retrieved successfully',
            'rentals' => $rentals
        ], 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $validator = Validator::make($request->all(),
        [
            "customer_id" => "required|string|exists:customers,id",
            "vehicle_id" => "required|string|exists:vehicles,id"
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

        // Check if vehicle already has an active rental
        $activeRental = Rental::where('vehicle_id', $request->vehicle_id)
            ->where(function ($query) {
                $query->whereNull('ended_at')
                    ->orWhere('ended_at', '>', now());
            })
            ->first();

        if ($activeRental) {
            return response()->json([
                "status" => false,
                "message" => "This vehicle is already rented and not available"
            ], 409); // 409 Conflict
        }

        $rental = Rental::create($validator->validated());

        return response()->json([
            "status" => true,
            "message" => "Rental created successfully",
            "rental" => $rental
        ], 201);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $rental = Rental::find($id);
        
        if (!$rental) {
            return response()->json([
                'status' => false,
                'message' => 'Rental not found'
            ], 404);
        }

        return response()->json([
            'status' => true,
            'message' => 'Rental retrieved successfully',
            'rental' => $rental
        ], 200);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $rental = Rental::find($id);
        
        if (!$rental) {
            return response()->json([
                'status' => false,
                'message' => 'Rental not found'
            ], 404);
        }

        $validator = Validator::make($request->all(), [
            "customer_id" => "required|string|exists:customers,id",
            "vehicle_id" => "required|string|exists:vehicles,id"
        ]);

        if ($validator->fails()) {
            return response()->json([
                'status' => false,
                'message' => $validator->errors()->first()
            ], 400);
        }

        $rental->update($validator->validated());

        return response()->json([
            'status' => true,
            'message' => 'Rental updated successfully',
            'rental' => $rental
        ], 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $rental = Rental::find($id);
        
        if (!$rental) {
            return response()->json([
                'status' => false,
                'message' => 'Rental not found'
            ], 404);
        }

        $rental->delete();

        return response()->json([
            'status' => true,
            'message' => 'Rental deleted successfully',
            'rental' => $rental
        ], 200);
    }

    public function start(string $id)
    {
        $rental = Rental::find($id);

        if (!$rental) {
            return response()->json([
                'status' => false,
                'message' => 'Rental not found'
            ], 404);
        }

        if ($rental->started_at) {
            return response()->json([
                'status' => false,
                'message' => 'Rental already started',
                'rental' => $rental
            ], 400);
        }

        $rental->started_at = Carbon::now();

        $rental->save();

        return response()->json([
            'status' => true,
            'message' => 'Rental started successfully',
            'rental' => $rental
        ], 200);
    }

    public function end(string $id)
    {
        $rental = Rental::find($id);

        if (!$rental) {
            return response()->json([
                'status' => false,
                'message' => 'Rental not found'
            ], 404);
        }

        if (!$rental->started_at) {
            return response()->json([
                'status' => false,
                'message' => 'Rental not yet started',
                'rental' => $rental
            ], 400);
        }

        if ($rental->ended_at) {
            return response()->json([
                'status' => false,
                'message' => 'Rental already ended',
                'rental' => $rental
            ], 400);
        }

        $rental->ended_at = Carbon::now();

        $rental->save();

        return response()->json([
            'status' => true,
            'message' => 'Rental ended successfully',
            'rental' => $rental
        ], 200);
    }
}
