package com.example.model;

import java.util.concurrent.ThreadLocalRandom;

public class Ticket {
    private static final String[] NAMES = {
        "Ahmed Sabry", "Mona Adel", "Youssef Hassan", "Salma Ibrahim",
        "Omar Khaled", "Nour Mahmoud", "Kareem Fouad", "Habiba Tarek"
    };
    private static final String[] LOCATIONS = {
        "Cairo", "Alexandria", "Giza", "Luxor", "Aswan", "Hurghada", "Port Said", "Sharm El Sheikh"
    };

    private int id;
    private String category;
    private String arrivalLocation;
    private String departureLocation;
    private double price;
    private boolean active;

    public Ticket(int id, String category, String arrivalLocation, String departureLocation, double price) {
        this.id = id;
        this.category = category;
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.price = price;
    }
    public Ticket(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int arrivalIndex = random.nextInt(LOCATIONS.length);
        int departureIndex = (arrivalIndex + 1 + random.nextInt(LOCATIONS.length - 1)) % LOCATIONS.length;

        this.id = random.nextInt(1, 1001);
        this.category = NAMES[random.nextInt(NAMES.length)];
        this.arrivalLocation = LOCATIONS[arrivalIndex];
        this.departureLocation = LOCATIONS[departureIndex];
        this.price = Math.round(random.nextDouble(50.0, 500.0) * 100.0) / 100.0;
    }

    public int getId() {
        return this.id;
    }

    public String getCategory() {
        return this.category;
    }

    public String getArrivalLocation() {
        return this.arrivalLocation;
    }

    public String getDepartureLocation() {
        return this.departureLocation;
    }

    public double getPrice() {
        return this.price;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }
}
