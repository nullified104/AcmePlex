package com.acmeplex.backend.repository;

import com.acmeplex.backend.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Movie, Integer> {
    // Find showtimes for a specific movie
    List<Showtime> findByMovieId(Integer movieId);

    // Find showtimes by theater ID
    List<Showtime> findByTheaterId(Integer theaterId);

    // Find showtimes starting after a specific date and time
    List<Showtime> findByStartTimeAfter(LocalDateTime startTime);

    // Find showtimes for a specific date
    List<Showtime> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    // Find all showtimes sorted by start time
    List<Showtime> findAllByOrderByStartTimeAsc();
}
