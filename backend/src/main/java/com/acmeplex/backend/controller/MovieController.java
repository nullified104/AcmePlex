package com.acmeplex.backend.controller;

import com.acmeplex.backend.model.Movie;
import com.acmeplex.backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable("id") Integer id) {
        return movieRepository.findById(id).orElse(null);
    }


    @GetMapping("/movies/populate")
    public void populateMovies() {
        List<Movie> movies = List.of(
                new Movie("Inception", "Sci-Fi", 148),
                new Movie("The Dark Knight", "Action", 152),
                new Movie("Titanic", "Romance", 195),
                new Movie("The Matrix", "Sci-Fi", 136),
                new Movie("Pulp Fiction", "Crime", 154),
                new Movie("The Godfather", "Crime", 175),
                new Movie("Forrest Gump", "Drama", 142),
                new Movie("Gladiator", "Action", 155),
                new Movie("The Shawshank Redemption", "Drama", 142),
                new Movie("The Lion King", "Animation", 88),
                new Movie("Interstellar", "Sci-Fi", 169),
                new Movie("Avengers: Endgame", "Action", 181),
                new Movie("The Prestige", "Mystery", 130),
                new Movie("The Social Network", "Biography", 120),
                new Movie("Fight Club", "Drama", 139)
        );

        movieRepository.saveAll(movies);  // Save all movies to the database
    }
}
