// Base API configuration
// API_BASE_URL is loaded from app.json extra field for production builds
// or from environment variables (.env file) for development
import Constants from 'expo-constants';

const API_BASE_URL = Constants.expoConfig?.extra?.apiBaseUrl ||
                     process.env.EXPO_PUBLIC_API_BASE_URL ||
                     'http://localhost:8031/api';

// Use AsyncStorage for React Native persistent storage
import storage from '@react-native-async-storage/async-storage';
import { logError, logMessage } from '../utils/crashlytics';

class ApiService {
  constructor() {
    this.baseUrl = API_BASE_URL;
    this.token = null;
    this.tokenInitialized = false;
    this.tokenPromise = this.initializeToken();
  }

  async initializeToken() {
    const token = await storage.getItem('authToken');
    if (token) {
      this.token = token;
    }
    this.tokenInitialized = true;
    return token;
  }

  async setToken(token) {
    console.log('[apiService] setToken called. Saving token to state and storage.');
    this.token = token;
    this.tokenInitialized = true;
    await storage.setItem('authToken', token);
    console.log('[apiService] Token successfully saved to AsyncStorage.');
  }

  getToken() {
    return this.token;
  }

  async clearToken() {
    this.token = null;
    this.tokenInitialized = true;
    await storage.removeItem('authToken');
  }

  async setUserData(userData) {
    await storage.setItem('userData', JSON.stringify(userData));
  }

  async getUserData() {
    const userData = await storage.getItem('userData');
    return userData ? JSON.parse(userData) : null;
  }

  async clearUserData() {
    await storage.removeItem('userData');
  }

  async request(endpoint, options = {}) {
    // Wait for token initialization if not yet initialized
    if (!this.tokenInitialized) {
      await this.tokenPromise;
    }

    const url = `${this.baseUrl}${endpoint}`;
    const headers = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      ...options.headers,
    };

    if (this.token) {
      headers['Authorization'] = `Bearer ${this.token}`;
    }

    const config = {
      ...options,
      headers,
    };

    if (options.body && typeof options.body === 'object') {
      config.body = JSON.stringify(options.body);
    }

    try {
      const response = await fetch(url, config);
      const data = await response.json();

      if (!response.ok) {
        // Log API errors to Crashlytics
        const apiError = {
          status: response.status,
          message: data.message || 'An error occurred',
          errors: data.errors || {},
        };

        // Create detailed error context
        const errorContext = `API Error: ${options.method || 'GET'} ${endpoint} - Status: ${response.status}`;
        logError(new Error(apiError.message), errorContext);
        logMessage(`API Request failed: ${errorContext}`);

        throw apiError;
      }

      return data;
    } catch (error) {
      // If error already has a status, it's from our response handler above
      if (error.status) {
        throw error;
      }
      // Network errors
      console.error('[API] Network error:', error);

      // Log network errors to Crashlytics
      const networkErrorContext = `Network Error: ${options.method || 'GET'} ${endpoint}`;
      logError(error, networkErrorContext);
      logMessage(`Network request failed: ${networkErrorContext}`);

      throw {
        status: 0,
        message: 'Network error. Please check your connection.',
        errors: {},
      };
    }
  }

  async get(endpoint) {
    return this.request(endpoint, { method: 'GET' });
  }

  async post(endpoint, data) {
    return this.request(endpoint, {
      method: 'POST',
      body: data,
    });
  }

  async put(endpoint, data) {
    return this.request(endpoint, {
      method: 'PUT',
      body: data,
    });
  }

  async delete(endpoint) {
    return this.request(endpoint, { method: 'DELETE' });
  }
}

export default new ApiService();
