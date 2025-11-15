<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Customer;
use App\Http\Requests\StoreCustomerRequest;
use App\Http\Requests\UpdateCustomerRequest;

class CustomerController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Request $request)
    {
        $query = Customer::query();

        $includes = explode(',', $request->get('include', ''));

        if (in_array('active_rentals', $includes)) {
            $query->with('active_rentals.vehicle');
        }

        $customers = $query->get();
        
        return response()->json([
            'status' => true,
            'message' => 'Customers retrieved successfully',
            'customers' => $customers
        ], 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(StoreCustomerRequest $request)
    {
        $customer = Customer::create($request->validated());

        return response()->json([
            "status" => true,
            "message" => "Customer created successfully",
            "customer" => $customer
        ], 200);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $customer = Customer::find($id);
        
        if (!$customer) {
            return response()->json([
                'status' => false,
                'message' => 'customer not found'
            ], 404);
        }
        
        return response()->json([
            'status' => true,
            'message' => 'customer retrieved successfully',
            'customer' => $customer
        ], 200);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(UpdateCustomerRequest $request, string $id)
    {
        $customer = Customer::find($id);

        if (!$customer) {
            return response()->json([
                'status' => false,
                'message' => 'Customer not found'
            ], 404);
        }

        $customer->update($request->validated());

        return response()->json([
            'status' => true,
            'message' => 'Customer updated successfully',
            'customer' => $customer
        ], 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $customer = Customer::find($id);
        
        if (!$customer) {
            return response()->json([
                'status' => false,
                'message' => 'Customer not found'
            ], 404);
        }

        $customer->delete();

        return response()->json([
            'status' => true,
            'message' => 'Customer deleted successfully',
            'customer' => $customer
        ], 200);
    }
}
