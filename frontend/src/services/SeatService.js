import apiClient from '../api/api.js';

export default {
  getSeatsByShowtime(showtimeId) {
    return apiClient.get(`/seats/showtime/${showtimeId}`); // Fetch seats for a specific showtime
  },

  reserveSeat(seatId) {
    return apiClient.put(`/seats/${seatId}`, { is_available: 0 }); // Reserve or unreserve a seat
  },
};
