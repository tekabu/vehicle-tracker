FROM nginx:1.26

# Install system dependencies, SSH, and Supervisor
RUN apt-get update && apt-get install -y \
    git \
    curl \
    vim \
    && rm -rf /var/lib/apt/lists/*

# Install specific version of Node.js (18.16.1) and npm
RUN curl -fsSL https://deb.nodesource.com/setup_18.x | bash - && \
    apt-get install -y nodejs && \
    npm install -g npm@9.8.1

COPY ./nginx.conf /etc/nginx/nginx.conf

COPY ./default.conf /etc/nginx/conf.d

# Set the working directory inside the container
WORKDIR /var/www/html

CMD ["nginx", "-g", "daemon off;"]
