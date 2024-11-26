import axios from 'axios'

const MOVIE_API_BASE_URL = 'http://localhost:8080/api/movies'

class MovieService {
    getMovies() {
        return axios.get(MOVIE_API_BASE_URL);
    }
}

export default new MovieService()