import apiClient from '../api/api.js';

export default {
  purchaseTicket(ticket) {
    return apiClient.post('/tickets', ticket); // Purchase a ticket
  },

  cancelTicket(ticketId) {
    return apiClient.put(`/tickets/${ticketId}/cancel`); // Cancel a ticket within the allowed time
  },

  getUserTickets(userId) {
    return apiClient.get(`/tickets?userId=${userId}`); // Fetch all tickets for a user
  },
};
