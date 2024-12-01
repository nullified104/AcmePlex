package com.acmeplex.backend.controller;

import com.acmeplex.backend.model.*;
import com.acmeplex.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/theaters")
@CrossOrigin("http://localhost:3000/")
public class TheaterController {

    @Autowired
    private TheaterRepository theaterRepository;

    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Integer id) {
        Optional<Theater> theater = theaterRepository.findById(id);
        return theater.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterRepository.save(theater);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Integer id, @RequestBody Theater updatedTheater) {
        return theaterRepository.findById(id).map(theater -> {
            theater.setName(updatedTheater.getName());
            theater.setAddress(updatedTheater.getAddress());
            return ResponseEntity.ok(theaterRepository.save(theater));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Integer id) {
        if (theaterRepository.existsById(id)) {
            theaterRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
