import api from './api';

class VehicleService {
  async getAll() {
    const response = await api.get('/vehicles');
    return response.data;
  }

  async getById(id) {
    const response = await api.get(`/vehicles/${id}`);
    return response.data;
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
