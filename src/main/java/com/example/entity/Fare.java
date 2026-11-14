package com.example.entity;



import java.time.LocalDateTime;


public class Fare {
    private int id;
    private TicketCategory category;
    private int arrivalStation;
    private int departureStation;
    private double price;
    private boolean active;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Fare(int id, TicketCategory category, int arrivalStation, int departureStation, double price, boolean active) {
        this.id = id;
        this.category = category;
        this.arrivalStation = arrivalStation;
        this.departureStation = departureStation;
        this.price = price;
        this.active= active;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();

    }


    public int getId() {
        return this.id;
    }

    public TicketCategory getCategory() {
        return this.category;
    }

    public int getArrivalStation() {
        return this.arrivalStation;
    }

    public int getDepartureStation() {
        return this.departureStation;
    }

    public double getPrice() {
        return this.price;
    }

    public void setCategory(TicketCategory category) {
        this.category = category;
    }

    public void setArrivalStation(int arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public void setDepartureStation(int departureStation) {
        this.departureStation = departureStation;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
}
