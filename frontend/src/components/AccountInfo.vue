<template>
  <div class="account-container">
    <h2>Account Overview</h2>

    <div v-if="user" class="personal-info">
      <h3>Personal Information</h3>
      <p><strong>Name:</strong> {{ user.name }}</p>
      <p><strong>Email:</strong> {{ user.email }}</p>
      <p><strong>Address:</strong> {{ user.address }}</p>
      <p><strong>Credit/Debit Card:</strong> {{ user.card }}</p>
    </div>
    <p v-else>Loading user information...</p>
  </div>
</template>

<script>
import UserService from '../services/UserService';

export default {
  data() {
    return {
      user: null, // User data object
    };
  },
  methods: {
    fetchUserDetails() {
      const userId = JSON.parse(localStorage.getItem('user')).id; 
      UserService.getUserDetails(userId)
        .then((response) => {
          this.user = response.data;
        })
        .catch((error) => {
          console.error('Error fetching user details:', error);
        });
    },
  },
  created() {
    this.fetchUserDetails();
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

.personal-info,
.subscription-status,
.transaction-history {
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