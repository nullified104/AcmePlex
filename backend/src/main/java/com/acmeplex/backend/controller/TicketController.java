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
@RequestMapping("/api/tickets")
@CrossOrigin("http://localhost:3000/")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping
    public Ticket purchaseTicket(@RequestBody Ticket ticket) {
        ticket.setPurchaseDate(LocalDateTime.now());
        ticket.setCancelled(false);
        return ticketRepository.save(ticket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Integer id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Ticket> cancelTicket(@PathVariable Integer id) {
        return ticketRepository.findById(id).map(ticket -> {
            if (LocalDateTime.now().isBefore(ticket.getPurchaseDate().plusHours(72))) {
                ticket.setCancelled(true);
                ticket.setCancellationDate(LocalDateTime.now());
                return ResponseEntity.ok(ticketRepository.save(ticket));
            }
            return ResponseEntity.status(400).body(null);
        }).orElse(ResponseEntity.notFound().build());
    }
}