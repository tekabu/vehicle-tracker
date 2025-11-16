import React, { useState, useEffect } from 'react';
import { View, Text, ScrollView, StyleSheet, TouchableOpacity, ActivityIndicator, Alert } from 'react-native';
import { StatusBar } from 'expo-status-bar';
import { useFocusEffect } from '@react-navigation/native';
import Header from '../../components/Header';
import Card, { CardHeader, CardRow } from '../../components/Card';
import vehicleService from '../../services/vehicleService';

const VehiclesListScreen = ({ navigation }) => {
  const [vehicles, setVehicles] = useState([]);
  const [loading, setLoading] = useState(true);
  const [refreshing, setRefreshing] = useState(false);

  // Reload vehicles when screen comes into focus
  useFocusEffect(
    React.useCallback(() => {
      loadVehicles();
    }, [])
  );

  useEffect(() => {
    loadVehicles();
  }, []);

  const loadVehicles = async () => {
    try {
      setLoading(true);
      const data = await vehicleService.getAll();
      // Ensure data is always an array
      const vehiclesArray = Array.isArray(data) ? data : [];
      setVehicles(vehiclesArray);
    } catch (error) {
      Alert.alert('Error', error.message || 'Failed to load vehicles');
      setVehicles([]); // Set empty array on error
    } finally {
      setLoading(false);
      setRefreshing(false);
    }
  };

  const handleRefresh = () => {
    setRefreshing(true);
    loadVehicles();
  };

  const handleDelete = (id, plateNo) => {
    Alert.alert(
      'Delete Vehicle',
      `Are you sure you want to delete vehicle ${plateNo}?`,
      [
        { text: 'Cancel', style: 'cancel' },
        {
          text: 'Delete',
          style: 'destructive',
          onPress: async () => {
            try {
              await vehicleService.delete(id);
              loadVehicles();
              Alert.alert('Success', 'Vehicle deleted successfully');
            } catch (error) {
              Alert.alert('Error', error.message || 'Failed to delete vehicle');
            }
          },
        },
      ]
    );
  };

  const renderVehicle = (vehicle) => (
    <Card
      key={vehicle.id}
      onPress={() => navigation.navigate('VehicleDetail', { vehicleId: vehicle.id })}
    >
      <CardHeader
        title={vehicle.car_type}
        subtitle={vehicle.plate_no}
        rightElement={
          <TouchableOpacity
            onPress={() => handleDelete(vehicle.id, vehicle.plate_no)}
            style={styles.deleteButton}
          >
            <Text style={styles.deleteButtonText}>Delete</Text>
          </TouchableOpacity>
        }
      />
      {vehicle.device && (
        <CardRow label="Device" value={vehicle.device.device_id} />
      )}
    </Card>
  );

  return (
    <View style={styles.container}>
      <StatusBar style="dark" />
      <Header
        title="Vehicles"
        navigation={navigation}
        rightElement={
          <TouchableOpacity
            onPress={() => navigation.navigate('VehicleForm')}
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
        ) : vehicles.length === 0 ? (
          <View style={styles.emptyContainer}>
            <Text style={styles.emptyText}>No vehicles found</Text>
            <TouchableOpacity
              onPress={() => navigation.navigate('VehicleForm')}
              style={styles.emptyButton}
            >
              <Text style={styles.emptyButtonText}>Add First Vehicle</Text>
            </TouchableOpacity>
          </View>
        ) : (
          vehicles.map(renderVehicle)
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

export default VehiclesListScreen;
