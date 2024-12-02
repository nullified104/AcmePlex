<template>
  <div class="container mt-4">
    <div class="row">
      <!-- Movie Poster Section -->
      <div class="col-md-4">
        <img src="@/assets/movie.jpg" class="img-fluid" alt="Movie Poster" />
      </div>

      <!-- Movie Details and Showtimes Section -->
      <div class="col-md-8">
        <h3 v-if="movie">{{ movie.title }}</h3>
        <p v-else>Loading movie details...</p>
        <p v-if="movie"><strong>Genre:</strong> {{ movie.genre }}</p>
        <p v-if="movie"><strong>Duration:</strong> {{ movie.duration }} minutes</p>
        <p v-if="movie"><strong>Description:</strong> {{ movie.description }}</p>

        <!-- theater Selection Dropdown -->
        <div class="form-group" v-if="movie">
          <label for="theaterSelect">Select theater</label>
          <select id="theaterSelect" v-model="selectedtheater" class="form-control">
            <option v-for="(theater, index) in theaters" :key="index" :value="theater.id">
              {{ theater.name }}
            </option>
          </select>
        </div>

        <!-- Showtimes Table for selected theater -->
        <div class="showtimes mt-4" v-if="filteredShowtimes.length > 0">
          <h5>Showtimes for {{ selectedtheaterName }}</h5>
          <Showtimes :showtimes="filteredShowtimes" @open-seating-map="openSeatingMap" />
        </div>

        <!-- No showtimes available message -->
        <div v-else-if="movie">
          <p>No showtimes available for the selected theater.</p>
        </div>
      </div>
    </div>

    <!-- Seating Plan Modal -->
    <SeatingPlanModal
      :isVisible="isSeatingModalVisible"
      :seats="seats"
      :movie="this.movie"
      :showtime="this.selectedShowtime"
      @close="closeSeatingModal"
      @proceed="proceedToPayment"
    />
  </div>
</template>

<script>
import Showtimes from './ShowTimes.vue';
import SeatingPlanModal from './SeatingPlanModal.vue';
import MovieService from '@/services/MovieService';
import TheaterService from '@/services/TheaterService';
import SeatService from '@/services/SeatService';

export default {
  components: {
    Showtimes,
    SeatingPlanModal,
  },
  props: ['id'],
  data() {
    return {
      movie: null, // Movie details object
      // List of available theaters
      theaters: [
      ],
      selectedtheater: 1, // Default selected theater ID
      filteredShowtimes: [], // Store filtered showtimes based on selected theater
      seats: [
      ],
      isSeatingModalVisible: false,
      selectedShowtime: null,
    };
  },
  computed: {
    selectedtheaterName() {
      const selectedtheater = this.theaters.find((theater) => theater.id === this.selectedtheater);
      return selectedtheater ? selectedtheater.name : '';
    },
  },
  watch: {
    selectedtheater(newTheaterId) {
      this.fetchFilteredShowtimes(newTheaterId);
    },
    id: 'fetchMovieDetails', // Fetch movie details when movie ID changes
  },
  methods: {
    async fetchSeats(showtimeId) {
      await SeatService.getSeatsByShowtime(showtimeId)
        .then((response) => {
          this.seats = response.data;
        })
        .catch((error) => {
          console.error('Error fetching seats:', error);
        });
    },
    async fetchTheaters() {
      await TheaterService.getTheaters()
        .then((response) => {
          this.theaters = response.data;
          // Fetch the filtered showtimes for the currently selected theater
          this.fetchFilteredShowtimes(this.selectedtheater);
        })
        .catch((error) => {
          console.error('Error fetching theaters', error);
        });
    },
    fetchFilteredShowtimes(theaterId) {
      const selectedTheater = this.theaters.find((theater) => theater.id === theaterId);
      if (selectedTheater) {
        // Filter the showtimes for the selected movie ID
        this.filteredShowtimes = selectedTheater.showtimes.filter(showtime => showtime.movie.id == this.id);
        // Format the showtimes' time in 12-hour format
        this.filteredShowtimes = this.filteredShowtimes.map(showtime => {
          const date = new Date(showtime.time);
          const hours = date.getHours();
          const minutes = date.getMinutes();
          showtime.time = `${hours % 12 || 12}:${minutes < 10 ? '0' + minutes : minutes} ${hours >= 12 ? 'PM' : 'AM'}`;
          return showtime;
        });
      }
    },
    async fetchMovieDetails() {
      await MovieService.getMovieById(this.id)
        .then((response) => {
          this.movie = response.data;
        })
        .catch((error) => {
          console.error('Error fetching movie', error);
        });
    },
    openSeatingMap(showtime) {
      this.selectedShowtime = showtime;
      this.isSeatingModalVisible = true;
      this.fetchSeats(showtime.id);
    },
    closeSeatingModal() {
      this.isSeatingModalVisible = false;
    },
    proceedToPayment(selectedSeats) {
      this.$router.push({
        name: 'PaymentPage',
        query: {
          showtimeId: this.selectedShowtime.id,
          seats: JSON.stringify(selectedSeats),
        },
      });
    },
  },
  created() {
    // Fetch movie details when the component is created
    this.fetchMovieDetails();
    this.fetchTheaters();
  },
};
</script>

<style scoped>
.showtimes button {
  font-size: 16px;
}
</style>
