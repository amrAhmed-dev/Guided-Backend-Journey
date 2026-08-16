package com.example.controller;

import com.example.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @GetMapping({"/api/tickets"})
    public List<Ticket> getTickets() {
        Ticket t = new Ticket();
        List<Ticket> response = new ArrayList<>();
        response.add(t);
        return response;
    }

    @GetMapping({"/api/tickets/{id}"})
    public Ticket getTicket(@PathVariable int id) {
        return new Ticket();
    }

    @PostMapping({"/api/tickets"})
    public void addTicket(@RequestBody Ticket newticket) {

    }

    @PutMapping({"/api/tickets/{id}"})
    public void updateTicket(@PathVariable int id, @RequestBody Ticket updateticket) {

    }

    @DeleteMapping({"/api/tickets/{id}"})
    public void deleteTicket(@PathVariable int id) {

    }

    @PatchMapping({"/api/tickets/{id}"})
    public void destinationUpdate(@PathVariable int id, @RequestBody Map<String, String> newDistination) {

    }
}