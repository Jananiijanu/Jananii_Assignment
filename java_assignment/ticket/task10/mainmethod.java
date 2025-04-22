package com.hexaware.ticket.task10;

public class mainmethod {
    public static void main(String[] args) {
        
        Venue venue = new Venue("Stadium", "New York");
        Event movieEvent = new Event("Movie A", "2025-06-15", "19:00", 100, 500.0, "Movie", venue);
        Event concertEvent = new Event("Concert B", "2025-06-20", "18:00", 200, 1000.0, "Concert", venue);

        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.addEvent("Movie A", movieEvent);
        bookingSystem.addEvent("Concert B", concertEvent);

        System.out.println("Available Events:");
        bookingSystem.displayEvents();

        Customer customer = new Customer("John Doe", "john@example.com", "123456789");
        Booking booking = new Booking(movieEvent);
        booking.addCustomer(customer.getEmail(), customer);
        booking.calculateTotalCost(2);

        System.out.println("Total booking cost: ₹" + booking.getTotalCost());
    }
}
