package com.acmeplex.backend.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.*;


@Entity
public class RegisteredUser extends User {
    private LocalDateTime registrationDate;
    private boolean annualFeePaid;

    public RegisteredUser() {
        super();
    }

    public RegisteredUser(String username, String password, String email, String address, String creditCard, LocalDateTime registrationDate, boolean annualFeePaid) {
        super(username, password, email, address, creditCard);
        this.registrationDate = registrationDate;
        this.annualFeePaid = annualFeePaid;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public boolean isAnnualFeePaid() {
        return annualFeePaid;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setAnnualFeePaid(boolean annualFeePaid) {
        this.annualFeePaid = annualFeePaid;
    }
}