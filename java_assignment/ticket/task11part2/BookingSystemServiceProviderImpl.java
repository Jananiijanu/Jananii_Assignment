package com.hexaware.ticket.task11;

import java.util.*;

public class BookingSystemServiceProviderImpl implements BookingSystemServiceProvider {
    private Map<String, Event> events = new HashMap<>();
    private Map<Integer, Booking> bookings = new HashMap<>();
    private int bookingCounter = 1;

    @Override
    public Event createEvent(String name, String date, String time, int totalSeats, double price, String type, Venue venue) {
        Event event = new Event(name, date, time, totalSeats, price, type, venue);
        events.put(name, event);
        return event;
    }

    @Override
    public void bookTickets(String eventName, int quantity, List<Customer> customers) throws Exception {
        Event event = events.get(eventName);
        if (event == null) throw new Exception("Event not found.");
        if (event.getAvailableSeats() < quantity) throw new Exception("Not enough seats available.");

        event.setAvailableSeats(event.getAvailableSeats() - quantity);
        Booking booking = new Booking(bookingCounter++, event, customers, quantity);
        bookings.put(booking.getBookingId(), booking);
        System.out.println("Booking successful. Booking ID: " + booking.getBookingId());
    }

    @Override
    public void cancelBooking(int bookingId) {
        Booking booking = bookings.remove(bookingId);
        if (booking != null) {
            Event event = booking.getEvent();
            event.setAvailableSeats(event.getAvailableSeats() + booking.getQuantity());
            System.out.println("Booking cancelled: ID " + bookingId);
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    @Override
    public void getBookingDetails(int bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Event: " + booking.getEvent().getName());
            System.out.println("Customers:");
            for (Customer customer : booking.getCustomers()) {
                System.out.println("- " + customer.getName());
            }
        } else {
            System.out.println("No booking found with ID: " + bookingId);
        }
    }
}
