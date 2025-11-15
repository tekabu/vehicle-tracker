<?php

if (!function_exists('mask_email')) {
    function mask_email($email, $showChars = 3)
    {
        if (empty($email)) {
            return '';
        }

        $parts = explode('@', $email);
        $name = $parts[0];
        $domain = $parts[1] ?? '';

        $nameLength = strlen($name);
        
        if ($nameLength <= $showChars) {
            $maskedName = str_repeat('*', $nameLength);
        } else {
            // Show first few characters
            $maskedName = substr($name, 0, $showChars) . str_repeat('*', $nameLength - $showChars);
        }

        return $maskedName . '@' . $domain;
    }
}