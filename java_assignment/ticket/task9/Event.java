package com.hexaware.ticket.task9;
public class Event {
    protected String eventName, eventDate, eventTime, eventType;
    protected Venue venue;
    protected int totalSeats, availableSeats;
    protected double ticketPrice;

    public Event() {}

    public Event(String name, String date, String time, int totalSeats, double price, String type, Venue venue) {
        this.eventName = name;
        this.eventDate = date;
        this.eventTime = time;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = price;
        this.eventType = type;
        this.venue = venue;
    }

    public void displayEventDetails() {
        System.out.println("Event: " + eventName + ", Type: " + eventType);
        System.out.println("Date: " + eventDate + ", Time: " + eventTime);
        System.out.println("Available Seats: " + availableSeats + "/" + totalSeats);
        System.out.println("Price: ₹" + ticketPrice);
        venue.displayVenueDetails();
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int count) {
        availableSeats -= count;
    }

    public void cancelSeats(int count) {
        availableSeats += count;
    }

    public String getEventName() {
        return eventName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}