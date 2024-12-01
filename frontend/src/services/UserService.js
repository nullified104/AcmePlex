import apiClient from '../api/api.js';

export default {
  loginUser(credentials) {
    return apiClient.post('/users/login', credentials); // Log in user
  },

  registerUser(user) {
    return apiClient.post('/users', user); // Register a new user
  },

  getUserDetails(userId) {
    return apiClient.get(`/users/${userId}`); // Fetch details of the logged-in user
  },

  updateUserDetails(userId, updatedUser) {
    return apiClient.put(`/users/${userId}`, updatedUser); // Update user details
  },
};
