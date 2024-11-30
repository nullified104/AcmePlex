<template>
  <div>
    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">Time</th>
          <th scope="col">Available Seats</th>
          <th scope="col">Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(showtime, index) in showtimes" :key="index">
          <td>{{ showtime.time }}</td>
          <td>{{ showtime.availableSeats }}</td>
          <td>
            <!-- Buy Tickets Button -->
            <button
              class="btn btn-secondary"
              :disabled="showtime.availableSeats === 0"
              @click="handleBuyTickets(showtime)"
            >
              Buy Tickets
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: {
    showtimes: {
      type: Array,
      required: true,
    },
  },
  methods: {
    handleBuyTickets(showtime) {
      this.$emit("open-seating-map", showtime);
    },
  },
};
</script>

<style>
</style>
