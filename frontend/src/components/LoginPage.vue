<template>
  <div class="login-register-container">
    <div class="login-register-box">
      <h2 class="text-center">Welcome to AcmePlex</h2>

      <!-- Toggle between Login and Register -->
      <div class="toggle-buttons text-center">
        <button 
          @click="toggleForm('login')" 
          :class="{'active': currentForm === 'login'}"
          class="btn btn-outline-primary">
          Login
        </button>
        <button 
          @click="toggleForm('register')" 
          :class="{'active': currentForm === 'register'}"
          class="btn btn-outline-primary">
          Register
        </button>
      </div>

      <!-- Login Section -->
      <div v-if="currentForm === 'login'" class="login-section">
        <h3>Login</h3>
        <form @submit.prevent="onLogin">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="" id="username" class="form-control" v-model="loginData.username" required />
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" v-model="loginData.password" required />
          </div>
          <button type="submit" class="btn btn-primary w-100">Login</button>
        </form>
        <p><a href="#">Forgot Password?</a></p>

        <div class="guest-section text-center">
          <button @click="continueAsGuest" class="btn btn-secondary w-100">Continue as Guest</button>
        </div>
      </div>

      <!-- Register Section -->
      <div v-if="currentForm === 'register'" class="register-section">
        <h3>Register</h3>
        <form @submit.prevent="onRegister">
          <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" class="form-control" v-model="registerData.name" required />
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" class="form-control" v-model="registerData.email" required />
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" v-model="registerData.password" required />
          </div>
          <div class="form-group">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" id="confirmPassword" class="form-control" v-model="registerData.confirmPassword" required />
          </div>
          <div class="form-group">
            <label for="address">Address</label>
            <input type="text" id="address" class="form-control" v-model="registerData.address" />
          </div>
          <div class="form-group">
            <label for="card">Credit/Debit Card</label>
            <input type="text" id="card" class="form-control" v-model="registerData.card" />
          </div>
          <button type="submit" class="btn btn-success w-100">Register</button>
        </form>
      </div>

    </div>
  </div>
</template>

<script>
import userService from '@/services/UserService';

export default {
  data() {
    return {
      currentForm: 'login',
      loginData: {
        username: '',
        password: '',
      },
      registerData: {
        name: '',
        email: '',
        password: '',
        confirmPassword: '',
        address: '',
        card: '',
      },
    };
  },
  methods: {
    // Toggle between Login and Register
    toggleForm(formType) {
      this.currentForm = formType;
    },
    
    async onLogin() {
      try {
        const userObject = { 
          username: this.loginData.username, 
          password: this.loginData.password 
        };

        // Log in the user
        const response = await userService.loginUser(userObject);
        
        // Store the user data in localStorage
        localStorage.setItem('user', JSON.stringify(response.data));

        // Redirect to the home page after login
        this.$router.push({ name: 'HomePage' });
      } catch (error) {
        console.error('Login failed:', error.response?.data || error.message);
        alert('Login failed. Please check your credentials and try again.');
      }
    },

    // Handle register
    async onRegister() {
      try {
        // Ensure passwords match
        if (this.registerData.password !== this.registerData.confirmPassword) {
          alert("Passwords do not match!");
          return;
        }

        // Register the new user
        const response = await userService.registerUser(this.registerData);

        // Store the user data in localStorage
        localStorage.setItem('user', JSON.stringify(response.data));

        // Switch to the login form after registration
        this.toggleForm('login');
      } catch (error) {
        console.error('Registration failed:', error.response?.data || error.message);
        alert('Registration failed. Please try again.');
      }
    },
    
    continueAsGuest() {
      // Set the user state as guest
      localStorage.setItem('user', JSON.stringify({ guest: true }));
      this.isLoggedIn = false;
      this.$router.push('/'); // Redirect to home or movie page
    }
  },
  created() {
  },
};
</script>
  
  <style scoped>
  .login-register-container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
  }
  
  .login-register-box {
    background-color: #f8f9fa;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
  }
  
  h2 {
    font-size: 24px;
    font-weight: bold;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  button {
    font-size: 16px;
  }
  
  .toggle-buttons {
    margin-bottom: 30px;
  }
  
  .toggle-buttons button {
    margin-right: 10px;
    padding: 10px 20px;
  }
  
  .toggle-buttons button.active {
    background-color: #007bff;
    color: white;
  }
  
  .guest-section {
    margin-top: 20px;
  }
  
  a {
    color: #007bff;
    text-decoration: none;
  }
  </style>
  