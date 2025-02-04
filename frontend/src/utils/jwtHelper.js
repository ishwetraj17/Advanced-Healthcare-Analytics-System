import jwt_decode from 'jwt-decode';

// Decode JWT token
export const decodeJWT = (token) => {
  try {
    return jwt_decode(token);
  } catch (error) {
    console.error('Error decoding JWT', error);
  }
};

// Check if JWT is expired
export const isTokenExpired = (token) => {
  const decoded = decodeJWT(token);
  if (decoded) {
    return decoded.exp * 1000 < Date.now();
  }
  return true;
};
