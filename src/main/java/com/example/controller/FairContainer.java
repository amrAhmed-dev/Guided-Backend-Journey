package com.example.controller;

import com.example.controller.model.FairResponse;
import com.example.mapper.FairMapper;
import com.example.service.FairService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FairContainer {
    private FairService fairservice ;

    public FairContainer(FairService fairservice) {
        this.fairservice = fairservice;
    }

    @GetMapping("/api/admin/fares/{id}")
    public FairResponse getFares(@PathVariable int id){
        return FairMapper.dtoToFairResponse(fairservice.getFairs(id));
    }

    @PostMapping("/api/admin/fares")
    public void createFare(@RequestBody FairResponse response){
        fairservice.createFair(FairMapper.fiarresponseToDto(response));
    }

    @PutMapping("/api/admin/{id}")
    public void updateFare(@RequestBody FairResponse response,@PathVariable int id){
       fairservice.updateFair(FairMapper.fiarresponseToDto(response), id);
    }

    @DeleteMapping("/api/admin/{id}")
    public void deleteFare(@PathVariable int id){
        fairservice.deleteFare(id);
    }
}
