import api from './api';

class RentalService {
  async getAll() {
    const response = await api.get('/rentals');
    // Handle both { rentals: [...] } and direct array responses
    return response.rentals || response.data || [];
  }

  async getById(id) {
    const response = await api.get(`/rentals/${id}`);
    return response.rental || response.data;
  }

  async create(rentalData) {
    return api.post('/rentals', rentalData);
  }

  async update(id, rentalData) {
    return api.put(`/rentals/${id}`, rentalData);
  }

  async delete(id) {
    return api.delete(`/rentals/${id}`);
  }

  async start(id, startData) {
    return api.post(`/rentals/${id}/start`, startData);
  }

  async end(id, endData) {
    return api.post(`/rentals/${id}/end`, endData);
  }
}

export default new RentalService();
