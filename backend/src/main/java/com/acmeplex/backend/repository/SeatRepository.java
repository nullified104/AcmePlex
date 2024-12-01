package com.acmeplex.backend.repository;

import com.acmeplex.backend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface SeatRepository extends JpaRepository<Movie, Integer> {
    // Find seats by theater ID
    List<Seat> findByTheaterId(Integer theaterId);

    // Find available seats for a specific showtime
    List<Seat> findByShowtimeIdAndIsAvailableTrue(Integer showtimeId);

    // Find seats by row and column within a theater
    List<Seat> findByTheaterIdAndRowAndColumn(Integer theaterId, String row, Integer column);

    // Count the number of available seats for a specific showtime
    long countByShowtimeIdAndIsAvailableTrue(Integer showtimeId);

    // Find all seats that are reserved for a specific showtime
    List<Seat> findByShowtimeIdAndIsAvailableFalse(Integer showtimeId);
}
