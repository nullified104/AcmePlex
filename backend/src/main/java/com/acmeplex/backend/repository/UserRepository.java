package com.acmeplex.backend.repository;

import com.acmeplex.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Movie, Integer> {
    // Find a user by username
    Optional<User> findByUsername(String username);

    // Find users by email
    Optional<User> findByEmail(String email);

    // Find all users by partial username match (case-insensitive)
    List<User> findByUsernameContainingIgnoreCase(String keyword);

    // Find users by address
    List<User> findByAddressContainingIgnoreCase(String address);

    // Find users by credit card number
    List<User> findByCreditCard(String creditCard);

    // Count users with a specific email domain
    long countByEmailEndingWith(String domain);

    // Check if a user exists by username
    boolean existsByUsername(String username);

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Delete a user by username
    void deleteByUsername(String username);
}
