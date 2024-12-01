package com.acmeplex.backend.repository;

import com.acmeplex.backend.model.RegisteredUser;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {
    // Find all users who have paid their annual fee
    List<RegisteredUser> findByAnnualFeePaidTrue();

    // Find all users who have not paid their annual fee
    List<RegisteredUser> findByAnnualFeePaidFalse();

    // Find users by registration date after a specific date
    List<RegisteredUser> findByRegistrationDateAfter(LocalDateTime date);

    // Find users by registration date before a specific date
    List<RegisteredUser> findByRegistrationDateBefore(LocalDateTime date);

    // Find users by partial email match (case-insensitive)
    List<RegisteredUser> findByEmailContainingIgnoreCase(String keyword);

    // Count the number of users who have paid their annual fee
    long countByAnnualFeePaidTrue();

    // Count the number of users who have not paid their annual fee
    long countByAnnualFeePaidFalse();

    // Find users with a specific username
    List<RegisteredUser> findByUsername(String username);

    // Find users with a specific credit card number
    List<RegisteredUser> findByCreditCard(String creditCard);
}
