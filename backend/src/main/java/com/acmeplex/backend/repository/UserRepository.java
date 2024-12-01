package com.acmeplex.backend.repository;

import com.acmeplex.backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Movie, Integer> {

}
