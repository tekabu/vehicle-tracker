import React, { useState, useEffect } from 'react';
import { View, Text, ScrollView, StyleSheet, TouchableOpacity, ActivityIndicator, Alert } from 'react-native';
import { StatusBar } from 'expo-status-bar';
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

  const loadRentals = async () => {
    try {
      setLoading(true);
      const data = await rentalService.getAll();
      setRentals(data);
    } catch (error) {
      Alert.alert('Error', error.message || 'Failed to load rentals');
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

  const getStatusColor = (status) => {
    switch (status) {
      case 'active':
        return '#34C759';
      case 'pending':
        return '#FF9500';
      case 'completed':
        return '#007AFF';
      case 'cancelled':
        return '#FF3B30';
      default:
        return '#666';
    }
  };

  const formatDate = (dateString) => {
    return new Date(dateString).toLocaleDateString();
  };

  const renderRental = (rental) => {
    const vehicleInfo = rental.vehicle
      ? `${rental.vehicle.make} ${rental.vehicle.model} (${rental.vehicle.plate_number})`
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
            <View style={styles.statusBadgeContainer}>
              <View style={[styles.statusBadge, { backgroundColor: getStatusColor(rental.status) }]}>
                <Text style={styles.statusText}>{rental.status}</Text>
              </View>
              <TouchableOpacity
                onPress={() => handleDelete(rental.id, vehicleInfo)}
                style={styles.deleteButton}
              >
                <Text style={styles.deleteButtonText}>Delete</Text>
              </TouchableOpacity>
            </View>
          }
        />
        <CardRow label="Start Date" value={formatDate(rental.start_date)} />
        <CardRow label="End Date" value={formatDate(rental.end_date)} />
        <CardRow label="Daily Rate" value={`$${rental.daily_rate}`} />
        <CardRow label="Total Amount" value={`$${rental.total_amount}`} />
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
  statusBadgeContainer: {
    alignItems: 'flex-end',
  },
  statusBadge: {
    paddingHorizontal: 12,
    paddingVertical: 6,
    borderRadius: 12,
    marginBottom: 8,
  },
  statusText: {
    color: '#fff',
    fontSize: 12,
    fontWeight: '600',
    textTransform: 'capitalize',
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
