<template>
    <div class="hero">
      <HeroComponent />
      <div class="content p-4">
        <h3 class="text-start">Movies</h3>
        <div class="row row-cols-6">
          <MovieItem
            v-for="movie in movies"
            :key="movie.id"
            :id="movie.id"
            :title="movie.title"
            :image="movie.image"
          />
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import MovieService from '@/services/MovieService';
  import MovieItem from './MovieItem.vue';
  import HeroComponent from './HeroComponent.vue';
  
  export default {
    name: 'HomePage',
    components: {
      MovieItem,
      HeroComponent,
    },
    data() {
      return {
        movies: [],
      };
    },
    methods: {
    },
    created() {
      MovieService.getAllMovies()
      .then(response => {
        this.movies = response.data;
      })
      .catch(error => {
        console.error('Failed to fetch movies:', error);
      });
    },
  };
  </script>
  