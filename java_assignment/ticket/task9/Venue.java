package com.hexaware.ticket.task9;

public class Venue {
    private String venueName;
    private String address;

    public Venue() {}

    public Venue(String venueName, String address) {
        this.venueName = venueName;
        this.address = address;
    }

    public void displayVenueDetails() {
        System.out.println("Venue: " + venueName + ", Address: " + address);
    }
}