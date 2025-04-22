package com.hexaware.ticket.task11;

import java.util.List;

public interface BookingSystemServiceProvider {
    Event createEvent(String name, String date, String time, int totalSeats, double price, String type, Venue venue);
    void bookTickets(String eventName, int quantity, List<Customer> customers) throws Exception;
    void cancelBooking(int bookingId);
    void getBookingDetails(int bookingId);
}
