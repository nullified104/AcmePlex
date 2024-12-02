package com.acmeplex.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.*;


@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seat_seq")
    @SequenceGenerator(name = "seat_seq", sequenceName = "seat_seq", allocationSize = 1)
    private Integer id;
    private int rowNumber;
    private int seatNumber;
    private boolean isAvailable;
    private boolean reservedByRU;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    @JsonBackReference
    private Showtime showtime;

    @OneToOne(mappedBy = "seat")
    @JsonIgnore
    private Ticket ticket;

    public Seat() {}

    public Seat(Integer rowNumber, Integer seatNumber, boolean isAvailable, boolean reservedByRU, Showtime showtime) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
        this.reservedByRU = reservedByRU;
        this.showtime = showtime;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isReservedByRU() {
        return reservedByRU;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public Integer getId() {
        return id;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setReservedByRU(boolean reservedByRU) {
        this.reservedByRU = reservedByRU;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }


    public void setId(Integer id) {
        this.id = id;
    }

}
