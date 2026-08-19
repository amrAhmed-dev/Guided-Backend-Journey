package com.example.controller;

import com.example.datatransferpackage.PassengerData;
import com.example.datatransferpackage.TicketRequest;
import com.example.mapper.PassengerMapper;


import com.example.mapper.TicketMapper;
import com.example.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
public class TicketController {

    //TODO Create ticket response and request models in the controller model package
    @GetMapping({"/api/tickets/{username}"})
    public ResponseEntity<?> getPassenger(@PathVariable("username") String username) {
        PassengerMapper mapper = new PassengerMapper();
        if(mapper.checkName(username)){
            PassengerData passenger = new PassengerData(username);
            return  ResponseEntity.ok(passenger);

        }
        else {
        return  ResponseEntity.badRequest().body("the username " +username +" is not valid");
        }
    }

    @PostMapping("users/{user}/tickets/{newticket}")
    public ResponseEntity<Void> addTicket(@RequestBody TicketRequest newticket , @PathVariable String user) {
        PassengerMapper mapper = new PassengerMapper();
        if(mapper.checkName(user)) {
            TicketMapper mapping  =new TicketMapper();
            mapping.convertToEntity(newticket);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else{
            return  ResponseEntity.badRequest().build();
        }
    }

    @PutMapping({"/api/users/{user}/tickets/{newticket}"})
    public void updateTicket(@PathVariable PassengerData passanger, @RequestBody Ticket updateticket) {


    }

    @DeleteMapping({"/api/tickets/{newticket}"})
    public void deleteTicket(@PathVariable int id) {

    }

    @PatchMapping({"/api/tickets/{newticket}"})
    public void destinationUpdate(@PathVariable int id, @RequestBody Map<String, String> newDistination) {

    }
}