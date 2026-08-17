package com.example.mapper;

import com.example.datatransferpackage.PassengerDataRequest;
import com.example.model.Passenger;

public class PassengerMapper {
   public PassengerDataRequest toDTO(Passenger passenger){
       return new PassengerDataRequest(passenger.getUsername());
   }

   public Passenger toEntity(PassengerDataRequest passengerDataRequest){
       NAME
   }
}


