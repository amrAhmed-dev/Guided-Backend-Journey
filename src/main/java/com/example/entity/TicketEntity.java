package com.example.entity;

import java.time.LocalDateTime;

public class TicketEntity {
    private int  id;
    private TicketCategory category;
    private String arrivalLocation;
    private String departureLocation;
    private double price;
    private boolean active;
    private String username;
    private String qrcode;
    private LocalDateTime buyAt;

    public TicketEntity(int id, TicketCategory category, String arrivalLocation, String departureLocation, double price, boolean active, String username, String qrcode, LocalDateTime buyAt) {
        this.id = id;
        this.category = category;
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.price = price;
        this.active = active;
        this.username = username;
        this.qrcode = qrcode;
        this.buyAt = buyAt;
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

    public LocalDateTime getBuyAt() {
        return buyAt;
    }

    public int getId() {
        return id;
    }
}
