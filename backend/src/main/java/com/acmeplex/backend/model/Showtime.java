package com.acmeplex.backend.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
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
    private Theater theater;

    @OneToMany(mappedBy = "showtime")
    private List<Seat> seats;

    public Showtime(LocalDateTime time) {
        this.time = time;
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

    public List<Seat> getSeats() {
        return seats;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}