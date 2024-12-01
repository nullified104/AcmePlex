package com.acmeplex.backend.repository;

import com.acmeplex.backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // Find movies by genre
    List<Movie> findByGenre(String genre);

    // Find movies with a duration less than a specific value
    List<Movie> findByDurationLessThan(Integer duration);

    // Find movies with a duration greater than or equal to a specific value
    List<Movie> findByDurationGreaterThanEqual(Integer duration);

    // Find movies by title containing a keyword (case-insensitive)
    List<Movie> findByTitleContainingIgnoreCase(String keyword);

    // Find all movies sorted by duration in ascending order
    List<Movie> findAllByOrderByDurationAsc();

    // Find all movies sorted by duration in descending order
    List<Movie> findAllByOrderByDurationDesc();
}
