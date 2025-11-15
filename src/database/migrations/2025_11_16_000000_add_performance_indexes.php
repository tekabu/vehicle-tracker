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
        // Add indexes to rentals table for better query performance
        Schema::table('rentals', function (Blueprint $table) {
            $table->index('started_at');
            $table->index('ended_at');
        });

        // Add index to password_reset_tokens for cleanup queries
        Schema::table('password_reset_tokens', function (Blueprint $table) {
            $table->index('expires_at');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('rentals', function (Blueprint $table) {
            $table->dropIndex(['started_at']);
            $table->dropIndex(['ended_at']);
        });

        Schema::table('password_reset_tokens', function (Blueprint $table) {
            $table->dropIndex(['expires_at']);
        });
    }
};
