package com.example.controller.model;
import java.time.LocalDate;

import com.example.entity.TicketCategory;

public class TicketResponse {
    private TicketCategory category;
    private String arrivalLocation;
    private String departureLocation;
    private double price;
    private boolean active;
    private LocalDate createat;
    private LocalDate updateat;

    public TicketResponse(TicketCategory category, String arrivalLocation, String departureLocation, double price, boolean active) {
        this.category = category;
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.price = price;
        this.active = active;

    }

    public TicketCategory getCategory() {
        return category;
    }

    public void setCategory(TicketCategory category) {
        this.category = category;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getCreateat() {
        return createat;
    }

    public void setCreateat(LocalDate createat) {
        this.createat = createat;
    }

    public LocalDate getUpdateat() {
        return updateat;
    }

    public void setUpdateat(LocalDate updateat) {
        this.updateat = updateat;
    }
}
