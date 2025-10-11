<?php

namespace App\Models;

use App\Models\Model;

class Rental extends Model
{
    /**
     * The attributes that are mass assignable.
     *
     * @var list<string>
     */
    protected $fillable = [
        'customer_id',
        'vehicle_id',
    ];

    /**
     * Get the customer associated with the rental.
     */
    public function customer()
    {
        return $this->belongsTo(\App\Models\Customer::class, 'customer_id');
    }

    /**
     * Get the vehicle associated with the rental.
     */
    public function vehicle()
    {
        return $this->belongsTo(\App\Models\Vehicle::class, 'vehicle_id');
    }
}
