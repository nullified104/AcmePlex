package com.acmeplex.backend.controller;

import com.acmeplex.backend.model.Movie;
import com.acmeplex.backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin("http://localhost:3000/")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable("id") Integer id) {
        return movieRepository.findById(id).orElse(null);
    }
}
