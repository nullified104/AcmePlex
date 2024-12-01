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

        <!-- Theatre Selection Dropdown -->
        <div class="form-group" v-if="movie">
          <label for="theatreSelect">Select Theatre</label>
          <select id="theatreSelect" v-model="selectedTheatre" class="form-control">
            <option v-for="(theatre, index) in theatres" :key="index" :value="theatre.id">
              {{ theatre.name }}
            </option>
          </select>
        </div>

        <!-- Showtimes Table for selected theatre -->
        <div class="showtimes mt-4" v-if="filteredShowtimes.length > 0">
          <h5>Showtimes for {{ selectedTheatreName }}</h5>
          <Showtimes :showtimes="filteredShowtimes" @open-seating-map="openSeatingMap" />
        </div>

        <!-- No showtimes available message -->
        <div v-else-if="movie">
          <p>No showtimes available for the selected theatre.</p>
        </div>
      </div>
    </div>

    <!-- Seating Plan Modal -->
    <SeatingPlanModal
      :isVisible="isSeatingModalVisible"
      :seats="seats"
      @close="closeSeatingModal"
      @proceed="proceedToPayment"
    />
  </div>
</template>

<script>
import Showtimes from './ShowTimes.vue';
import SeatingPlanModal from './SeatingPlanModal.vue';

export default {
  components: {
    Showtimes,
    SeatingPlanModal,
  },
  props: ['id'],
  data() {
    return {
      movie: null, // Movie details object
      // List of available theatres
      theatres: [
        { id: 1, name: 'Theatre A' },
        { id: 2, name: 'Theatre B' },
      ],
      selectedTheatre: 1, // Default selected theatre ID
      filteredShowtimes: [], // Store filtered showtimes based on selected theatre
      seats: [
        { id: 'A1', reserved: false, selected: false },
        // Add more seats as needed...
      ],
      isSeatingModalVisible: false,
      selectedShowtime: null,
    };
  },
  computed: {
    selectedTheatreName() {
      const selectedTheatre = this.theatres.find((theatre) => theatre.id === this.selectedTheatre);
      return selectedTheatre ? selectedTheatre.name : '';
    },
  },
  watch: {
    id: 'fetchMovieDetails',
  },
  methods: {
    fetchMovieDetails() {
      // Simulated movie data based on ID
      const mockMovies = [
        {
          id: '1',
          title: 'Example Movie 1',
          genre: 'Action',
          duration: 120,
          description: 'A thrilling action movie.',
        },
        {
          id: '2',
          title: 'Example Movie 2',
          genre: 'Comedy',
          duration: 90,
          description: 'A hilarious comedy movie.',
        },
      ];

      // Find movie by ID
      this.movie = mockMovies.find((movie) => movie.id === this.id);

      // If movie exists, update showtimes
      if (this.movie) {
        this.filteredShowtimes = this.getShowtimesForTheatre(this.selectedTheatre);
      } else {
        console.error('Movie not found');
      }
    },
    // Get showtimes for a selected theatre
    getShowtimesForTheatre(theatreId) {
      const showtimes = [
        {
          theatreId: 1,
          theatreName: 'Theatre A',
          showtimes: [
            { id: 1, time: '10:00 AM', availableSeats: 10 },
            { id: 2, time: '01:00 PM', availableSeats: 5 },
          ],
        },
        {
          theatreId: 2,
          theatreName: 'Theatre B',
          showtimes: [
            { id: 3, time: '11:00 AM', availableSeats: 8 },
            { id: 4, time: '02:00 PM', availableSeats: 12 },
          ],
        },
      ];

      const selectedTheatre = showtimes.find((theatre) => theatre.theatreId === theatreId);
      return selectedTheatre ? selectedTheatre.showtimes : [];
    },
    openSeatingMap(showtime) {
      this.selectedShowtime = showtime;
      this.isSeatingModalVisible = true;
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
  },
};
</script>

<style scoped>
.showtimes button {
  font-size: 16px;
}
</style>
