package com.hexaware.ticket.task10;

public class Venue {
    private String venueName;
    private String address;

    public Venue(String venueName, String address) {
        this.venueName = venueName;
        this.address = address;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getAddress() {
        return address;
    }
}
