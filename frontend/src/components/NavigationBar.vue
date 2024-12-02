<template>
  <nav class="navbar navbar-expand-lg bg-dark">
    <div class="container-fluid">
      <router-link to="/" class="navbar-brand text-decoration-none">
        <span style="color: #F0F0F0; font-weight: bold;">ACME</span>
        <span style="color: #00AFFF; font-style: italic;">PLEX</span>
      </router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-2 mb-2 mb-lg-0" style="color:beige">
          <!-- Movies link is always shown -->
          <li class="nav-item">
            <router-link to="/" class="nav-link active" exact>Movies</router-link>
          </li>

          <!-- Render Account link if user is logged in -->
          <li class="nav-item" v-if="isLoggedIn">
            <router-link to="/account" class="nav-link active">Account</router-link>
          </li>
          
          <!-- Logout button -->
          <li class="nav-item" v-if="isLoggedIn">
            <button class="nav-link active btn btn-link" @click="logout">Logout</button>
          </li>
          <!-- Login Button-->
          <li class="nav-item" v-else>
            <router-link to="/login" class="nav-link active btn btn-link">Login</router-link>
          </li>
        </ul>

        <!-- Search Form -->
        <form @submit.prevent="searchMovies" class="d-flex ms-auto" role="search">
          <input
            v-model="searchQuery"
            class="form-control me-2"
            type="search"
            placeholder="Search for a movie"
            aria-label="Search"
          />
          <button class="btn btn-outline-light" type="submit">Search</button>
        </form>
      </div>
    </div>

    <!-- Search Results (if any) -->
    <div v-if="searchResults.length > 0" class="search-results">
      <ul class="list-group">
        <li
          v-for="movie in searchResults"
          :key="movie.id"
          class="list-group-item"
          @click="goToMovieDetails(movie.id)"
        >
          {{ movie.title }}
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import MovieService from '@/services/MovieService';
export default {
  name: "NavigationBar",
  data() {
    return {
      isLoggedIn: false, // Default state
      searchQuery: '',   // The query text entered by the user
      searchResults: [], // The search results to display
    };
  },
  created() {
    const user = JSON.parse(localStorage.getItem('user')); // Check if user is logged in
    if (user && user.guest !== true) {
      this.isLoggedIn = true; // User is logged in
    }
  },
  methods: {
    logout() {
      localStorage.removeItem('user'); // Remove user from localStorage
      this.isLoggedIn = false; // Update the login state
      this.$router.push({ name: 'LoginPage' }); // Redirect to login page
    },

    async searchMovies() {
      if (this.searchQuery.trim() === '') {
        this.searchResults = []; // Clear results if the search query is empty
        return;
      }
      try {
        // Make an API call to the backend to search for movies
        const response = await MovieService.getMovieBySearch(this.searchQuery)
        .then((response) => {
          this.movie = response.data;
        })
        .catch((error) => {
          console.error('Error fetching movie', error);
        });

        // Set the search results
        this.searchResults = response.data;
      } catch (error) {
        console.error("Error searching movies:", error);
        this.searchResults = [];
      }
    },

    goToMovieDetails(movieId) {
      // Navigate to the movie details page when a movie is clicked
      this.$router.push({ name: 'MovieDetails', params: { id: movieId } });
    },
  },
};
</script>

<style>
.navbar-nav .nav-item .nav-link.active {
  color: #f0f0f0;
}

.search-results {
  position: absolute;
  top: 60px;
  right: 0;
  background: #fff;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
  width: 250px;
  max-height: 300px;
  overflow-y: auto;
  z-index: 1000;
}

.search-results .list-group-item {
  cursor: pointer;
}

.search-results .list-group-item:hover {
  background-color: #f0f0f0;
}
</style>
