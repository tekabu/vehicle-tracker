import api from './api';

class DeviceService {
  async getAll() {
    const response = await api.get('/devices');
    return response.data;
  }

  async getById(id) {
    const response = await api.get(`/devices/${id}`);
    return response.data;
  }

  async create(deviceData) {
    return api.post('/devices', deviceData);
  }

  async update(id, deviceData) {
    return api.put(`/devices/${id}`, deviceData);
  }

  async delete(id) {
    return api.delete(`/devices/${id}`);
  }
}

export default new DeviceService();
