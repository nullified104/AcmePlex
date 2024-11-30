<template>
  <div class="main-container">
    <NavigationBar/>
    <MovieDetails/>
  </div>
</template>

<script>
import NavigationBar from './components/NavigationBar.vue';
import MovieDetails from './components/MovieDetails.vue';

export default {
  name: 'App',
  components: {
    NavigationBar,
    MovieDetails,
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@468&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');

#app {
  font-family: 'Roboto', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
