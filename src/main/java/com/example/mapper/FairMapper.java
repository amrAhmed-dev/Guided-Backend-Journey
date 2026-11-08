package com.example.mapper;

import com.example.controller.model.FairResponse;
import com.example.entity.Fair;

import java.time.LocalDateTime;

public class FairMapper {

    static public Fair fiarresponseToDto(FairResponse response){
        return new Fair(
                response.getId(),
                response.getCategory(),
                response.getOrignStation(),
                response.getDestionationStation(),
                response.getPrice(),
                true
        );
    }
    static public FairResponse dtoToFairResponse(Fair dto){
        return new FairResponse(
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
