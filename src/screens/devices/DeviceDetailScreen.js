import React, { useState, useEffect } from 'react';
import { View, Text, ScrollView, StyleSheet, TouchableOpacity, ActivityIndicator, Alert } from 'react-native';
import { StatusBar } from 'expo-status-bar';
import { useFocusEffect } from '@react-navigation/native';
import Header from '../../components/Header';
import Card, { CardHeader, CardRow, CardSection } from '../../components/Card';
import deviceService from '../../services/deviceService';

const DeviceDetailScreen = ({ navigation, route }) => {
  const { deviceId } = route.params;
  const [device, setDevice] = useState(null);
  const [loading, setLoading] = useState(true);

  // Reload device when screen comes into focus
  useFocusEffect(
    React.useCallback(() => {
      loadDevice();
    }, [deviceId])
  );

  useEffect(() => {
    loadDevice();
  }, [deviceId]);

  const loadDevice = async () => {
    try {
      setLoading(true);
      const data = await deviceService.getById(deviceId);
      setDevice(data);
    } catch (error) {
      Alert.alert('Error', error.message || 'Failed to load device details');
      navigation.goBack();
    } finally {
      setLoading(false);
    }
  };

  const handleEdit = () => {
    navigation.navigate('DeviceForm', { device });
  };

  const handleDelete = () => {
    Alert.alert(
      'Delete Device',
      `Are you sure you want to delete device ${device.device}?`,
      [
        { text: 'Cancel', style: 'cancel' },
        {
          text: 'Delete',
          style: 'destructive',
          onPress: async () => {
            try {
              await deviceService.delete(deviceId);
              Alert.alert('Success', 'Device deleted successfully');
              navigation.goBack();
            } catch (error) {
              Alert.alert('Error', error.message || 'Failed to delete device');
            }
          },
        },
      ]
    );
  };

  if (loading) {
    return (
      <View style={styles.container}>
        <StatusBar style="dark" />
        <Header title="Device Details" navigation={navigation} />
        <View style={styles.loadingContainer}>
          <ActivityIndicator size="large" color="#007AFF" />
        </View>
      </View>
    );
  }

  if (!device) {
    return null;
  }

  return (
    <View style={styles.container}>
      <StatusBar style="dark" />
      <Header
        title="Device Details"
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
            title={device.device || 'Unknown Device'}
            subtitle={`ID: ${device.id}`}
          />

          <CardSection>
            <CardRow label="Device Identifier" value={device.device} />
            <CardRow
              label="Created"
              value={new Date(device.created_at).toLocaleDateString()}
            />
            <CardRow
              label="Last Updated"
              value={new Date(device.updated_at).toLocaleDateString()}
            />
          </CardSection>
        </Card>

        <TouchableOpacity
          onPress={handleDelete}
          style={styles.deleteButton}
        >
          <Text style={styles.deleteButtonText}>Delete Device</Text>
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

export default DeviceDetailScreen;
