package com.acmeplex.backend.repository;

import com.acmeplex.backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Movie, Integer> {
    // Find tickets for a specific user
    List<Ticket> findByUserId(Integer userId);

    // Find tickets for a specific showtime
    List<Ticket> findByShowtimeId(Integer showtimeId);

    // Find tickets for a specific theater
    List<Ticket> findByTheaterId(Integer theaterId);

    // Find all tickets purchased within a specific date range
    List<Ticket> findByPurchaseDateBetween(LocalDateTime start, LocalDateTime end);

    // Count tickets sold for a specific showtime
    long countByShowtimeId(Integer showtimeId);

    // Find all tickets sorted by purchase date
    List<Ticket> findAllByOrderByPurchaseDateDesc();
}
