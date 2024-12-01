import apiClient from '../api/api.js';

export default {
  getSeatsByShowtime(showtimeId) {
    return apiClient.get(`/seats/showtime/${showtimeId}`); // Fetch seats for a specific showtime
  },

  reserveSeat(seatId, isReservedByRU) {
    return apiClient.put(`/seats/${seatId}`, { reservedByRU: isReservedByRU }); // Reserve or unreserve a seat
  },
};
