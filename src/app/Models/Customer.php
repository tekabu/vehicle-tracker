<?php

namespace App\Models;

use App\Models\Model;
use Illuminate\Support\Str;

class Customer extends Model
{
    /**
     * The attributes that are mass assignable.
     *
     * @var list<string>
     */
    protected $fillable = [
        'name',
        'contact_no',
        'address',
    ];

    /**
     * Set the customer's name, ensuring proper casing.
     *
     * @param  string  $value
     * @return void
     */
    public function setNameAttribute(string $value)
    {
        $name = trim($value);

        $name = preg_replace('/\s+/', ' ', $name);

        $this->attributes['name'] = Str::title($name);
    }
    /**
     * Get active rentals for this customer.
     * A rental is active if:
     * - ended_at is null (not yet ended), OR
     * - ended_at is in the future (scheduled to end later)
     *
     * @return \Illuminate\Database\Eloquent\Relations\HasMany
     */
    public function active_rentals()
    {
        return $this->hasMany(Rental::class, 'customer_id')
            ->where(function ($query) {
                $query->whereNull('ended_at')
                    ->orWhere('ended_at', '>', now());
            });
    }
}
