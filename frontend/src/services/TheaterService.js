import apiClient from '../api/api.js';

export default {
  getTheaters() {
    return apiClient.get(`/theaters`); // Fetch showtimes for a specific movie
  },

  getTheatersById(theaterId) {
    return apiClient.get(`/theaters/${theaterId}}`); // Fetch showtime details
  },
};
