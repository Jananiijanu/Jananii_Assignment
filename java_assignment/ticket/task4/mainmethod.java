package com.hexaware.ticket.task4;
import java.util.Date;

import com.hexaware.ticket.task4.Customer;
import com.hexaware.ticket.task4.Event;
import com.hexaware.ticket.task4.Venue;
public class mainmethod {

	    public static void main(String[] args) {
	        Venue venue = new Venue("City Arena", "123 Main St.");
	        Event event = new Event("Rock Concert", new Date(), "6:00 PM", venue.getVenueName(), 500, 500, 100.0, "Concert");
	        Customer customer = new Customer("John Doe", "john.doe@example.com", "123-456-7890");

	        Booking booking = new Booking(event, customer);

	        event.displayEventDetails();
	        venue.displayVenueDetails();
	        customer.displayCustomerDetails();

	        booking.bookTickets(10);
	        System.out.println("Available Tickets: " + booking.getAvailableNoOfTickets());
	        booking.getEventDetails();

	        booking.cancelBooking(5);
	        System.out.println("Available Tickets after cancellation: " + booking.getAvailableNoOfTickets());
	    }
	}


