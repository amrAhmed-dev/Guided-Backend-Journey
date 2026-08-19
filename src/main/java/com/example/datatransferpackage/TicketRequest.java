package com.example.datatransferpackage;

import com.example.model.TicketCategory;

public class TicketRequest {

    private TicketCategory category;
    private String arrivalLocation;
    private String departureLocation;

    public TicketRequest(String departureLocation, String arrivalLocation, TicketCategory category) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.category = category;
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
}
