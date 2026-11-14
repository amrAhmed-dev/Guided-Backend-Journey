package com.example.mapper;

import com.example.dto.PassengerData;
import com.example.entity.Passenger;

public class PassengerMapper {
   public PassengerData toDTO(Passenger passenger){
       return new PassengerData(passenger.getUsername());
   }

   public boolean checkName(String name){
       Passenger passenger=new Passenger();
       return passenger.validateUserName(name);
   }


}


