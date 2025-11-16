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
        'started_at',
        'ended_at'
    ];

    /**
     * The accessors to append to the model's array form.
     *
     * @var array
     */
    protected $appends = ['start_date', 'end_date'];


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

    /**
     * Scope a query to only include active rentals.
     *
     * @param  \Illuminate\Database\Eloquent\Builder  $query
     * @return \Illuminate\Database\Eloquent\Builder
     */
    public function scopeActive($query)
    {
        return $query->where(function ($query) {
            $query->whereNull('ended_at')
                ->orWhere('ended_at', '>', now());
        });
    }
    

    /**
     * Get the formatted start date attribute.
     *
     * @return string|null
     */
    public function getStartDateAttribute()
    {
        if (isset($this->attributes['started_at'])) {
            return \Carbon\Carbon::parse($this->attributes['started_at'])->format('M. d, Y');
        }
        return null;
    }

    /**
     * Get the formatted end date attribute.
     *
     * @return string|null
     */
    public function getEndDateAttribute()
    {
        if (isset($this->attributes['ended_at'])) {
            return \Carbon\Carbon::parse($this->attributes['ended_at'])->format('M. d, Y');
        }
        return null;
    }
}
