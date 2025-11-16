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
    plate_no: vehicle?.plate_no || '',
    car_type: vehicle?.car_type || '',
    device_id: vehicle?.device_id?.toString() || '',
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

    if (!formData.plate_no.trim()) {
      newErrors.plate_no = 'Plate number is required';
    }

    if (!formData.car_type.trim()) {
      newErrors.car_type = 'Car type is required';
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
        plate_no: formData.plate_no,
        car_type: formData.car_type,
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
      if (error.errors && Object.keys(error.errors).length > 0) {
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
        showBackButton={true}
      />

      <ScrollView style={styles.content} contentContainerStyle={styles.contentContainer}>
        <View style={styles.form}>
          <View style={styles.formGroup}>
            <Text style={styles.label}>Plate Number *</Text>
            <TextInput
              style={[styles.input, errors.plate_no && styles.inputError]}
              value={formData.plate_no}
              onChangeText={(value) => handleChange('plate_no', value)}
              placeholder="Enter plate number (e.g., ABC-1234)"
              placeholderTextColor="#999"
              autoCapitalize="characters"
            />
            {errors.plate_no && <Text style={styles.errorText}>{errors.plate_no}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Car Type *</Text>
            <TextInput
              style={[styles.input, errors.car_type && styles.inputError]}
              value={formData.car_type}
              onChangeText={(value) => handleChange('car_type', value)}
              placeholder="Enter car type (e.g., Toyota Camry 2023)"
              placeholderTextColor="#999"
            />
            {errors.car_type && <Text style={styles.errorText}>{errors.car_type}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Device</Text>
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
                      label={`${device.device}`}
                      value={device.id.toString()}
                    />
                  ))}
                </Picker>
              </View>
            )}
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
