import React, { useState, useEffect } from 'react';
import { View, Text, ScrollView, TextInput, StyleSheet, TouchableOpacity, ActivityIndicator, Alert } from 'react-native';
import { StatusBar } from 'expo-status-bar';
import Header from '../../components/Header';
import Card, { CardHeader, CardRow, CardSection } from '../../components/Card';
import rentalService from '../../services/rentalService';

const RentalDetailScreen = ({ navigation, route }) => {
  const { rentalId } = route.params;
  const [rental, setRental] = useState(null);
  const [loading, setLoading] = useState(true);
  const [actionLoading, setActionLoading] = useState(false);

  // Start rental form state
  const [odometerStart, setOdometerStart] = useState('');

  // End rental form state
  const [odometerEnd, setOdometerEnd] = useState('');
  const [fuelLevel, setFuelLevel] = useState('full');
  const [conditionNotes, setConditionNotes] = useState('');

  useEffect(() => {
    loadRental();
  }, [rentalId]);

  const loadRental = async () => {
    try {
      setLoading(true);
      const data = await rentalService.getById(rentalId);
      setRental(data);
    } catch (error) {
      Alert.alert('Error', error.message || 'Failed to load rental details');
      navigation.goBack();
    } finally {
      setLoading(false);
    }
  };

  const handleEdit = () => {
    navigation.navigate('RentalForm', { rental });
  };

  const handleDelete = () => {
    const vehicleInfo = rental.vehicle
      ? `${rental.vehicle.make} ${rental.vehicle.model}`
      : 'this rental';

    Alert.alert(
      'Delete Rental',
      `Are you sure you want to delete ${vehicleInfo}?`,
      [
        { text: 'Cancel', style: 'cancel' },
        {
          text: 'Delete',
          style: 'destructive',
          onPress: async () => {
            try {
              await rentalService.delete(rentalId);
              Alert.alert('Success', 'Rental deleted successfully');
              navigation.goBack();
            } catch (error) {
              Alert.alert('Error', error.message || 'Failed to delete rental');
            }
          },
        },
      ]
    );
  };

  const handleStartRental = async () => {
    if (!odometerStart.trim()) {
      Alert.alert('Error', 'Please enter the starting odometer reading');
      return;
    }

    try {
      setActionLoading(true);
      await rentalService.start(rentalId, {
        odometer_start: parseInt(odometerStart),
      });
      Alert.alert('Success', 'Rental started successfully');
      loadRental();
      setOdometerStart('');
    } catch (error) {
      Alert.alert('Error', error.message || 'Failed to start rental');
    } finally {
      setActionLoading(false);
    }
  };

  const handleEndRental = async () => {
    if (!odometerEnd.trim()) {
      Alert.alert('Error', 'Please enter the ending odometer reading');
      return;
    }

    try {
      setActionLoading(true);
      await rentalService.end(rentalId, {
        odometer_end: parseInt(odometerEnd),
        fuel_level: fuelLevel,
        condition_notes: conditionNotes,
      });
      Alert.alert('Success', 'Rental ended successfully');
      loadRental();
      setOdometerEnd('');
      setConditionNotes('');
    } catch (error) {
      Alert.alert('Error', error.message || 'Failed to end rental');
    } finally {
      setActionLoading(false);
    }
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
    if (!dateString) return 'N/A';
    return new Date(dateString).toLocaleString();
  };

  if (loading) {
    return (
      <View style={styles.container}>
        <StatusBar style="dark" />
        <Header title="Rental Details" navigation={navigation} />
        <View style={styles.loadingContainer}>
          <ActivityIndicator size="large" color="#007AFF" />
        </View>
      </View>
    );
  }

  if (!rental) {
    return null;
  }

  const vehicleInfo = rental.vehicle
    ? `${rental.vehicle.make} ${rental.vehicle.model} (${rental.vehicle.plate_number})`
    : 'Unknown Vehicle';

  return (
    <View style={styles.container}>
      <StatusBar style="dark" />
      <Header
        title="Rental Details"
        navigation={navigation}
        rightElement={
          rental.status === 'pending' && (
            <TouchableOpacity onPress={handleEdit} style={styles.editButton}>
              <Text style={styles.editButtonText}>Edit</Text>
            </TouchableOpacity>
          )
        }
      />

      <ScrollView style={styles.content} contentContainerStyle={styles.contentContainer}>
        <Card>
          <CardHeader
            title={vehicleInfo}
            subtitle={`Rental #${rental.id}`}
            rightElement={
              <View style={[styles.statusBadge, { backgroundColor: getStatusColor(rental.status) }]}>
                <Text style={styles.statusText}>{rental.status}</Text>
              </View>
            }
          />

          <CardSection>
            <Text style={styles.sectionTitle}>Customer Information</Text>
            <CardRow label="Name" value={rental.customer?.name || 'N/A'} />
            <CardRow label="Email" value={rental.customer?.email || 'N/A'} />
          </CardSection>

          <CardSection style={styles.section}>
            <Text style={styles.sectionTitle}>Rental Period</Text>
            <CardRow label="Start Date" value={formatDate(rental.start_date)} />
            <CardRow label="End Date" value={formatDate(rental.end_date)} />
            <CardRow label="Actual Start" value={formatDate(rental.actual_start_date)} />
            <CardRow label="Actual End" value={formatDate(rental.actual_end_date)} />
          </CardSection>

          <CardSection style={styles.section}>
            <Text style={styles.sectionTitle}>Financial Details</Text>
            <CardRow label="Daily Rate" value={`$${rental.daily_rate}`} />
            <CardRow label="Total Amount" value={`$${rental.total_amount}`} />
            <CardRow label="Deposit" value={`$${rental.deposit}`} />
          </CardSection>

          <CardSection style={styles.section}>
            <Text style={styles.sectionTitle}>Vehicle Condition</Text>
            <CardRow
              label="Odometer Start"
              value={rental.odometer_start ? `${rental.odometer_start} km` : 'N/A'}
            />
            <CardRow
              label="Odometer End"
              value={rental.odometer_end ? `${rental.odometer_end} km` : 'N/A'}
            />
            <CardRow label="Fuel Start" value={rental.fuel_level_start || 'N/A'} />
            <CardRow label="Fuel End" value={rental.fuel_level_end || 'N/A'} />
          </CardSection>

          {rental.notes && (
            <CardSection style={styles.section}>
              <Text style={styles.sectionTitle}>Notes</Text>
              <Text style={styles.notesText}>{rental.notes}</Text>
            </CardSection>
          )}
        </Card>

        {/* Start Rental Section */}
        {rental.status === 'pending' && (
          <Card style={styles.actionCard}>
            <Text style={styles.actionTitle}>Start Rental</Text>
            <Text style={styles.actionDescription}>
              Enter the starting odometer reading to begin the rental.
            </Text>
            <TextInput
              style={styles.input}
              value={odometerStart}
              onChangeText={setOdometerStart}
              placeholder="Odometer reading (km)"
              placeholderTextColor="#999"
              keyboardType="numeric"
            />
            <TouchableOpacity
              style={[styles.actionButton, styles.startButton, actionLoading && styles.actionButtonDisabled]}
              onPress={handleStartRental}
              disabled={actionLoading}
            >
              <Text style={styles.actionButtonText}>
                {actionLoading ? 'Starting...' : 'Start Rental'}
              </Text>
            </TouchableOpacity>
          </Card>
        )}

        {/* End Rental Section */}
        {rental.status === 'active' && (
          <Card style={styles.actionCard}>
            <Text style={styles.actionTitle}>End Rental</Text>
            <Text style={styles.actionDescription}>
              Complete the rental by recording the final vehicle condition.
            </Text>

            <View style={styles.formGroup}>
              <Text style={styles.label}>Odometer Reading (km) *</Text>
              <TextInput
                style={styles.input}
                value={odometerEnd}
                onChangeText={setOdometerEnd}
                placeholder="Enter ending odometer"
                placeholderTextColor="#999"
                keyboardType="numeric"
              />
            </View>

            <View style={styles.formGroup}>
              <Text style={styles.label}>Fuel Level *</Text>
              <View style={styles.fuelLevelContainer}>
                {['empty', '1/4', '1/2', '3/4', 'full'].map((level) => (
                  <TouchableOpacity
                    key={level}
                    style={[
                      styles.fuelButton,
                      fuelLevel === level && styles.fuelButtonActive,
                    ]}
                    onPress={() => setFuelLevel(level)}
                  >
                    <Text
                      style={[
                        styles.fuelButtonText,
                        fuelLevel === level && styles.fuelButtonTextActive,
                      ]}
                    >
                      {level}
                    </Text>
                  </TouchableOpacity>
                ))}
              </View>
            </View>

            <View style={styles.formGroup}>
              <Text style={styles.label}>Condition Notes</Text>
              <TextInput
                style={[styles.input, styles.textArea]}
                value={conditionNotes}
                onChangeText={setConditionNotes}
                placeholder="Any damage or issues?"
                placeholderTextColor="#999"
                multiline
                numberOfLines={3}
              />
            </View>

            <TouchableOpacity
              style={[styles.actionButton, styles.endButton, actionLoading && styles.actionButtonDisabled]}
              onPress={handleEndRental}
              disabled={actionLoading}
            >
              <Text style={styles.actionButtonText}>
                {actionLoading ? 'Ending...' : 'End Rental'}
              </Text>
            </TouchableOpacity>
          </Card>
        )}

        {rental.status === 'pending' && (
          <TouchableOpacity onPress={handleDelete} style={styles.deleteButton}>
            <Text style={styles.deleteButtonText}>Delete Rental</Text>
          </TouchableOpacity>
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
  notesText: {
    fontSize: 14,
    color: '#333',
    lineHeight: 20,
  },
  actionCard: {
    marginTop: 8,
  },
  actionTitle: {
    fontSize: 18,
    fontWeight: '600',
    color: '#333',
    marginBottom: 8,
  },
  actionDescription: {
    fontSize: 14,
    color: '#666',
    marginBottom: 16,
  },
  formGroup: {
    marginBottom: 16,
  },
  label: {
    fontSize: 14,
    fontWeight: '600',
    color: '#333',
    marginBottom: 8,
  },
  input: {
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 8,
    padding: 12,
    fontSize: 16,
    color: '#333',
    backgroundColor: '#fff',
  },
  textArea: {
    height: 80,
    textAlignVertical: 'top',
  },
  fuelLevelContainer: {
    flexDirection: 'row',
    gap: 8,
  },
  fuelButton: {
    flex: 1,
    paddingVertical: 10,
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#ddd',
    alignItems: 'center',
    backgroundColor: '#fff',
  },
  fuelButtonActive: {
    backgroundColor: '#007AFF',
    borderColor: '#007AFF',
  },
  fuelButtonText: {
    fontSize: 12,
    fontWeight: '600',
    color: '#666',
  },
  fuelButtonTextActive: {
    color: '#fff',
  },
  actionButton: {
    paddingVertical: 14,
    borderRadius: 8,
    alignItems: 'center',
    marginTop: 8,
  },
  actionButtonDisabled: {
    opacity: 0.6,
  },
  startButton: {
    backgroundColor: '#34C759',
  },
  endButton: {
    backgroundColor: '#007AFF',
  },
  actionButtonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: '600',
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
});

export default RentalDetailScreen;
