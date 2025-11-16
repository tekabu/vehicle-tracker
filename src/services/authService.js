import api from './api';

class AuthService {
  async register(userData) {
    const response = await api.post('/register', userData);
    if (response.access_token) {
      await api.setToken(response.access_token);
    }
    // Save user data if available
    if (response.user) {
      await api.setUserData(response.user);
    }
    return response;
  }

  async login(credentials) {
    console.log('[authService] Attempting to log in...');
    try {
      const response = await api.post('/login', credentials);
      console.log('[authService] Login API Response:', JSON.stringify(response, null, 2));

      if (response.access_token) {
        await api.setToken(response.access_token);
        console.log('[authService] Login successful, token has been set.');
      } else {
        console.warn('[authService] Login response received, but no token was found.');
      }

      // Save user data if available
      if (response.user) {
        await api.setUserData(response.user);
        console.log('[authService] User data has been saved.');
      }

      return response;
    } catch (error) {
      console.error('[authService] Login failed with an error:', JSON.stringify(error, null, 2));
      throw error; // Re-throw the error so the UI can handle it
    }
  }

  async logout() {
    try {
      await api.post('/logout');
    } finally {
      await api.clearToken();
      await api.clearUserData();
    }
  }

  async changePassword(passwordData) {
    return api.post('/password/change', passwordData);
  }

  async generateOTP(email) {
    return api.post('/otp', { email });
  }

  async validateOTP(email, otp) {
    return api.post('/otp/validate', { email, otp });
  }

  async resetPassword(resetData) {
    return api.post('/password/reset', resetData);
  }

  async getUserData() {
    return api.getUserData();
  }

  async setUserData(userData) {
    return api.setUserData(userData);
  }

  async updateProfile(profileData) {
    return api.put('/profile', profileData);
  }
}

export default new AuthService();
