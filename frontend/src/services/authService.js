import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth';

export const loginUser = async (email, password) => {
  try {
    const response = await axios.post(`${API_URL}/login`, { email, password });
    return response.data;
  } catch (error) {
    console.error('Login failed', error);
  }
};
