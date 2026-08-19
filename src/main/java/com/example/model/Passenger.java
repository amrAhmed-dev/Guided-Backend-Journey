package com.example.model;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

// Entity  class , i make it for user
public class Passenger {

    private static final String[] NAMES = {
            "Ahmed Sabry", "Mona Adel", "Youssef Hassan", "Salma Ibrahim",
            "Omar Khaled", "Nour Mahmoud", "Kareem Fouad", "Habiba Tarek"
    };
    private static final Ticket[] TICKETS = Stream.generate(Ticket::new).limit(5).toArray(Ticket[]::new);

    private String username;
    private Ticket Passengerticket;
    private String Passwrod;// Senstive and interal data only used to store in simple sql table

    public Passenger(String username, Ticket passengerticket, String passwrod) {
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

    public void setPassengerticket(Ticket passengerticket) {
        Passengerticket = passengerticket;
    }
}
