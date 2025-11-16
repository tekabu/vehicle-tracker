import api from './api';

class CustomerService {
  async getAll() {
    const response = await api.get('/customers');
    return response.data;
  }

  async getById(id) {
    const response = await api.get(`/customers/${id}`);
    return response.data;
  }

  async create(customerData) {
    return api.post('/customers', customerData);
  }

  async update(id, customerData) {
    return api.put(`/customers/${id}`, customerData);
  }

  async delete(id) {
    return api.delete(`/customers/${id}`);
  }
}

export default new CustomerService();
