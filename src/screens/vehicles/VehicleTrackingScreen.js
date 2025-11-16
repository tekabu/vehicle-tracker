import React, { useState, useEffect, useRef } from 'react';
import {
  View,
  StyleSheet,
  ActivityIndicator,
  Text,
  Alert,
  TouchableOpacity,
} from 'react-native';
import { StatusBar } from 'expo-status-bar';
import MapView, { Marker } from 'react-native-maps';
import mqtt from 'mqtt';
import Header from '../../components/Header';
import vehicleService from '../../services/vehicleService';

const VehicleTrackingScreen = ({ navigation, route }) => {
  const { vehicleId } = route.params;
  const [loading, setLoading] = useState(true);
  const [vehicle, setVehicle] = useState(null);
  const [location, setLocation] = useState(null);
  const [connected, setConnected] = useState(false);
  const [lastUpdate, setLastUpdate] = useState(null);

  const mapRef = useRef(null);
  const mqttClient = useRef(null);
  const isConnecting = useRef(false);

  useEffect(() => {
    loadVehicle();
    return () => {
      // Cleanup MQTT connection on unmount
      if (mqttClient.current) {
        console.log('Cleaning up MQTT connection');
        mqttClient.current.end(true);
        mqttClient.current = null;
      }
      isConnecting.current = false;
    };
  }, []);

  useEffect(() => {
    if (vehicle && vehicle.device && !mqttClient.current && !isConnecting.current) {
      connectToMqtt();
    }
  }, [vehicle]);

  const loadVehicle = async () => {
    try {
      setLoading(true);
      const data = await vehicleService.getById(vehicleId);
      setVehicle(data);

      if (!data.device) {
        Alert.alert('No Device', 'This vehicle does not have a tracking device assigned.');
        navigation.goBack();
      }
    } catch (error) {
      console.error('Error loading vehicle:', error);
      Alert.alert('Error', 'Failed to load vehicle information');
      navigation.goBack();
    } finally {
      setLoading(false);
    }
  };

  const connectToMqtt = () => {
    // Prevent multiple connections
    if (isConnecting.current || mqttClient.current) {
      console.log('Already connected or connecting, skipping...');
      return;
    }

    try {
      isConnecting.current = true;
      console.log('Initiating MQTT connection...');

      // MQTT broker configuration - using WebSocket for React Native compatibility
      const brokerUrl = 'ws://broker.emqx.io:8083/mqtt';
      const topic = 'tracker-A1b2C3d4E5f6G7h8I9j0KlMnOpQrStUvWxYzABCD';

      // Create MQTT client with WebSocket
      const client = mqtt.connect(brokerUrl, {
        clientId: `vehicle_tracker_${Date.now()}`,
        clean: true,
        reconnectPeriod: 1000,
        connectTimeout: 30000,
        protocol: 'ws',
        protocolVersion: 4,
      });

      client.on('connect', () => {
        console.log('Connected to MQTT broker');
        setConnected(true);

        // Subscribe to the tracker topic
        client.subscribe(topic, (err) => {
          if (err) {
            console.error('Subscription error:', err);
            Alert.alert('Connection Error', 'Failed to subscribe to tracking topic');
          } else {
            console.log(`Subscribed to topic: ${topic}`);
          }
        });
      });

      client.on('message', (receivedTopic, message) => {
        try {
          // Parse the message payload
          // Expected format: $@id,@lat,@lng,@time#
          const payload = message.toString();
          console.log('Received payload:', payload);

          const parsed = parsePayload(payload);

          if (parsed && parsed.id === vehicle.device.device) {
            // Update location only if the device ID matches
            const newLocation = {
              latitude: parsed.lat,
              longitude: parsed.lng,
              timestamp: parsed.time,
            };

            setLocation(newLocation);
            setLastUpdate(new Date());

            // Animate camera to new location
            if (mapRef.current) {
              mapRef.current.animateToRegion({
                latitude: parsed.lat,
                longitude: parsed.lng,
                latitudeDelta: 0.01,
                longitudeDelta: 0.01,
              }, 1000);
            }
          }
        } catch (error) {
          console.error('Error parsing message:', error);
        }
      });

      client.on('error', (error) => {
        console.error('MQTT error:', error);
        console.error('Error details:', JSON.stringify(error));
        setConnected(false);
      });

      client.on('close', () => {
        console.log('MQTT connection closed');
        setConnected(false);
      });

      client.on('offline', () => {
        console.log('MQTT client offline');
        setConnected(false);
      });

      client.on('disconnect', () => {
        console.log('MQTT client disconnected');
        setConnected(false);
      });

      mqttClient.current = client;
    } catch (error) {
      console.error('Error connecting to MQTT:', error);
      Alert.alert('Error', 'Failed to connect to tracking server');
    }
  };

  const parsePayload = (payload) => {
    try {
      // Remove $ and # markers
      let cleaned = payload.trim();
      if (cleaned.startsWith('$')) cleaned = cleaned.substring(1);
      if (cleaned.endsWith('#')) cleaned = cleaned.substring(0, cleaned.length - 1);

      // Split by comma
      const parts = cleaned.split(',');

      if (parts.length >= 3) {
        return {
          id: parts[0].trim(),
          lat: parseFloat(parts[1].trim()),
          lng: parseFloat(parts[2].trim()),
          time: parts[3] ? parseInt(parts[3].trim()) : Date.now(),
        };
      }

      return null;
    } catch (error) {
      console.error('Error parsing payload:', error);
      return null;
    }
  };

  const handleReconnect = () => {
    if (mqttClient.current) {
      mqttClient.current.end(true);
      mqttClient.current = null;
    }
    isConnecting.current = false;
    connectToMqtt();
  };

  if (loading) {
    return (
      <View style={styles.container}>
        <StatusBar style="dark" />
        <Header
          title="Vehicle Tracking"
          navigation={navigation}
          showBackButton={true}
        />
        <View style={styles.loadingContainer}>
          <ActivityIndicator size="large" color="#007AFF" />
        </View>
      </View>
    );
  }

  const initialRegion = location ? {
    latitude: location.latitude,
    longitude: location.longitude,
    latitudeDelta: 0.01,
    longitudeDelta: 0.01,
  } : {
    // Default location (center of world map)
    latitude: 0,
    longitude: 0,
    latitudeDelta: 50,
    longitudeDelta: 50,
  };

  return (
    <View style={styles.container}>
      <StatusBar style="dark" />
      <Header
        title="Vehicle Tracking"
        navigation={navigation}
        showBackButton={true}
      />

      {/* Status bar */}
      <View style={styles.statusBar}>
        <View style={styles.statusItem}>
          <View style={[styles.statusDot, { backgroundColor: connected ? '#4CAF50' : '#F44336' }]} />
          <Text style={styles.statusText}>
            {connected ? 'Connected' : 'Disconnected'}
          </Text>
        </View>

        {vehicle && (
          <View style={styles.vehicleInfo}>
            <Text style={styles.vehicleText}>{vehicle.car_type}</Text>
            <Text style={styles.plateText}>{vehicle.plate_no}</Text>
          </View>
        )}

        {lastUpdate && (
          <Text style={styles.updateText}>
            Last update: {lastUpdate.toLocaleTimeString()}
          </Text>
        )}
      </View>

      {/* Map */}
      <MapView
        ref={mapRef}
        style={styles.map}
        initialRegion={initialRegion}
        showsUserLocation={true}
        showsMyLocationButton={true}
      >
        {location && (
          <Marker
            coordinate={{
              latitude: location.latitude,
              longitude: location.longitude,
            }}
            title={vehicle?.car_type}
            description={vehicle?.plate_no}
            pinColor="#007AFF"
          />
        )}
      </MapView>

      {/* No location message */}
      {!location && (
        <View style={styles.noLocationContainer}>
          <Text style={styles.noLocationText}>
            Waiting for location data...
          </Text>
          <Text style={styles.noLocationSubtext}>
            Device: {vehicle?.device?.device}
          </Text>
        </View>
      )}

      {/* Reconnect button */}
      {!connected && (
        <View style={styles.reconnectContainer}>
          <TouchableOpacity
            style={styles.reconnectButton}
            onPress={handleReconnect}
          >
            <Text style={styles.reconnectButtonText}>Reconnect</Text>
          </TouchableOpacity>
        </View>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f5f5f5',
  },
  loadingContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  statusBar: {
    backgroundColor: '#fff',
    padding: 12,
    borderBottomWidth: 1,
    borderBottomColor: '#e0e0e0',
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    flexWrap: 'wrap',
  },
  statusItem: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  statusDot: {
    width: 10,
    height: 10,
    borderRadius: 5,
    marginRight: 6,
  },
  statusText: {
    fontSize: 14,
    fontWeight: '500',
    color: '#333',
  },
  vehicleInfo: {
    alignItems: 'center',
  },
  vehicleText: {
    fontSize: 14,
    fontWeight: '600',
    color: '#333',
  },
  plateText: {
    fontSize: 12,
    color: '#666',
  },
  updateText: {
    fontSize: 12,
    color: '#666',
  },
  map: {
    flex: 1,
  },
  noLocationContainer: {
    position: 'absolute',
    top: '40%',
    left: 0,
    right: 0,
    alignItems: 'center',
    backgroundColor: 'rgba(255, 255, 255, 0.9)',
    padding: 20,
    margin: 20,
    borderRadius: 10,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    elevation: 5,
  },
  noLocationText: {
    fontSize: 16,
    fontWeight: '600',
    color: '#333',
    marginBottom: 8,
  },
  noLocationSubtext: {
    fontSize: 14,
    color: '#666',
  },
  reconnectContainer: {
    position: 'absolute',
    bottom: 20,
    left: 0,
    right: 0,
    alignItems: 'center',
  },
  reconnectButton: {
    backgroundColor: '#007AFF',
    paddingVertical: 12,
    paddingHorizontal: 24,
    borderRadius: 8,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    elevation: 5,
  },
  reconnectButtonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: '600',
  },
});

export default VehicleTrackingScreen;
