package com.acmeplex.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@Entity
@Table(name = "showtime")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showtime_seq")
    @SequenceGenerator(name = "showtime_seq", sequenceName = "showtime_seq", allocationSize = 1)
    private Integer id;
    private LocalDateTime time;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    @JsonBackReference
    private Theater theater;

    @OneToMany(mappedBy = "showtime")
    @JsonManagedReference
    private List<Seat> seats;

    @OneToMany(mappedBy = "showtime")
    @JsonManagedReference
    private List<Ticket> tickets;

    public Showtime() {
    }

    public Showtime(LocalDateTime time, Movie movie, Theater theater) {
        this.time = time;
        this.movie = movie;
        this.theater = theater;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}