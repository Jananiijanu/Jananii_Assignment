package com.hexaware.ticket.task11;

import java.util.*;

public class TicketBookingSystem {
    public static void main(String[] args) {
        // Create booking system instance
        BookingSystemServiceProviderImpl bookingSystem = new BookingSystemServiceProviderImpl();

        // Create a venue
        Venue venue = new Venue(1, "Hexa Auditorium");

        // Create an event
        Event event = bookingSystem.createEvent("Tech Talk", "2025-04-25", "17:00", 100, 299.0, "Seminar", venue);

        // Create customers
        Customer customer1 = new Customer(101, "Alice");
        Customer customer2 = new Customer(102, "Bob");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        try {
            // Book tickets
            bookingSystem.bookTickets("Tech Talk", 2, customerList);

            // View booking details
            bookingSystem.getBookingDetails(1);

            // Cancel booking
            bookingSystem.cancelBooking(1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
