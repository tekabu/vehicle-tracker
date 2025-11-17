#!/bin/bash

# File Browser Docker Runner
# Mounts current directory and starts web interface

CONTAINER_NAME="filebrowser"
PORT=5050

# Check if container already exists
if [ "$(docker ps -a -q -f name=$CONTAINER_NAME)" ]; then
    echo "Container '$CONTAINER_NAME' already exists. Removing it..."
    docker rm -f $CONTAINER_NAME
fi

# Run File Browser with current directory mounted
echo "Starting File Browser..."
docker run -d \
  --name $CONTAINER_NAME \
  -p $PORT:80 \
  -v "$(pwd):/srv" \
  filebrowser/filebrowser:latest

# Wait a moment for container to start
sleep 2

# Check if container is running
if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
    echo "✓ File Browser is running!"
    echo "  URL: http://localhost:$PORT"
    echo "  Default credentials: admin/admin"
    echo "  Mounted directory: $(pwd)"
    echo ""
    echo "To stop: docker stop $CONTAINER_NAME"
    echo "To remove: docker rm $CONTAINER_NAME"
else
    echo "✗ Failed to start container"
    docker logs $CONTAINER_NAME
fi