<template>
    <div class="account-container">
      <h2>Account Overview</h2>
  
      <div class="personal-info">
        <h3>Personal Information</h3>
        <p><strong>Name:</strong> {{ user.name }}</p>
        <p><strong>Email:</strong> {{ user.email }}</p>
        <p><strong>Address:</strong> {{ user.address }}</p>
        <p><strong>Credit/Debit Card:</strong> {{ user.card }}</p>
        <button @click="editPersonalInfo" class="btn btn-warning">Edit Info</button>
      </div>
  
      <div class="subscription-status">
        <h3>Subscription Status</h3>
        <p><strong>Status:</strong> {{ user.subscriptionStatus }}</p>
        <p><strong>Next Payment Due:</strong> {{ user.subscriptionRenewalDate }}</p>
        <button @click="renewSubscription" class="btn btn-primary">Renew Subscription</button>
      </div>
  
      <div class="transaction-history">
        <h3>Transaction History</h3>
        <ul>
          <li v-for="transaction in user.transactions" :key="transaction.id">
            {{ transaction.date }} - {{ transaction.amount }} - {{ transaction.type }}
          </li>
        </ul>
      </div>
  
      <button @click="cancelSubscription" class="btn btn-danger">Cancel Subscription</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        user: {
          name: 'John Doe',
          email: 'johndoe@example.com',
          address: '123 Main St, City, Country',
          card: '**** **** **** 1234',
          subscriptionStatus: 'Active',
          subscriptionRenewalDate: '2025-12-01',
          transactions: [
            { id: 1, date: '2024-11-01', amount: '$25.00', type: 'Ticket Purchase' },
            { id: 2, date: '2024-09-10', amount: '$20.00', type: 'Annual Subscription' },
          ],
        },
      };
    },
    methods: {
      editPersonalInfo() {
        console.log('Edit Personal Info');
      },
      renewSubscription() {
        console.log('Renew Subscription');
      },
      cancelSubscription() {
        console.log('Cancel Subscription');
      },
    },
  };
  </script>
  
  <style scoped>
  .account-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }
  
  h2 {
    font-size: 26px;
    margin-bottom: 30px;
  }
  
  .personal-info, .subscription-status, .transaction-history {
    background-color: #f8f9fa;
    padding: 20px;
    margin-bottom: 20px;
    border-radius: 8px;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
  }
  
  button {
    font-size: 16px;
    margin-top: 10px;
  }
  
  .transaction-history ul {
    list-style-type: none;
    padding-left: 0;
  }
  </style>
  