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