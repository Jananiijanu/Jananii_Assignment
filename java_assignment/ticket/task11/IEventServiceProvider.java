package com.hexaware.ticket.task11;

import java.util.List;

public interface IEventServiceProvider {
    Event createEvent(String name, String date, String time, int totalSeats, double price, String type, Venue venue);
    List<Event> getEventDetails();
    int getAvailableSeats(String eventName);
}
