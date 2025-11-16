import React, { useState } from 'react';
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
} from 'react-native';
import { StatusBar } from 'expo-status-bar';
import Header from '../../components/Header';
import deviceService from '../../services/deviceService';

const DeviceFormScreen = ({ navigation, route }) => {
  const device = route.params?.device;
  const isEditing = !!device;

  const [formData, setFormData] = useState({
    device_id: device?.device_id || '',
    type: device?.type || '',
    status: device?.status || 'active',
  });
  const [loading, setLoading] = useState(false);
  const [errors, setErrors] = useState({});

  const handleChange = (field, value) => {
    setFormData({ ...formData, [field]: value });
    if (errors[field]) {
      setErrors({ ...errors, [field]: null });
    }
  };

  const validateForm = () => {
    const newErrors = {};

    if (!formData.device_id.trim()) {
      newErrors.device_id = 'Device ID is required';
    }

    if (!formData.type.trim()) {
      newErrors.type = 'Device type is required';
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
      if (isEditing) {
        await deviceService.update(device.id, formData);
        Alert.alert('Success', 'Device updated successfully');
      } else {
        await deviceService.create(formData);
        Alert.alert('Success', 'Device created successfully');
      }
      navigation.goBack();
    } catch (error) {
      if (error.errors) {
        setErrors(error.errors);
      }
      Alert.alert('Error', error.message || 'Failed to save device');
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
        title={isEditing ? 'Edit Device' : 'New Device'}
        navigation={navigation}
      />

      <ScrollView style={styles.content} contentContainerStyle={styles.contentContainer}>
        <View style={styles.form}>
          <View style={styles.formGroup}>
            <Text style={styles.label}>Device ID *</Text>
            <TextInput
              style={[styles.input, errors.device_id && styles.inputError]}
              value={formData.device_id}
              onChangeText={(value) => handleChange('device_id', value)}
              placeholder="Enter device ID (e.g., DEV-001)"
              placeholderTextColor="#999"
              autoCapitalize="characters"
            />
            {errors.device_id && <Text style={styles.errorText}>{errors.device_id}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Device Type *</Text>
            <TextInput
              style={[styles.input, errors.type && styles.inputError]}
              value={formData.type}
              onChangeText={(value) => handleChange('type', value)}
              placeholder="Enter device type (e.g., GPS Tracker)"
              placeholderTextColor="#999"
            />
            {errors.type && <Text style={styles.errorText}>{errors.type}</Text>}
          </View>

          <View style={styles.formGroup}>
            <Text style={styles.label}>Status *</Text>
            <View style={styles.statusContainer}>
              <TouchableOpacity
                style={[
                  styles.statusButton,
                  formData.status === 'active' && styles.statusButtonActive,
                ]}
                onPress={() => handleChange('status', 'active')}
              >
                <Text
                  style={[
                    styles.statusButtonText,
                    formData.status === 'active' && styles.statusButtonTextActive,
                  ]}
                >
                  Active
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                style={[
                  styles.statusButton,
                  formData.status === 'inactive' && styles.statusButtonActive,
                ]}
                onPress={() => handleChange('status', 'inactive')}
              >
                <Text
                  style={[
                    styles.statusButtonText,
                    formData.status === 'inactive' && styles.statusButtonTextActive,
                  ]}
                >
                  Inactive
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
              {loading ? 'Saving...' : isEditing ? 'Update Device' : 'Create Device'}
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
  statusContainer: {
    flexDirection: 'row',
    gap: 12,
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
    fontSize: 16,
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

export default DeviceFormScreen;
