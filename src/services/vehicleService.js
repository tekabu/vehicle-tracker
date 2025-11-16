import api from './api';

class VehicleService {
  async getAll() {
    const response = await api.get('/vehicles');
    // Handle both { vehicles: [...] } and direct array responses
    return response.vehicles || response.data || [];
  }

  async getById(id) {
    const response = await api.get(`/vehicles/${id}`);
    return response.vehicle || response.data;
  }

  async create(vehicleData) {
    return api.post('/vehicles', vehicleData);
  }

  async update(id, vehicleData) {
    return api.put(`/vehicles/${id}`, vehicleData);
  }

  async delete(id) {
    return api.delete(`/vehicles/${id}`);
  }
}

export default new VehicleService();
