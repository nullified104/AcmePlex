<template>
    <div class="container mt-4">
      <div class="row">
        <!-- Movie Poster Section -->
        <div class="col-md-4">
          <img src="@/assets/movie.jpg" class="img-fluid" alt="Movie Poster" />
        </div>
  
        <!-- Movie Details and Showtimes Section -->
        <div class="col-md-8">
          <h3>{{ movie.title }}</h3>
          <p><strong>Genre:</strong> {{ movie.genre }}</p>
          <p><strong>Duration:</strong> {{ movie.duration }} minutes</p>
          <p><strong>Description:</strong> {{ movie.description }}</p>
  
          <!-- Theatre Selection Dropdown -->
          <div class="form-group">
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
          <div v-else>
            <p>No showtimes available for the selected theatre.</p>
          </div>
        </div>
      </div>
  
      <!-- Seating Plan Modal -->
      <SeatingPlanModal
        :isVisible="isSeatingModalVisible"
        :seats="seats"
        @close="closeSeatingModal"
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
    data() {
      return {
        // Movie details
        movie: {
          title: 'Example Movie',
          genre: 'Action',
          duration: 120,
          description: 'A thrilling action movie with lots of suspense.',
          poster: 'https://via.placeholder.com/300',
          // Showtimes for different theatres
          showtimes: [
            {
              theatreId: 1,
              theatreName: 'Theatre A',
              showtimes: [
                { id: 1, time: '10:00 AM', availableSeats: 10 },
                { id: 2, time: '01:00 PM', availableSeats: 5 },
                { id: 3, time: '04:00 PM', availableSeats: 0 },
              ],
            },
            {
              theatreId: 2,
              theatreName: 'Theatre B',
              showtimes: [
                { id: 4, time: '11:00 AM', availableSeats: 12 },
                { id: 5, time: '02:00 PM', availableSeats: 8 },
                { id: 6, time: '05:00 PM', availableSeats: 15 },
              ],
            },
          ],
        },
        // List of available theatres
        theatres: [
          { id: 1, name: 'Theatre A' },
          { id: 2, name: 'Theatre B' },
        ],
        selectedTheatre: 1, // Default selected theatre ID
        filteredShowtimes: [], // Store filtered showtimes based on selected theatre
        seats: [
          { id: 'A1', reserved: false, selected: false },
          { id: 'A2', reserved: false, selected: false },
          { id: 'A3', reserved: false, selected: false },
          { id: 'A4', reserved: false, selected: false },
          { id: 'A5', reserved: true, selected: false },
          { id: 'A6', reserved: false, selected: false },
          { id: 'A7', reserved: false, selected: false },
          { id: 'A8', reserved: false, selected: false },
          { id: 'A9', reserved: true, selected: false },
          { id: 'A10', reserved: false, selected: false },
          { id: 'B1', reserved: false, selected: false },
          { id: 'B2', reserved: false, selected: false },
          { id: 'B3', reserved: false, selected: false },
          { id: 'B4', reserved: false, selected: false },
          { id: 'B5', reserved: true, selected: false },
          { id: 'B6', reserved: false, selected: false },
          { id: 'B7', reserved: false, selected: false },
          { id: 'B8', reserved: false, selected: false },
          { id: 'B9', reserved: false, selected: false },
          { id: 'B10', reserved: false, selected: false },
          { id: 'C1', reserved: false, selected: false },
          { id: 'C2', reserved: true, selected: false },
          { id: 'C3', reserved: false, selected: false },
          { id: 'C4', reserved: false, selected: false },
          { id: 'C5', reserved: false, selected: false },
          { id: 'C6', reserved: false, selected: false },
          { id: 'C7', reserved: false, selected: false },
          { id: 'C8', reserved: false, selected: false },
          { id: 'C9', reserved: false, selected: false },
          { id: 'C10', reserved: false, selected: false },
        ],
        isSeatingModalVisible: false,
        selectedShowtime: null,
      };
    },
    computed: {
      selectedTheatreName() {
        const selectedTheatre = this.theatres.find(theatre => theatre.id === this.selectedTheatre);
        return selectedTheatre ? selectedTheatre.name : '';
      },
    },
    watch: {
      selectedTheatre(newTheatreId) {
        this.filteredShowtimes = this.getShowtimesForTheatre(newTheatreId);
      },
    },
    methods: {
      // Get showtimes for a selected theatre
      getShowtimesForTheatre(theatreId) {
        const selectedTheatre = this.movie.showtimes.find(theatre => theatre.theatreId === theatreId);
        return selectedTheatre ? selectedTheatre.showtimes : [];
      },
      // Open the seating map modal with selected showtime data
      openSeatingMap(showtime) {
        this.selectedShowtime = showtime;
        this.isSeatingModalVisible = true;
      },
      closeSeatingModal() {
        this.isSeatingModalVisible = false;
      },
    },
    created() {
      // Initially set the filtered showtimes based on the default selected theatre
      this.filteredShowtimes = this.getShowtimesForTheatre(this.selectedTheatre);
    },
  };
  </script>
  
  <style scoped>
  .showtimes button {
    font-size: 16px;
  }
  </style>
  