package com.example.controller.model;

import com.example.entity.TicketCategory;

import java.time.LocalDateTime;

public class FairResponse {
    private int id;
    private double price;
    private int orignStation;
    private int destionationStation;
    private TicketCategory category;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public FairResponse(int id, double price, int orignStation, int destionationStation, TicketCategory category, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.price = price;
        this.orignStation = orignStation;
        this.destionationStation = destionationStation;
        this.category = category;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public TicketCategory getCategory() {
        return category;
    }

    public int getDestionationStation() {
        return destionationStation;
    }

    public int getOrignStation() {
        return orignStation;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
