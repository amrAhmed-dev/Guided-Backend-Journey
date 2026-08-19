package com.example.mapper;

import com.example.datatransferpackage.PassengerData;
import com.example.model.Passenger;

public class PassengerMapper {
   public PassengerData toDTO(Passenger passenger){
       return new PassengerData(passenger.getUsername());
   }

   public boolean checkName(String name){
       Passenger passenger=new Passenger();
       return passenger.validateUserName(name);
   }


}


