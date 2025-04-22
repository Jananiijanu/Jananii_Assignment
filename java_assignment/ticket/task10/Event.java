package com.hexaware.ticket.task10;

public class Event {
    private String eventName;
    private String date;
    private String time;
    private int availableSeats;
    private double ticketPrice;
    private String eventType;
    private Venue venue;

    public Event(String eventName, String date, String time, int availableSeats, double ticketPrice, String eventType, Venue venue) {
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
        this.venue = venue;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
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
