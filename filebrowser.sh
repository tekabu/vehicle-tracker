#!/bin/bash

# File Browser Docker Runner (Official Method with Init)
# Mounts current directory and starts web interface

CONTAINER_NAME="filebrowser"
PORT=5050
USERNAME="admin"
PASSWORD="admin"

# Check if container already exists
if [ "$(docker ps -a -q -f name=$CONTAINER_NAME)" ]; then
    echo "Container '$CONTAINER_NAME' already exists. Removing it..."
    docker rm -f $CONTAINER_NAME
fi

# Remove old volumes for fresh start
echo "Cleaning old volumes..."
docker volume rm filebrowser_database 2>/dev/null
docker volume rm filebrowser_config 2>/dev/null

# Run File Browser with official volume setup
echo "Starting File Browser..."
docker run -d \
    --name $CONTAINER_NAME \
    -v "$(pwd):/srv" \
    -v filebrowser_database:/database \
    -v filebrowser_config:/config \
    -p $PORT:80 \
    filebrowser/filebrowser:latest

# Wait for container to start
sleep 3

# Initialize config
echo "Initializing File Browser configuration..."
docker exec $CONTAINER_NAME filebrowser config init

# Create admin user
echo "Creating admin user..."
docker exec $CONTAINER_NAME filebrowser users add $USERNAME $PASSWORD --perm.admin

# Restart container to apply changes
echo "Restarting container..."
docker restart $CONTAINER_NAME
sleep 2

# Check if container is running
if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
    echo "✓ File Browser is running!"
    echo "  URL: http://localhost:$PORT"
    echo "  Username: $USERNAME"
    echo "  Password: $PASSWORD"
    echo "  Mounted directory: $(pwd)"
    echo ""
    echo "To stop: docker stop $CONTAINER_NAME"
    echo "To remove: docker rm -f $CONTAINER_NAME"
    echo "To clean volumes: docker volume rm filebrowser_database filebrowser_config"
else
    echo "✗ Failed to start container"
    docker logs $CONTAINER_NAME
fi