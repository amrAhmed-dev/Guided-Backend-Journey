package com.example.service;

import com.example.entity.Fare;
import com.example.repository.FareDataBase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FareService {
    public Fare getFares(int id){
        if(FareDataBase.database.stream().anyMatch(t-> t.getId() == id)){
            return FareDataBase.database.stream().filter(t-> t.getId() == id).findFirst().orElseThrow();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fare not found with ID: ");
        }
    }

public void createFare(Fare newfare){
        if(newfare ==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "please create vaild request of creation the fair");
        }
        else{
         FareDataBase.database.add(newfare);
        }
}

public void updateFair(Fare updatefair, int id ){
            if(FareDataBase.database.stream().anyMatch(t-> t.getId() == id)){
                Fare fare = FareDataBase.database.set(id,updatefair);
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fare not found with ID: ");
            }
}
public void deleteFare(int id){
    if(FareDataBase.database.stream().anyMatch(t-> t.getId() == id)){
        FareDataBase.database.removeIf(t-> t.getId() == id);
    }
    else{
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fare not found with ID: ");
    }
}
}
