import React, { useState, useEffect } from 'react';
import { View, Text, ScrollView, StyleSheet, TouchableOpacity, ActivityIndicator, Alert } from 'react-native';
import { StatusBar } from 'expo-status-bar';
import { useFocusEffect } from '@react-navigation/native';
import Header from '../../components/Header';
import Card, { CardHeader, CardRow } from '../../components/Card';
import deviceService from '../../services/deviceService';

const DevicesListScreen = ({ navigation }) => {
  const [devices, setDevices] = useState([]);
  const [loading, setLoading] = useState(true);
  const [refreshing, setRefreshing] = useState(false);

  // Reload devices when screen comes into focus
  useFocusEffect(
    React.useCallback(() => {
      loadDevices();
    }, [])
  );

  useEffect(() => {
    loadDevices();
  }, []);

  const loadDevices = async () => {
    try {
      setLoading(true);
      console.log('[DevicesListScreen] Loading devices...');
      const data = await deviceService.getAll();
      console.log('[DevicesListScreen] Received data:', JSON.stringify(data, null, 2));
      // Ensure data is always an array
      const devicesArray = Array.isArray(data) ? data : [];
      console.log('[DevicesListScreen] Setting devices array with length:', devicesArray.length);
      setDevices(devicesArray);
    } catch (error) {
      console.error('[DevicesListScreen] Error loading devices:', error);
      Alert.alert('Error', error.message || 'Failed to load devices');
      setDevices([]); // Set empty array on error
    } finally {
      setLoading(false);
      setRefreshing(false);
    }
  };

  const handleRefresh = () => {
    setRefreshing(true);
    loadDevices();
  };

  const handleDelete = (id, deviceName) => {
    Alert.alert(
      'Delete Device',
      `Are you sure you want to delete device ${deviceName}?`,
      [
        { text: 'Cancel', style: 'cancel' },
        {
          text: 'Delete',
          style: 'destructive',
          onPress: async () => {
            try {
              await deviceService.delete(id);
              loadDevices();
              Alert.alert('Success', 'Device deleted successfully');
            } catch (error) {
              Alert.alert('Error', error.message || 'Failed to delete device');
            }
          },
        },
      ]
    );
  };

  const renderDevice = (device) => (
    <Card
      key={device.id}
      onPress={() => navigation.navigate('DeviceDetail', { deviceId: device.id })}
    >
      <CardHeader
        title={device.device || 'Unknown Device'}
        subtitle={`ID: ${device.id}`}
        rightElement={
          <TouchableOpacity
            onPress={() => handleDelete(device.id, device.device)}
            style={styles.deleteButton}
          >
            <Text style={styles.deleteButtonText}>Delete</Text>
          </TouchableOpacity>
        }
      />
    </Card>
  );

  return (
    <View style={styles.container}>
      <StatusBar style="dark" />
      <Header
        title="Devices"
        navigation={navigation}
        rightElement={
          <TouchableOpacity
            onPress={() => navigation.navigate('DeviceForm')}
            style={styles.addButton}
          >
            <Text style={styles.addButtonText}>+ Add</Text>
          </TouchableOpacity>
        }
      />

      <ScrollView
        style={styles.content}
        contentContainerStyle={styles.contentContainer}
        refreshing={refreshing}
        onRefresh={handleRefresh}
      >
        {loading ? (
          <View style={styles.loadingContainer}>
            <ActivityIndicator size="large" color="#007AFF" />
          </View>
        ) : devices.length === 0 ? (
          <View style={styles.emptyContainer}>
            <Text style={styles.emptyText}>No devices found</Text>
            <TouchableOpacity
              onPress={() => navigation.navigate('DeviceForm')}
              style={styles.emptyButton}
            >
              <Text style={styles.emptyButtonText}>Add First Device</Text>
            </TouchableOpacity>
          </View>
        ) : (
          devices.map(renderDevice)
        )}
      </ScrollView>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f5f5f5',
  },
  content: {
    flex: 1,
  },
  contentContainer: {
    paddingVertical: 16,
  },
  loadingContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    paddingTop: 100,
  },
  emptyContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    paddingTop: 100,
  },
  emptyText: {
    fontSize: 16,
    color: '#666',
    marginBottom: 20,
  },
  emptyButton: {
    backgroundColor: '#007AFF',
    paddingHorizontal: 24,
    paddingVertical: 12,
    borderRadius: 8,
  },
  emptyButtonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: '600',
  },
  addButton: {
    backgroundColor: '#007AFF',
    paddingHorizontal: 16,
    paddingVertical: 8,
    borderRadius: 8,
  },
  addButtonText: {
    color: '#fff',
    fontSize: 14,
    fontWeight: '600',
  },
  deleteButton: {
    backgroundColor: '#ff3b30',
    paddingHorizontal: 12,
    paddingVertical: 6,
    borderRadius: 6,
  },
  deleteButtonText: {
    color: '#fff',
    fontSize: 12,
    fontWeight: '600',
  },
});

export default DevicesListScreen;
