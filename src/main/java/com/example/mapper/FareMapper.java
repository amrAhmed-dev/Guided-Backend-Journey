package com.example.mapper;

import com.example.controller.model.FareResponse;
import com.example.entity.Fare;

import java.time.LocalDateTime;

public class FareMapper {

    static public Fare fareResponseToDto(FareResponse response){
        return new Fare(
                response.getId(),
                response.getCategory(),
                response.getOrignStation(),
                response.getDestionationStation(),
                response.getPrice(),
                true
        );
    }
    static public FareResponse dtoToFareResponse(Fare dto){
        return new FareResponse(
                dto.getId(),
                dto.getPrice(),
                dto.getDepartureStation(),
                dto.getArrivalStation(),
                dto.getCategory(),
                LocalDateTime.now(),
                LocalDateTime.now()
                );
    }



}
