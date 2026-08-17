package com.example.controller;

import com.example.model.Ticket;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/tickets")
public class TicketController {


    //TODO Create ticket response and request models in the controller model package
    @GetMapping({"/{$username}"})
    public ResponseEntity<?> getPassenger(@PathVariable String username) {

    }

    @PostMapping("user/{user}/")
    public ResponseEntity<Void> addTicket(@RequestBody Ticket newticket) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping({"{id}"})
    public void updateTicket(@PathVariable int id, @RequestBody Ticket updateticket) {

    }

    @DeleteMapping({"/api/tickets/{id}"})
    public void deleteTicket(@PathVariable int id) {

    }

    @PatchMapping({"/api/tickets/{id}"})
    public void destinationUpdate(@PathVariable int id, @RequestBody Map<String, String> newDistination) {

    }
}