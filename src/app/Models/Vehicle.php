<?php

namespace App\Models;

use App\Models\Model;

class Vehicle extends Model
{
    /**
     * The attributes that are mass assignable.
     *
     * @var list<string>
     */
    protected $fillable = [
        'plate_no',
        'car_type',
        'device_id'
    ];

    protected $with = ['device'];

    /**
     * Get the device associated with the vehicle.
     */
    public function device()
    {
        return $this->belongsTo(\App\Models\Device::class, 'device_id');
    }
}
