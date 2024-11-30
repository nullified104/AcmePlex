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
@RequestMapping("/api/registered-users")
@CrossOrigin("http://localhost:3000/")
public class RegisteredUserController {

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @GetMapping
    public List<RegisteredUser> getAllRegisteredUsers() {
        return registeredUserRepository.findAll();
    }

    @PostMapping
    public RegisteredUser createRegisteredUser(@RequestBody RegisteredUser registeredUser) {
        registeredUser.setRegistrationDate(LocalDateTime.now());
        registeredUser.setAnnualFeePaid(true); // Default to true when creating
        return registeredUserRepository.save(registeredUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisteredUser> getRegisteredUserById(@PathVariable Integer id) {
        Optional<RegisteredUser> user = registeredUserRepository.findById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisteredUser> updateRegisteredUser(@PathVariable Integer id, @RequestBody RegisteredUser updatedUser) {
        return registeredUserRepository.findById(id).map(user -> {
            user.setAnnualFeePaid(updatedUser.isAnnualFeePaid());
            user.setCreditCard(updatedUser.getCreditCard());
            return ResponseEntity.ok(registeredUserRepository.save(user));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegisteredUser(@PathVariable Integer id) {
        if (registeredUserRepository.existsById(id)) {
            registeredUserRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}