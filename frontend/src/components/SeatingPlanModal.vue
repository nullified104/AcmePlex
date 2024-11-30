<template>
    <div v-if="isVisible" class="modal fade show" tabindex="-1" style="display: block;" aria-labelledby="seatingModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="seatingModalLabel">Select Your Seats</h5>
            <button type="button" class="btn-close" @click="closeModal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="seat-map">
              <!-- Seat Rows Loop -->
              <div v-for="(row, rowIndex) in seatRows" :key="rowIndex" class="row mb-4 justify-content-center">
                <!-- Seat Columns Loop -->
                <div v-for="(seat, seatIndex) in row" :key="seatIndex" class="col-2 mb-3 d-flex justify-content-center">
                  <button
                    class="btn seat-btn"
                    :class="{
                      'btn-success': seat.selected,
                      'btn-danger': seat.reserved,
                      'btn-secondary': !seat.selected && !seat.reserved,
                    }"
                    :disabled="seat.reserved"
                    @click="selectSeat(seat)"
                  >
                    {{ seat.id }}
                  </button>
                </div>
              </div>
            </div>
  
            <!-- Proceed to Payment Button -->
            <div v-if="selectedSeats.length > 0" class="mt-3">
              <button class="btn btn-secondary w-100" @click="proceedToPayment">Proceed to Payment</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      isVisible: Boolean,
      seats: Array, // Pass seats data from parent component
    },
    data() {
      return {
        selectedSeats: [], // Array to store selected seats
      };
    },
    computed: {
      // Group seats into rows (adjust the number of seats per row)
      seatRows() {
        const rows = [];
        const seatsPerRow = 5; 
        for (let i = 0; i < this.seats.length; i += seatsPerRow) {
          rows.push(this.seats.slice(i, i + seatsPerRow));
        }
        return rows;
      },
    },
    methods: {
      closeModal() {
        this.$emit('close');
      },
      selectSeat(seat) {
        // Toggle seat selection
        if (seat.selected) {
          seat.selected = false;
          this.selectedSeats = this.selectedSeats.filter(s => s.id !== seat.id);
        } else {
          seat.selected = true;
          this.selectedSeats.push(seat);
        }
      },
      proceedToPayment() {
        // Logic to proceed to payment
        alert('Proceeding to payment with selected seats!');
        this.closeModal(); 
      },
    },
  };
  </script>
  
  <style scoped>
  .seat-map {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .seat-map .row {
    display: flex;
    justify-content: center;
    margin-bottom: 25px; 
  }
  
  .seat-map .col-2 {
    padding: 10px;
  }
  
  .seat-btn {
    width: 60px;
    height: 60px;
    font-size: 14px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 10px;
    transition: background-color 0.3s ease;
  }
  
  .btn-success {
    background-color: #28a745;
  }
  
  .btn-danger {
    background-color: #dc3545;
  }
  
  .btn-secondary {
    background-color: #6c757d;
  }
  
  .mt-3 {
    margin-top: 1rem;
  }
  </style>
  