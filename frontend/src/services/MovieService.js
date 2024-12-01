import apiClient from '../api/api.js';

export default {
  getAllMovies() {
    return apiClient.get('/movies'); // Fetch all movies
  },

  getMovieById(id) {
    return apiClient.get(`/movies/${id}`); // Fetch details of a specific movie
  },
};
