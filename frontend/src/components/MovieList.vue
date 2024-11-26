<template>
    <div class="content p-4">
        <h3 class="text-start">Movies</h3>
            <div class="row row-cols-6">
                <MovieItem v-for="movie in movies" v-bind:key="movie.id" v-bind="movie"/>
            </div>
    </div>
</template>

<script>
import MovieService from '@/services/MovieService';
import MovieItem from './MovieItem.vue';


export default {
    name: 'MovieList',
    components: {
        MovieItem
    },
    data() {
        return {
            movies: []
        }
    },
    methods: {
        getMovies() {
            MovieService.getMovies().then(response => {
                this.movies = response.data;
            });
            }
    },
    created() {
        this.getMovies();
    }
}
</script>