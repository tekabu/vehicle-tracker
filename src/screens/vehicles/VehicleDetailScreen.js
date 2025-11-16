import React, { useState, useEffect } from 'react';
import { View, Text, ScrollView, StyleSheet, TouchableOpacity, ActivityIndicator, Alert } from 'react-native';
import { StatusBar } from 'expo-status-bar';
import { useFocusEffect } from '@react-navigation/native';
import Header from '../../components/Header';
import Card, { CardHeader, CardRow, CardSection } from '../../components/Card';
import vehicleService from '../../services/vehicleService';

const VehicleDetailScreen = ({ navigation, route }) => {
  const { vehicleId } = route.params;
  const [vehicle, setVehicle] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadVehicle();
  }, [vehicleId]);

  // Reload vehicle when screen comes into focus
  useFocusEffect(
    React.useCallback(() => {
      loadVehicle();
    }, [vehicleId])
  );

  const loadVehicle = async () => {
    try {
      setLoading(true);
      const data = await vehicleService.getById(vehicleId);
      setVehicle(data);
    } catch (error) {
      Alert.alert('Error', error.message || 'Failed to load vehicle details');
      navigation.goBack();
    } finally {
      setLoading(false);
    }
  };

  const handleEdit = () => {
    navigation.navigate('VehicleForm', { vehicle });
  };

  const handleDelete = () => {
    Alert.alert(
      'Delete Vehicle',
      `Are you sure you want to delete ${vehicle.make} ${vehicle.model}?`,
      [
        { text: 'Cancel', style: 'cancel' },
        {
          text: 'Delete',
          style: 'destructive',
          onPress: async () => {
            try {
              await vehicleService.delete(vehicleId);
              Alert.alert('Success', 'Vehicle deleted successfully');
              navigation.goBack();
            } catch (error) {
              Alert.alert('Error', error.message || 'Failed to delete vehicle');
            }
          },
        },
      ]
    );
  };

  const getStatusColor = (status) => {
    switch (status) {
      case 'available':
        return '#34C759';
      case 'rented':
        return '#FF9500';
      case 'maintenance':
        return '#FF3B30';
      default:
        return '#666';
    }
  };

  if (loading) {
    return (
      <View style={styles.container}>
        <StatusBar style="dark" />
        <Header title="Vehicle Details" navigation={navigation} showBackButton={true} />
        <View style={styles.loadingContainer}>
          <ActivityIndicator size="large" color="#007AFF" />
        </View>
      </View>
    );
  }

  if (!vehicle) {
    return null;
  }

  return (
    <View style={styles.container}>
      <StatusBar style="dark" />
      <Header
        title="Vehicle Details"
        navigation={navigation}
        showBackButton={true}
        rightElement={
          <TouchableOpacity onPress={handleEdit} style={styles.editButton}>
            <Text style={styles.editButtonText}>Edit</Text>
          </TouchableOpacity>
        }
      />

      <ScrollView style={styles.content} contentContainerStyle={styles.contentContainer}>
        <Card>
          <CardHeader
            title={`${vehicle.plate_no} - ${vehicle.car_type}`}
            subtitle={`ID: ${vehicle.id}`}
          />

          <CardSection style={styles.section}>
            <Text style={styles.sectionTitle}>Basic Information</Text>
            <CardRow label="Plate Number" value={vehicle.plate_no} />
          </CardSection>

          {vehicle.device && (
            <CardSection style={styles.section}>
              <Text style={styles.sectionTitle}>Device</Text>
              <CardRow label="Device ID" value={vehicle.device.device} />

              <TouchableOpacity
                onPress={() => navigation.navigate('VehicleTracking', { vehicleId: vehicle.id })}
                style={styles.trackButton}
              >
                <Text style={styles.trackButtonText}>Track Vehicle Location</Text>
              </TouchableOpacity>
            </CardSection>
          )}

          <CardSection>
            <CardRow
              label="Created"
              value={new Date(vehicle.created_at).toLocaleDateString()}
            />
            <CardRow
              label="Last Updated"
              value={new Date(vehicle.updated_at).toLocaleDateString()}
            />
          </CardSection>
        </Card>

        <TouchableOpacity
          onPress={handleDelete}
          style={styles.deleteButton}
        >
          <Text style={styles.deleteButtonText}>Delete Vehicle</Text>
        </TouchableOpacity>
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
  },
  editButton: {
    backgroundColor: '#007AFF',
    paddingHorizontal: 16,
    paddingVertical: 8,
    borderRadius: 8,
  },
  editButtonText: {
    color: '#fff',
    fontSize: 14,
    fontWeight: '600',
  },
  statusBadge: {
    paddingHorizontal: 12,
    paddingVertical: 6,
    borderRadius: 12,
  },
  statusText: {
    color: '#fff',
    fontSize: 12,
    fontWeight: '600',
    textTransform: 'capitalize',
  },
  section: {
    marginTop: 16,
    paddingTop: 16,
    borderTopWidth: 1,
    borderTopColor: '#f0f0f0',
  },
  sectionTitle: {
    fontSize: 14,
    fontWeight: '600',
    color: '#666',
    marginBottom: 8,
  },
  deleteButton: {
    backgroundColor: '#ff3b30',
    marginHorizontal: 20,
    marginTop: 16,
    marginBottom: 32,
    paddingVertical: 14,
    borderRadius: 8,
    alignItems: 'center',
  },
  deleteButtonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: '600',
  },
  trackButton: {
    backgroundColor: '#007AFF',
    marginTop: 12,
    paddingVertical: 12,
    borderRadius: 8,
    alignItems: 'center',
  },
  trackButtonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: '600',
  },
});

export default VehicleDetailScreen;
