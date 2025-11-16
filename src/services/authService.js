import api from './api';

class AuthService {
  async register(userData) {
    const response = await api.post('/register', userData);
    if (response.token) {
      await api.setToken(response.token);
    }
    return response;
  }

  async login(credentials) {
    const response = await api.post('/login', credentials);
    if (response.token) {
      await api.setToken(response.token);
    }
    return response;
  }

  async logout() {
    try {
      await api.post('/logout');
    } finally {
      await api.clearToken();
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
}

export default new AuthService();
