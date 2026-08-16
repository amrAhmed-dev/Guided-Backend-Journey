package com.example.model;

public class Ticket {
    private int id;
    private String name;
    private String arrivalLocation;
    private String departureLocation;
    private double price;

    public Ticket(int id, String name, String arrivalLocation, String departureLocation, double price) {
        this.id = id;
        this.name = name;
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.price = price;
    }
    public Ticket(){

    }

    public int getId() {
        return this.id;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }
}
