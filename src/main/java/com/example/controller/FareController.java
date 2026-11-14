package com.example.controller;

import com.example.controller.model.FareResponse;
import com.example.mapper.FareMapper;
import com.example.service.FareService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FareController {
    private final FareService fareService;

    public FareController(FareService fareService) {
        this.fareService = fareService;
    }

    @GetMapping("/api/admin/fares/{id}")
    public FareResponse getFares(@PathVariable int id){
        return FareMapper.dtoToFareResponse(fareService.getFares(id));
    }

    @PostMapping("/api/admin/fares")
    public void createFare(@RequestBody FareResponse response){
        fareService.createFare(FareMapper.fareResponseToDto(response));
    }

    @PutMapping("/api/admin/{id}")
    public void updateFare(@RequestBody FareResponse response, @PathVariable int id){
       fareService.updateFair(FareMapper.fareResponseToDto(response), id);
    }

    @DeleteMapping("/api/admin/{id}")
    public void deleteFare(@PathVariable int id){
        fareService.deleteFare(id);
    }
}
