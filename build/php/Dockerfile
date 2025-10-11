# Use the official PHP image with FPM
FROM php:8.2.6-fpm

# Install system dependencies and PHP extensions
RUN apt-get update && apt-get install -y \
    git \
    curl \
    unzip \
    nano \
    vim \
    libzip-dev \
    && docker-php-ext-install mysqli pdo pdo_mysql zip \
    && rm -rf /var/lib/apt/lists/*

# Install Composer globally
COPY --from=composer:2.2 /usr/bin/composer /usr/bin/composer

# Set the working directory
WORKDIR /var/www/html

CMD ["php-fpm"]