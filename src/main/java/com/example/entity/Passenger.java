package com.example.entity;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

// Entity  class , i make it for user
public class Passenger {

    private static final String[] NAMES = {
            "Ahmed Sabry", "Mona Adel", "Youssef Hassan", "Salma Ibrahim",
            "Omar Khaled", "Nour Mahmoud", "Kareem Fouad", "Habiba Tarek"
    };
    private static final Fair[] TICKETS = Stream.generate(Fair::new).limit(5).toArray(Fair[]::new);

    private String username;
    private Fair Passengerticket;
    private String Passwrod;// Senstive and interal data only used to store in simple sql table

    public Passenger(String username, Fair passengerticket, String passwrod) {
        this.username = username;
        Passengerticket = passengerticket;
        Passwrod = passwrod;
    }

    public Passenger() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        this.username = NAMES[random.nextInt(NAMES.length)];
        this.Passengerticket =TICKETS[random.nextInt(TICKETS.length)];
    }

    public String getUsername() {
        return username;
    }
    public boolean validateUserName(String username){
       for(int i =0 ;i<NAMES.length ;i++){
           String cleanName =NAMES[i].replace(" ","");
           if(cleanName.equalsIgnoreCase(username)) {
               return true;
           }
           }
       return false;
       }

    public void setPassengerticket(Fair passengerticket) {
        Passengerticket = passengerticket;
    }
}
