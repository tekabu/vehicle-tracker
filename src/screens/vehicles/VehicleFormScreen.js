import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  ScrollView,
  TextInput,
  TouchableOpacity,
  StyleSheet,
  Alert,
  KeyboardAvoidingView,
  Platform,
  ActivityIndicator,
} from 'react-native';
import { StatusBar } from 'expo-status-bar';
import { Picker } from '@react-native-picker/picker';
import Header from '../../components/Header';
import vehicleService from '../../services/vehicleService';
import deviceService from '../../services/deviceService';

const VehicleFormScreen = ({ navigation, route }) => {
  const vehicle = route.params?.vehicle;
  const isEditing = !!vehicle;

  const [formData, setFormData] = useState({
    plate_number: vehicle?.plate_number || '',
    make: vehicle?.make || '',
    model: vehicle?.model || '',
    year: vehicle?.year?.toString() || '',
    color: vehicle?.color || '',
    vin: vehicle?.vin || '',
    device_id: vehicle?.device_id?.toString() || '',
    status: vehicle?.status || 'available',
  });
  const [devices, setDevices] = useState([]);
  const [loading, setLoading] = useState(false);
  const [loadingDevices, setLoadingDevices] = useState(true);
  const [errors, setErrors] = useState({});

  useEffect(() => {
    loadDevices();
  }, []);

  const loadDevices = async () => {
    try {
      setLoadingDevices(true);
      const data = await deviceService.getAll();
      setDevices(data);
    } catch (error) {
      Alert.alert('Error', 'Failed to load devices');
    } finally {
      setLoadingDevices(false);
    }
  };

  const handleChange = (field, value) => {
    setFormData({ ...formData, [field]: value });
    if (errors[field]) {
      setErrors({ ...errors, [field]: null });
    }
  };

  const validateForm = () => {
    const newErrors = {};

    if (!formData.plate_number.trim()) {
      newErrors.plate_number = 'Plate number is required';
    }

    if (!formData.make.trim()) {
      newErrors.make = 'Make is required';
    }

    if (!formData.model.trim()) {
      newErrors.model = 'Model is required';
    }

    if (!formData.year.trim()) {
      newErrors.year = 'Year is required';
    } else if (isNaN(formData.year) || formData.year < 1900 || formData.year > 2100) {
      newErrors.year = 'Invalid year';
    }

    if (!formData.color.trim()) {
      newErrors.color = 'Color is required';
    }

    if (!formData.vin.trim()) {
      newErrors.vin = 'VIN is required';
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
        ...formData,
        year: parseInt(formData.year),
        device_id: formData.device_id ? parseInt(formData.device_id) : null,
      };

      if (isEditing) {
        await vehicleService.update(vehicle.id, submitData);
        Alert.alert('Success', 'Vehicle updated successfully');
      } else {
        await vehicleService.create(submitData);
        Alert.alert('Success', 'Vehicle created successfully');
      }
      navigation.goBack();
    } catch (error) {
      if (error.errors) {
        setErrors(error.errors);
      }
      Alert.alert('Error', error.message || 'Failed to save vehicle');
    } finally {
      setLoading(false);
    }
  };

  return (
    <KeyboardAvoidingView
      style={styles.container}
      behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
    >
      <StatusBar style="dark" />
      <Header
        title={isEditing ? 'Edit Vehicle' : 'New Vehicle'}
        navigation={navigation}
      />

      <ScrollView style={styles.content} contentContainerStyle={styles.contentContainer}>
        <View style={styles.form}>
          <View style={styles.formGroup}>
            <Text style={styles.label}>Plate Number *</Text>
            <TextInput
              style={[styles.input, errors.plate_number && styles.inputError]}
              value={formData.plate_number}
              onChangeText={(value) => handleChange('plate_number', value)}
              placeholder="Enter plate number (e.g., ABC-1234)"
              placeholderTextColor="#999"
              autoCapitalize="characters"
            />
            {errors.plate_number && <Text style={styles.errorText}>{errors.plate_number}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Make *</Text>
            <TextInput
              style={[styles.input, errors.make && styles.inputError]}
              value={formData.make}
              onChangeText={(value) => handleChange('make', value)}
              placeholder="Enter make (e.g., Toyota)"
              placeholderTextColor="#999"
            />
            {errors.make && <Text style={styles.errorText}>{errors.make}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Model *</Text>
            <TextInput
              style={[styles.input, errors.model && styles.inputError]}
              value={formData.model}
              onChangeText={(value) => handleChange('model', value)}
              placeholder="Enter model (e.g., Camry)"
              placeholderTextColor="#999"
            />
            {errors.model && <Text style={styles.errorText}>{errors.model}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Year *</Text>
            <TextInput
              style={[styles.input, errors.year && styles.inputError]}
              value={formData.year}
              onChangeText={(value) => handleChange('year', value)}
              placeholder="Enter year (e.g., 2023)"
              placeholderTextColor="#999"
              keyboardType="numeric"
            />
            {errors.year && <Text style={styles.errorText}>{errors.year}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Color *</Text>
            <TextInput
              style={[styles.input, errors.color && styles.inputError]}
              value={formData.color}
              onChangeText={(value) => handleChange('color', value)}
              placeholder="Enter color (e.g., Silver)"
              placeholderTextColor="#999"
            />
            {errors.color && <Text style={styles.errorText}>{errors.color}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>VIN *</Text>
            <TextInput
              style={[styles.input, errors.vin && styles.inputError]}
              value={formData.vin}
              onChangeText={(value) => handleChange('vin', value)}
              placeholder="Enter VIN"
              placeholderTextColor="#999"
              autoCapitalize="characters"
            />
            {errors.vin && <Text style={styles.errorText}>{errors.vin}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>GPS Device</Text>
            {loadingDevices ? (
              <ActivityIndicator size="small" color="#007AFF" />
            ) : (
              <View style={styles.pickerContainer}>
                <Picker
                  selectedValue={formData.device_id}
                  onValueChange={(value) => handleChange('device_id', value)}
                  style={styles.picker}
                >
                  <Picker.Item label="Select a device (optional)" value="" />
                  {devices.map((device) => (
                    <Picker.Item
                      key={device.id}
                      label={`${device.device_id} (${device.type})`}
                      value={device.id.toString()}
                    />
                  ))}
                </Picker>
              </View>
            )}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Status *</Text>
            <View style={styles.statusContainer}>
              <TouchableOpacity
                style={[
                  styles.statusButton,
                  formData.status === 'available' && styles.statusButtonActive,
                ]}
                onPress={() => handleChange('status', 'available')}
              >
                <Text
                  style={[
                    styles.statusButtonText,
                    formData.status === 'available' && styles.statusButtonTextActive,
                  ]}
                >
                  Available
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                style={[
                  styles.statusButton,
                  formData.status === 'rented' && styles.statusButtonActive,
                ]}
                onPress={() => handleChange('status', 'rented')}
              >
                <Text
                  style={[
                    styles.statusButtonText,
                    formData.status === 'rented' && styles.statusButtonTextActive,
                  ]}
                >
                  Rented
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                style={[
                  styles.statusButton,
                  formData.status === 'maintenance' && styles.statusButtonActive,
                ]}
                onPress={() => handleChange('status', 'maintenance')}
              >
                <Text
                  style={[
                    styles.statusButtonText,
                    formData.status === 'maintenance' && styles.statusButtonTextActive,
                  ]}
                >
                  Maintenance
                </Text>
              </TouchableOpacity>
            </View>
          </View>

          <TouchableOpacity
            style={[styles.submitButton, loading && styles.submitButtonDisabled]}
            onPress={handleSubmit}
            disabled={loading}
          >
            <Text style={styles.submitButtonText}>
              {loading ? 'Saving...' : isEditing ? 'Update Vehicle' : 'Create Vehicle'}
            </Text>
          </TouchableOpacity>
        </View>
      </ScrollView>
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
  errorText: {
    color: '#ff3b30',
    fontSize: 12,
    marginTop: 4,
  },
  pickerContainer: {
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 8,
    overflow: 'hidden',
  },
  picker: {
    height: 50,
  },
  statusContainer: {
    flexDirection: 'row',
    gap: 8,
  },
  statusButton: {
    flex: 1,
    paddingVertical: 12,
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#ddd',
    alignItems: 'center',
    backgroundColor: '#fff',
  },
  statusButtonActive: {
    backgroundColor: '#007AFF',
    borderColor: '#007AFF',
  },
  statusButtonText: {
    fontSize: 14,
    fontWeight: '600',
    color: '#666',
  },
  statusButtonTextActive: {
    color: '#fff',
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
});

export default VehicleFormScreen;
