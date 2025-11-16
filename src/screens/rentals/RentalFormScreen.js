import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  ScrollView,
  TouchableOpacity,
  StyleSheet,
  Alert,
  KeyboardAvoidingView,
  Platform,
  ActivityIndicator,
} from 'react-native';
import { StatusBar } from 'expo-status-bar';
import { Picker } from '@react-native-picker/picker';
import DateTimePicker from '@react-native-community/datetimepicker';
import Header from '../../components/Header';
import rentalService from '../../services/rentalService';
import vehicleService from '../../services/vehicleService';
import customerService from '../../services/customerService';

const RentalFormScreen = ({ navigation, route }) => {
  const rental = route.params?.rental;
  const isEditing = !!rental;

  const [formData, setFormData] = useState({
    vehicle_id: rental?.vehicle_id?.toString() || '',
    customer_id: rental?.customer_id?.toString() || '',
    started_at: rental?.started_at || '',
    ended_at: rental?.ended_at || '',
  });
  const [vehicles, setVehicles] = useState([]);
  const [customers, setCustomers] = useState([]);
  const [loading, setLoading] = useState(false);
  const [loadingData, setLoadingData] = useState(true);
  const [errors, setErrors] = useState({});

  // Date picker states
  const [showStartDatePicker, setShowStartDatePicker] = useState(false);
  const [showEndDatePicker, setShowEndDatePicker] = useState(false);
  const [startDate, setStartDate] = useState(
    rental?.started_at ? new Date(rental.started_at) : new Date()
  );
  const [endDate, setEndDate] = useState(
    rental?.ended_at ? new Date(rental.ended_at) : new Date()
  );

  useEffect(() => {
    loadInitialData();
  }, []);

  const loadInitialData = async () => {
    try {
      setLoadingData(true);
      const [vehiclesData, customersData] = await Promise.all([
        vehicleService.getAll(),
        customerService.getAll(),
      ]);
      setVehicles(vehiclesData);
      setCustomers(customersData);
    } catch (error) {
      Alert.alert('Error', 'Failed to load required data');
    } finally {
      setLoadingData(false);
    }
  };

  const handleChange = (field, value) => {
    setFormData({ ...formData, [field]: value });
    if (errors[field]) {
      setErrors({ ...errors, [field]: null });
    }
  };

  const formatDateToString = (date) => {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
  };

  const formatDateForDisplay = (dateString) => {
    if (!dateString) return '';
    const date = new Date(dateString);
    const months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    const month = months[date.getMonth()];
    const day = String(date.getDate()).padStart(2, '0');
    const year = date.getFullYear();
    return `${month}. ${day}, ${year}`;
  };

  const onStartDateChange = (event, selectedDate) => {
    setShowStartDatePicker(Platform.OS === 'ios');
    if (selectedDate) {
      setStartDate(selectedDate);
      const formattedDate = formatDateToString(selectedDate);
      handleChange('started_at', formattedDate);
    }
  };

  const onEndDateChange = (event, selectedDate) => {
    setShowEndDatePicker(Platform.OS === 'ios');
    if (selectedDate) {
      setEndDate(selectedDate);
      const formattedDate = formatDateToString(selectedDate);
      handleChange('ended_at', formattedDate);
    }
  };

  const clearStartDate = () => {
    handleChange('started_at', '');
  };

  const clearEndDate = () => {
    handleChange('ended_at', '');
  };

  const validateForm = () => {
    const newErrors = {};

    if (!formData.vehicle_id) {
      newErrors.vehicle_id = 'Vehicle is required';
    }

    if (!formData.customer_id) {
      newErrors.customer_id = 'Customer is required';
    }

    // started_at is optional
    // ended_at validation: invalid if ended_at is not empty and started_at is empty
    if (formData.ended_at.trim() && !formData.started_at.trim()) {
      newErrors.ended_at = 'Cannot have end date without start date';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async () => {
    if (!validateForm()) {
      return;
    }

    try {
      setLoading(true);
      const submitData = {
        vehicle_id: parseInt(formData.vehicle_id),
        customer_id: parseInt(formData.customer_id),
        started_at: formData.started_at.trim() || null,
        ended_at: formData.ended_at.trim() || null,
      };

      if (isEditing) {
        await rentalService.update(rental.id, submitData);
        Alert.alert('Success', 'Rental updated successfully');
      } else {
        await rentalService.create(submitData);
        Alert.alert('Success', 'Rental created successfully');
      }
      navigation.goBack();
    } catch (error) {
      if (error.errors && Object.keys(error.errors).length > 0) {
        setErrors(error.errors);
      }
      Alert.alert('Error', error.message || 'Failed to save rental');
    } finally {
      setLoading(false);
    }
  };

  if (loadingData) {
    return (
      <View style={styles.container}>
        <StatusBar style="dark" />
        <Header title={isEditing ? 'Edit Rental' : 'New Rental'} navigation={navigation} />
        <View style={styles.loadingContainer}>
          <ActivityIndicator size="large" color="#007AFF" />
        </View>
      </View>
    );
  }

  return (
    <KeyboardAvoidingView
      style={styles.container}
      behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
    >
      <StatusBar style="dark" />
      <Header
        title={isEditing ? 'Edit Rental' : 'New Rental'}
        navigation={navigation}
        showBackButton={true}
      />

      <ScrollView style={styles.content} contentContainerStyle={styles.contentContainer}>
        <View style={styles.form}>
          <View style={styles.formGroup}>
            <Text style={styles.label}>Vehicle *</Text>
            <View style={styles.pickerContainer}>
              <Picker
                selectedValue={formData.vehicle_id}
                onValueChange={(value) => handleChange('vehicle_id', value)}
                style={styles.picker}
              >
                <Picker.Item label="Select a vehicle" value="" />
                {vehicles.map((vehicle) => (
                  <Picker.Item
                    key={vehicle.id}
                    label={`${vehicle.car_type} - ${vehicle.plate_no}`}
                    value={vehicle.id.toString()}
                  />
                ))}
              </Picker>
            </View>
            {errors.vehicle_id && <Text style={styles.errorText}>{errors.vehicle_id}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Customer *</Text>
            <View style={styles.pickerContainer}>
              <Picker
                selectedValue={formData.customer_id}
                onValueChange={(value) => handleChange('customer_id', value)}
                style={styles.picker}
              >
                <Picker.Item label="Select a customer" value="" />
                {customers.map((customer) => (
                  <Picker.Item
                    key={customer.id}
                    label={customer.name}
                    value={customer.id.toString()}
                  />
                ))}
              </Picker>
            </View>
            {errors.customer_id && <Text style={styles.errorText}>{errors.customer_id}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Start Date</Text>
            <View style={styles.datePickerRow}>
              <TouchableOpacity
                style={[styles.dateButton, errors.started_at && styles.inputError]}
                onPress={() => setShowStartDatePicker(true)}
              >
                <Text style={formData.started_at ? styles.dateText : styles.datePlaceholder}>
                  {formData.started_at ? formatDateForDisplay(formData.started_at) : 'Select start date (optional)'}
                </Text>
              </TouchableOpacity>
              {formData.started_at && (
                <TouchableOpacity
                  style={styles.clearButton}
                  onPress={clearStartDate}
                >
                  <Text style={styles.clearButtonText}>Clear</Text>
                </TouchableOpacity>
              )}
            </View>
            {errors.started_at && <Text style={styles.errorText}>{errors.started_at}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>End Date</Text>
            <View style={styles.datePickerRow}>
              <TouchableOpacity
                style={[styles.dateButton, errors.ended_at && styles.inputError]}
                onPress={() => setShowEndDatePicker(true)}
              >
                <Text style={formData.ended_at ? styles.dateText : styles.datePlaceholder}>
                  {formData.ended_at ? formatDateForDisplay(formData.ended_at) : 'Select end date (optional)'}
                </Text>
              </TouchableOpacity>
              {formData.ended_at && (
                <TouchableOpacity
                  style={styles.clearButton}
                  onPress={clearEndDate}
                >
                  <Text style={styles.clearButtonText}>Clear</Text>
                </TouchableOpacity>
              )}
            </View>
            {errors.ended_at && <Text style={styles.errorText}>{errors.ended_at}</Text>}
          </View>

          <TouchableOpacity
            style={[styles.submitButton, loading && styles.submitButtonDisabled]}
            onPress={handleSubmit}
            disabled={loading}
          >
            <Text style={styles.submitButtonText}>
              {loading ? 'Saving...' : isEditing ? 'Update Rental' : 'Create Rental'}
            </Text>
          </TouchableOpacity>
        </View>
      </ScrollView>

      {showStartDatePicker && (
        <DateTimePicker
          value={startDate}
          mode="date"
          display={Platform.OS === 'ios' ? 'spinner' : 'default'}
          onChange={onStartDateChange}
        />
      )}

      {showEndDatePicker && (
        <DateTimePicker
          value={endDate}
          mode="date"
          display={Platform.OS === 'ios' ? 'spinner' : 'default'}
          onChange={onEndDateChange}
        />
      )}
    </KeyboardAvoidingView>
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
  form: {
    backgroundColor: '#fff',
    marginHorizontal: 20,
    borderRadius: 12,
    padding: 20,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  formGroup: {
    marginBottom: 20,
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
  inputError: {
    borderColor: '#ff3b30',
  },
  textArea: {
    height: 80,
    textAlignVertical: 'top',
  },
  errorText: {
    color: '#ff3b30',
    fontSize: 12,
    marginTop: 4,
  },
  pickerContainer: {
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 8,
    justifyContent: 'center',
    height: 56,
  },
  picker: {
    height: 56,
    marginTop: Platform.OS === 'android' ? -4 : 0,
    marginBottom: Platform.OS === 'android' ? -4 : 0,
  },
  submitButton: {
    backgroundColor: '#007AFF',
    paddingVertical: 14,
    borderRadius: 8,
    alignItems: 'center',
    marginTop: 10,
  },
  submitButtonDisabled: {
    opacity: 0.6,
  },
  submitButtonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: '600',
  },
  datePickerRow: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 8,
  },
  dateButton: {
    flex: 1,
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 8,
    padding: 12,
    backgroundColor: '#fff',
    justifyContent: 'center',
  },
  dateText: {
    fontSize: 16,
    color: '#333',
  },
  datePlaceholder: {
    fontSize: 16,
    color: '#999',
  },
  clearButton: {
    paddingVertical: 12,
    paddingHorizontal: 16,
    backgroundColor: '#ff3b30',
    borderRadius: 8,
  },
  clearButtonText: {
    color: '#fff',
    fontSize: 14,
    fontWeight: '600',
  },
});

export default RentalFormScreen;
