package com.example.dto;


import com.example.entity.TicketCategory;

public class Ticket {
    private int id ;
    private TicketCategory category;
    private String arrivalLocation;
    private String departureLocation;
    private double price;
    private boolean active;
    private String username;
    private String qrcode;

    public Ticket(TicketCategory category, String arrivalLocation, String departureLocation, double price, boolean active) {
        this.category = category;
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.price = price;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public TicketCategory getCategory() {
        return category;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public String getUsername() {
        return username;
    }

    public String getQrcode() {
        return qrcode;
    }
}
