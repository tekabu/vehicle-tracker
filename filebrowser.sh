#!/bin/bash

# File Browser Docker Runner with Authentication
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

# Create a config directory and remove old database (directory or file)
CONFIG_DIR="$HOME/.filebrowser"
mkdir -p "$CONFIG_DIR"
rm -rf "$CONFIG_DIR/database.db"
echo "Cleaned old database..."

# Run File Browser with current directory mounted
echo "Starting File Browser..."
docker run -d \
  --name $CONTAINER_NAME \
  -p $PORT:80 \
  -v "$(pwd):/srv" \
  -v "$CONFIG_DIR:/config" \
  -e PUID=$(id -u) \
  -e PGID=$(id -g) \
  filebrowser/filebrowser:latest \
  --database /config/database.db \
  --root /srv

# Wait for container to start
sleep 3

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
else
    echo "✗ Failed to start container"
    docker logs $CONTAINER_NAME
fi