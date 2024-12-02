<template>
  <div class="payment-container">
    <h2>Payment</h2>

    <!-- Check if the user is logged in -->
    <div v-if="!this.user">
      <h3>You must log in to proceed with the checkout.</h3>
      <button @click="redirectToLogin" class="btn btn-primary w-100">Go to Login</button>
    </div>
    <div v-else>
      <!-- If user is logged in, show payment info -->
      <div class="payment-info">
        <h3>Movie: {{ selectedMovie.title }}</h3>
        <h4>Showtime: {{ selectedShowtime.time }}</h4>
        <p><strong>Seats:</strong> {{ selectedSeats.map(seat => seat.id).join(", ") }}</p>
      </div>

      <div>
        <h3>User Checkout</h3>
        <p>You will be charged $10</p>
        <p>Your credit/debit card: {{ user.creditCard }}</p>
        <button @click="processPayment" class="btn btn-primary w-100">Pay Now</button>
      </div>
    </div>
  </div>
</template>

<script>
import TicketService from '@/services/TicketService';
import SeatService from '@/services/SeatService';

export default {
  data() {
    return {
      user: null,
      selectedMovie: {},
      selectedShowtime: {},
      selectedSeats: [],
      paymentData: {
        cardNumber: '',
      },
    };
  },
  created() {
    this.user = JSON.parse(localStorage.getItem('user'));
    console.log(this.user);
    const movie = JSON.parse(this.$route.query.movie);
    const showtime = JSON.parse(this.$route.query.showtime);
    const seats = JSON.parse(this.$route.query.seats);

    this.selectedMovie = movie;
    this.selectedShowtime = showtime;
    this.selectedSeats = seats;
  },
  methods: {
    redirectToLogin() {
      // Redirect the user to the login page if not logged in
      this.$router.push({ name: 'LoginPage' });
    },
    async processPayment() {
      try {
        // Loop through each selected seat and create a ticket
        for (const seat of this.selectedSeats) {
          const ticket = {
            showtime_id: this.selectedShowtime.id, // Showtime ID
            user_id: this.user.id, // User ID from localStorage
            seat_id: seat.id, // Seat ID (from the seat object)
            is_cancelled: 0, // The ticket is not canceled when purchasing
            purchase_date: new Date().toISOString(), // Current date and time as the purchase date
          };

          // Call the ticket service to purchase the ticket for each seat
          await TicketService.purchaseTicket(ticket);

          // Mark the seat as reserved
          await SeatService.reserveSeat(seat.id); 
        }

        alert('Tickets successfully purchased!');
        this.$router.push('/'); // Redirect to confirmation page
      } catch (error) {
        console.error("Error processing payment:", error);
      }
    },
  },
};
</script>

<style scoped>
.payment-container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}

h2 {
  font-size: 26px;
  text-align: center;
}

.payment-info {
  background-color: #f8f9fa;
  padding: 20px;
  margin-bottom: 20px;
  border-radius: 8px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}

button {
  font-size: 16px;
  margin-top: 20px;
}

.form-group {
  margin-bottom: 20px;
}

.w-100 {
  width: 100%;
}
</style>
