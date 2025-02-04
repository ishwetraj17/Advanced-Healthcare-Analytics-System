import axios from 'axios';

// API base URL, change as needed for production
const API_URL = 'http://localhost:8080/api';

export const apiCall = async (endpoint, method = 'GET', data = null, token = null) => {
  try {
    const headers = token ? { Authorization: `Bearer ${token}` } : {};
    const response = await axios({
      url: `${API_URL}/${endpoint}`,
      method,
      headers,
      data,
    });
    return response.data;
  } catch (error) {
    console.error('API call error:', error);
    throw error;
  }
};
