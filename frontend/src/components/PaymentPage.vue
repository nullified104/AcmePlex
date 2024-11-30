<template>
    <div class="payment-container">
      <h2>Payment</h2>
      <div class="payment-info">
        <h3>Movie: {{ selectedMovie.title }}</h3>
        <h4>Showtime: {{ selectedShowtime.time }}</h4>
        <p><strong>Seat:</strong> {{ selectedSeat.label }}</p>
      </div>
      
      <div v-if="isGuest">
        <h3>Guest Checkout</h3>
        <form @submit.prevent="processPayment">
          <div class="form-group">
            <label for="cardNumber">Card Number</label>
            <input type="text" id="cardNumber" class="form-control" v-model="paymentData.cardNumber" required />
          </div>
          <button type="submit" class="btn btn-primary w-100">Pay</button>
        </form>
      </div>
  
      <div v-else>
        <h3>Registered User Checkout</h3>
        <p>You will be charged ${{ ticketPrice }}</p>
        <p>Your credit/debit card: {{ user.card }}</p>
        <button @click="processPayment" class="btn btn-primary w-100">Pay Now</button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        selectedMovie: { title: 'Sample Movie' },
        selectedShowtime: { time: '7:00 PM' },
        selectedSeat: { label: 'A1' },
        isGuest: false,
        ticketPrice: 15,
        user: {
          card: '**** **** **** 1234',
        },
        paymentData: {
          cardNumber: '',
        },
      };
    },
    methods: {
      processPayment() {
        console.log('Processing Payment');
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
  