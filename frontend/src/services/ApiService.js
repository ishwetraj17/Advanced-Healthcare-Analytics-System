import axios from 'axios';

const API_URL = "http://localhost:8080/api";

export const getPatientReport = async (patientId) => {
  const response = await axios.get(`${API_URL}/reports/patient/${patientId}`);
  return response.data;
};

export const getStepTrend = async (patientId) => {
  const response = await axios.get(`${API_URL}/visualization/steps-trend/${patientId}`);
  return response.data;
};
