// Base API configuration
// TODO: Update this URL to your actual backend server URL
// const API_BASE_URL = 'http://localhost:8031/api';
const API_BASE_URL = 'http://192.168.8.183:8031/api';

// Simple storage helper for web and mobile
const storage = {
  async setItem(key, value) {
    if (typeof window !== 'undefined' && window.localStorage) {
      window.localStorage.setItem(key, value);
    }
  },
  async getItem(key) {
    if (typeof window !== 'undefined' && window.localStorage) {
      return window.localStorage.getItem(key);
    }
    return null;
  },
  async removeItem(key) {
    if (typeof window !== 'undefined' && window.localStorage) {
      window.localStorage.removeItem(key);
    }
  },
};

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
    this.token = token;
    this.tokenInitialized = true;
    await storage.setItem('authToken', token);
  }

  getToken() {
    return this.token;
  }

  async clearToken() {
    this.token = null;
    this.tokenInitialized = true;
    await storage.removeItem('authToken');
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
        throw {
          status: response.status,
          message: data.message || 'An error occurred',
          errors: data.errors || {},
        };
      }

      return data;
    } catch (error) {
      if (error.status) {
        throw error;
      }
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
