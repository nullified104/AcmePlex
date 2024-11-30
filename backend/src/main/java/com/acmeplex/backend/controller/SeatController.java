package com.acmeplex.backend.controller;

import com.acmeplex.backend.model.*;
import com.acmeplex.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/seats")
@CrossOrigin("http://localhost:3000/")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @GetMapping("/showtime/{showtimeId}")
    public List<Seat> getSeatsByShowtime(@PathVariable Integer showtimeId) {
        return seatRepository.findByShowtimeId(showtimeId);
    }

    @PostMapping
    public Seat createSeat(@RequestBody Seat seat) {
        return seatRepository.save(seat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Integer id, @RequestBody Seat updatedSeat) {
        return seatRepository.findById(id).map(seat -> {
            seat.setRowNumber(updatedSeat.getRowNumber());
            seat.setSeatNumber(updatedSeat.getSeatNumber());
            seat.setIsAvailable(updatedSeat.isAvailable());
            seat.setReservedByRU(updatedSeat.isReservedByRU());
            return ResponseEntity.ok(seatRepository.save(seat));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Integer id) {
        if (seatRepository.existsById(id)) {
            seatRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}