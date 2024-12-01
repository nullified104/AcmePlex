import apiClient from '../api/api.js';

export default {
  getShowtimesByMovie(movieId) {
    return apiClient.get(`/showtimes?movieId=${movieId}`); // Fetch showtimes for a specific movie
  },

  getShowtimeDetails(showtimeId) {
    return apiClient.get(`/showtimes/${showtimeId}`); // Fetch showtime details
  },
};
