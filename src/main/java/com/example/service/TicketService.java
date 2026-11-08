package com.example.service;

import com.example.dto.Ticket;
import com.example.entity.TicketEntity;
import com.example.mapper.TicketMapper;
import com.example.repository.TicketsDataBase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TicketService {


    public Ticket createTicket(int id){
        if(TicketsDataBase.database.stream().anyMatch(t-> t.getId() == id)){
            TicketEntity ticket =TicketsDataBase.database.stream().filter(t-> t.getId() == id).findFirst().orElseThrow();
            return TicketMapper.entityToDto(ticket);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found with ID: " + id);
        }
    }
}
