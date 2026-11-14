package com.example.controller;

import com.example.controller.model.FareResponse;
import com.example.mapper.FareMapper;
import com.example.service.FareService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FairContainer {
    private FareService fairservice ;

    public FairContainer(FareService fairservice) {
        this.fairservice = fairservice;
    }

    @GetMapping("/api/admin/fares/{id}")
    public FareResponse getFares(@PathVariable int id){
        return FareMapper.dtoToFareResponse(fairservice.getFares(id));
    }

    @PostMapping("/api/admin/fares")
    public void createFare(@RequestBody FareResponse response){
        fairservice.createFare(FareMapper.fareResponseToDto(response));
    }

    @PutMapping("/api/admin/{id}")
    public void updateFare(@RequestBody FareResponse response, @PathVariable int id){
       fairservice.updateFair(FareMapper.fareResponseToDto(response), id);
    }

    @DeleteMapping("/api/admin/{id}")
    public void deleteFare(@PathVariable int id){
        fairservice.deleteFare(id);
    }
}
