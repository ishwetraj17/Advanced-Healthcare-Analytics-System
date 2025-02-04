import axios from 'axios';

const API_URL = 'http://localhost:8080/api/patients';

export const getPatientReport = async (id) => {
  try {
    const response = await axios.get(`${API_URL}/report/${id}`);
    return response.data;
  } catch (error) {
    console.error('Error fetching patient report', error);
  }
};
