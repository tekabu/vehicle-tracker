<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model as BaseModel;
use DateTimeInterface;

class Model extends BaseModel
{
    protected function serializeDate(DateTimeInterface $date)
    {
        return $date->timezone('Asia/Manila')->format('Y-m-d H:i:s');
    }
}
