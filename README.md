# Tracker 

## update .env

docker compose up -d  
docker exec -it tracker_php bash  

composer install  
composer update 

php artisan migrate  
php artisan db:seed  

composer require laravel/sanctum  
php artisan vendor:publish --provider="Laravel\Sanctum\SanctumServiceProvider" 

## Debug incoming request

composer require laravel/telescope  
php artisan telescope:install  
php artisan migrate  

## Access telescope @ /telescope
