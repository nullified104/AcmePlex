package com.acmeplex.backend.repository;

import com.acmeplex.backend.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    // Find theaters in a specific city
    List<Theater> findByCity(String city);

    // Find theaters by capacity greater than a specific number
    List<Theater> findByCapacityGreaterThan(Integer capacity);

    // Find theaters that are currently operational
    List<Theater> findByIsOperationalTrue();

    // Find theaters showing a specific movie
    List<Theater> findByMovies_Id(Integer movieId);

    // Find theaters with a specific name
    List<Theater> findByNameContainingIgnoreCase(String name);
}
