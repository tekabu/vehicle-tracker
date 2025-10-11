<?php

namespace App\Models;

use App\Models\Model;

class Device extends Model
{
    /**
     * The attributes that are mass assignable.
     *
     * @var list<string>
     */
    protected $fillable = [
        'tag',
    ];
}
