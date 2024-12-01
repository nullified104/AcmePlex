package com.acmeplex.backend.repository;

import com.acmeplex.backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Movie, Integer> {

}
