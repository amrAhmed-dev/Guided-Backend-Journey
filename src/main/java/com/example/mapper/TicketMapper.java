package com.example.mapper;


import com.example.controller.model.TicketResponse;
import com.example.dto.Ticket;
import com.example.entity.TicketEntity;

public class TicketMapper {

  static public Ticket entityToDto(TicketEntity entity){
        return new Ticket(
                entity.getCategory(),
                entity.getArrivalLocation(),
                entity.getDepartureLocation(),
                entity.getPrice(),
                entity.isActive()
        );
   }

static public TicketResponse dtoToTicketRespone(Ticket dto){
       return new TicketResponse(
      dto.getCategory(),
               dto.getArrivalLocation(),
               dto.getDepartureLocation(),
               dto.getPrice(),
               dto.isActive()
               );

   }
static public Ticket ticketResponseToDto(TicketResponse response){
      return new Ticket(
              response.getCategory(),
              response.getArrivalLocation(),
              response.getDepartureLocation(),
              response.getPrice(),
              response.isActive()
      );
}
}

