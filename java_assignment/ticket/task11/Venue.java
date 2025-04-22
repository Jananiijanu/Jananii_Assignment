package com.hexaware.ticket.task11;

public class Venue {
    private int venueId;
    private String venueName;

    public Venue(int venueId, String venueName) {
        this.venueId = venueId;
        this.venueName = venueName;
    }

    public int getVenueId() {
        return venueId;
    }

    public String getVenueName() {
        return venueName;
    }
}
