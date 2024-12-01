<template>
    <div class="column mb-4">
      <div class="card-group">
        <div class="card" style="width: 18rem;">
          <img src="@/assets/movie.jpg" class="card-img-top img-responsive" alt="Movie">
          <div class="card-body">
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Title: {{ title }}</li>
              <li class="list-group-item">Genre: {{ genre }}</li>
              <li class="list-group-item">Duration: {{ duration }} mins</li>
            </ul>
            <button @click="navigateToMovie" class="btn btn-outline-dark">See Details</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'MovieItem',
    props: {
      id: Number,
      title: String,
      genre: String,
      duration: Number,
    },
    methods: {
      navigateToMovie() {
        this.$router.push(`/movie/${this.id}`);
      },
    },
  };
  </script>
  