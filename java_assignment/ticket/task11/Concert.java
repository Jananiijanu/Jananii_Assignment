package com.hexaware.ticket.task11;
public class Concert extends Event {
    public Concert(int eventId, String eventName, String eventDate, String eventTime,
                   int totalSeats, int availableSeats, double ticketPrice, String eventType, Venue venue) {
        super(eventId, eventName, eventDate, eventTime, totalSeats, availableSeats, ticketPrice, eventType, venue);
    }
}
