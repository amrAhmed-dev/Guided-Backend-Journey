package com.example.service;

import com.example.entity.Fair;
import com.example.repository.FairDataBase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FairService {
    public Fair getFairs(int id){
        if(FairDataBase.database.stream().anyMatch(t-> t.getId() == id)){
            Fair fair = FairDataBase.database.stream().filter(t-> t.getId() == id).findFirst().orElseThrow();
            return fair;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fair not found with ID: ");
        }
    }

public void  createFair(Fair newfair){
        if(newfair ==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "please create vaild request of creation the fair");
        }
        else{
         FairDataBase.database.add(newfair);
        }
}

public void updateFair(Fair updatefair,int id ){
            if(FairDataBase.database.stream().anyMatch(t-> t.getId() == id)){
                Fair fair = FairDataBase.database.set(id,updatefair);
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fair not found with ID: ");
            }
}
public void deleteFare(int id){
    if(FairDataBase.database.stream().anyMatch(t-> t.getId() == id)){
        FairDataBase.database.removeIf(t-> t.getId() == id);
    }
    else{
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fair not found with ID: ");
    }
}
}
