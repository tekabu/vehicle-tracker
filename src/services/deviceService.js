import api from './api';

class DeviceService {
  async getAll() {
    console.log('[DeviceService] Calling GET /devices');
    const response = await api.get('/devices');
    console.log('[DeviceService] Raw response:', JSON.stringify(response, null, 2));
    console.log('[DeviceService] response.data:', JSON.stringify(response.devices, null, 2));
    // Handle both { data: [...] } and direct array responses
    const result = response.devices || response || [];
    console.log('[DeviceService] Returning:', JSON.stringify(result, null, 2));
    return result;
  }

  async getById(id) {
    const response = await api.get(`/devices/${id}`);
    return response.device || response;
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
