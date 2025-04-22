package com.hexaware.ticket.task11part2;

public class Event {
    private String eventName;
    private String eventDate;
    private String eventTime;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private String eventType;
    private Venue venue;

    public Event(String eventName, String eventDate, String eventTime, int totalSeats,
                 double ticketPrice, String eventType, Venue venue) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
        this.venue = venue;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getEventType() {
        return eventType;
    }

    public Venue getVenue() {
        return venue;
    }

    public void bookSeats(int number) {
        this.availableSeats -= number;
    }

    public void cancelSeats(int number) {
        this.availableSeats += number;
    }
}
