package com.hexaware.ticket.task11;

public class Booking {
    private int bookingId;
    private int customerId;
    private Event event;
    private int numTickets;
    private double totalAmount;

    public Booking(int bookingId, int customerId, Event event, int numTickets, double totalAmount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.event = event;
        this.numTickets = numTickets;
        this.totalAmount = totalAmount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}