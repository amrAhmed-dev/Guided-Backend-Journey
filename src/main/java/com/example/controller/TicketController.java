package com.example.controller;

import com.example.controller.model.CreateTicketRequest;
import com.example.controller.model.TicketResponse;


import com.example.mapper.TicketMapper;
import com.example.service.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController()
public class TicketController {
    private TicketService ticketService;
    TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("api/tickets")
    public TicketResponse createTicket(@RequestBody CreateTicketRequest request){
      return  TicketMapper.dtoToTicketRespone(ticketService.createTicket(request.getId()));
    }


}