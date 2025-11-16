import React, { useState, useEffect } from 'react';
import { View, Text, ScrollView, StyleSheet, TouchableOpacity, ActivityIndicator, Alert } from 'react-native';
import { StatusBar } from 'expo-status-bar';
import { useFocusEffect } from '@react-navigation/native';
import Header from '../../components/Header';
import Card, { CardHeader, CardRow } from '../../components/Card';
import customerService from '../../services/customerService';

const CustomersListScreen = ({ navigation }) => {
  const [customers, setCustomers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [refreshing, setRefreshing] = useState(false);

  // Reload customers when screen comes into focus
  useFocusEffect(
    React.useCallback(() => {
      loadCustomers();
    }, [])
  );

  useEffect(() => {
    loadCustomers();
  }, []);

  const loadCustomers = async () => {
    try {
      setLoading(true);
      const data = await customerService.getAll();
      // Ensure data is always an array
      const customersArray = Array.isArray(data) ? data : [];
      setCustomers(customersArray);
    } catch (error) {
      Alert.alert('Error', error.message || 'Failed to load customers');
      setCustomers([]); // Set empty array on error
    } finally {
      setLoading(false);
      setRefreshing(false);
    }
  };

  const handleRefresh = () => {
    setRefreshing(true);
    loadCustomers();
  };

  const handleDelete = (id, name) => {
    Alert.alert(
      'Delete Customer',
      `Are you sure you want to delete ${name}?`,
      [
        { text: 'Cancel', style: 'cancel' },
        {
          text: 'Delete',
          style: 'destructive',
          onPress: async () => {
            try {
              await customerService.delete(id);
              loadCustomers();
              Alert.alert('Success', 'Customer deleted successfully');
            } catch (error) {
              Alert.alert('Error', error.message || 'Failed to delete customer');
            }
          },
        },
      ]
    );
  };

  const renderCustomer = (customer) => (
    <Card
      key={customer.id}
      onPress={() => navigation.navigate('CustomerDetail', { customerId: customer.id })}
    >
      <CardHeader
        title={customer.name}
        subtitle={customer.contact_no}
        rightElement={
          <TouchableOpacity
            onPress={() => handleDelete(customer.id, customer.name)}
            style={styles.deleteButton}
          >
            <Text style={styles.deleteButtonText}>Delete</Text>
          </TouchableOpacity>
        }
      />
      <CardRow label="Address" value={customer.address || 'N/A'} />
    </Card>
  );

  return (
    <View style={styles.container}>
      <StatusBar style="dark" />
      <Header
        title="Customers"
        navigation={navigation}
        rightElement={
          <TouchableOpacity
            onPress={() => navigation.navigate('CustomerForm')}
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
        ) : customers.length === 0 ? (
          <View style={styles.emptyContainer}>
            <Text style={styles.emptyText}>No customers found</Text>
            <TouchableOpacity
              onPress={() => navigation.navigate('CustomerForm')}
              style={styles.emptyButton}
            >
              <Text style={styles.emptyButtonText}>Add First Customer</Text>
            </TouchableOpacity>
          </View>
        ) : (
          customers.map(renderCustomer)
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

export default CustomersListScreen;
