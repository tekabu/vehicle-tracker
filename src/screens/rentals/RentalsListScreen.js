import React, { useState, useEffect } from 'react';
import { View, Text, ScrollView, StyleSheet, TouchableOpacity, ActivityIndicator, Alert } from 'react-native';
import { StatusBar } from 'expo-status-bar';
import { useFocusEffect } from '@react-navigation/native';
import Header from '../../components/Header';
import Card, { CardHeader, CardRow } from '../../components/Card';
import rentalService from '../../services/rentalService';

const RentalsListScreen = ({ navigation }) => {
  const [rentals, setRentals] = useState([]);
  const [loading, setLoading] = useState(true);
  const [refreshing, setRefreshing] = useState(false);

  useEffect(() => {
    loadRentals();
  }, []);

  // Reload rentals when screen comes into focus
  useFocusEffect(
    React.useCallback(() => {
      loadRentals();
    }, [])
  );

  const loadRentals = async () => {
    try {
      setLoading(true);
      const data = await rentalService.getAll();
      // Ensure data is always an array
      const rentalsArray = Array.isArray(data) ? data : [];
      setRentals(rentalsArray);
    } catch (error) {
      Alert.alert('Error', error.message || 'Failed to load rentals');
      setRentals([]); // Set empty array on error
    } finally {
      setLoading(false);
      setRefreshing(false);
    }
  };

  const handleRefresh = () => {
    setRefreshing(true);
    loadRentals();
  };

  const handleDelete = (id, vehicleInfo) => {
    Alert.alert(
      'Delete Rental',
      `Are you sure you want to delete this rental for ${vehicleInfo}?`,
      [
        { text: 'Cancel', style: 'cancel' },
        {
          text: 'Delete',
          style: 'destructive',
          onPress: async () => {
            try {
              await rentalService.delete(id);
              loadRentals();
              Alert.alert('Success', 'Rental deleted successfully');
            } catch (error) {
              Alert.alert('Error', error.message || 'Failed to delete rental');
            }
          },
        },
      ]
    );
  };

  const formatDate = (dateString) => {
    if (!dateString) return 'N/A';
    return new Date(dateString).toLocaleDateString();
  };

  const renderRental = (rental) => {
    const vehicleInfo = rental.vehicle
      ? `${rental.vehicle.car_type} (${rental.vehicle.plate_no})`
      : 'Unknown Vehicle';
    const customerName = rental.customer?.name || 'Unknown Customer';

    return (
      <Card
        key={rental.id}
        onPress={() => navigation.navigate('RentalDetail', { rentalId: rental.id })}
      >
        <CardHeader
          title={vehicleInfo}
          subtitle={customerName}
          rightElement={
            <TouchableOpacity
              onPress={() => handleDelete(rental.id, vehicleInfo)}
              style={styles.deleteButton}
            >
              <Text style={styles.deleteButtonText}>Delete</Text>
            </TouchableOpacity>
          }
        />
        <CardRow label="Started At" value={formatDate(rental.started_at)} />
        <CardRow label="Ended At" value={formatDate(rental.ended_at)} />
      </Card>
    );
  };

  return (
    <View style={styles.container}>
      <StatusBar style="dark" />
      <Header
        title="Rentals"
        navigation={navigation}
        rightElement={
          <TouchableOpacity
            onPress={() => navigation.navigate('RentalForm')}
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
        ) : rentals.length === 0 ? (
          <View style={styles.emptyContainer}>
            <Text style={styles.emptyText}>No rentals found</Text>
            <TouchableOpacity
              onPress={() => navigation.navigate('RentalForm')}
              style={styles.emptyButton}
            >
              <Text style={styles.emptyButtonText}>Add First Rental</Text>
            </TouchableOpacity>
          </View>
        ) : (
          rentals.map(renderRental)
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

export default RentalsListScreen;
