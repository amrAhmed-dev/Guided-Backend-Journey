package com.example.bus_ticket_api.controller;

import com.example.bus_ticket_api.model.Ticket;
import com.example.bus_ticket_api.service.TicketService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private TicketService ticketService;

    @GetMapping({"/api/tickets"})
    public List<Ticket> getTickets() {
        return this.ticketService.getTickets();
    }

    @GetMapping({"/api/tickets/{id}"})
    public Ticket getTicket(@PathVariable int id) {
        return this.ticketService.getTicket(id);
    }

    @PostMapping({"/api/tickets"})
    public void addTicket(@RequestBody Ticket newticket) {
        this.ticketService.addTicket(newticket);
    }

    @PutMapping({"/api/tickets/{id}"})
    public void updateTicket(@PathVariable int id, @RequestBody Ticket updateticket) {
        this.ticketService.updateTicket(id, updateticket);
    }

    @DeleteMapping({"/api/tickets/{id}"})
    public void deleteTicket(@PathVariable int id) {
        this.ticketService.deleteTicket(id);
    }

    @PatchMapping({"/api/tickets/{id}"})
    public void destinationUpdate(@PathVariable int id, @RequestBody Map<String, String> newDistination) {
        this.ticketService.destinationUpdate(id, newDistination);
    }
}