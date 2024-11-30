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
@RequestMapping("/api/showtimes")
@CrossOrigin("http://localhost:3000/")
public class ShowtimeController {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @GetMapping
    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    @PostMapping
    public Showtime createShowtime(@RequestBody Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable Integer id) {
        Optional<Showtime> showtime = showtimeRepository.findById(id);
        return showtime.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable Integer id, @RequestBody Showtime updatedShowtime) {
        return showtimeRepository.findById(id).map(showtime -> {
            showtime.setTime(updatedShowtime.getTime());
            showtime.setMovie(updatedShowtime.getMovie());
            showtime.setTheater(updatedShowtime.getTheater());
            return ResponseEntity.ok(showtimeRepository.save(showtime));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable Integer id) {
        if (showtimeRepository.existsById(id)) {
            showtimeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}