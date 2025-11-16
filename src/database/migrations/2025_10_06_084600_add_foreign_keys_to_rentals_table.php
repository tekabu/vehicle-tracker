<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::table('rentals', function (Blueprint $table) {
            $table->foreign('customer_id')->references('id')->on('customers')->onDelete('restrict');
            $table->foreign('vehicle_id')->references('id')->on('vehicles')->onDelete('restrict');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('rentals', function (Blueprint $table) {
            $table->dropForeign(['customer_id']);
            $table->dropForeign(['vehicle_id']);
        });
    }
};
