package com.hexaware.ticket.task4;
import com.hexaware.ticket.task4.Customer;
import com.hexaware.ticket.task4.Event;


public class Booking {
	    private Event event;
	    private Customer customer;
	    private double totalBookingCost;

	    public Booking(Event event, Customer customer) {
	        this.event = event;
	        this.customer = customer;
	    }

	    public double calculateBookingCost(int numTickets) {
	        return numTickets * event.getTicketPrice();
	    }

	    public void bookTickets(int numTickets) {
	        event.bookTickets(numTickets);
	        totalBookingCost = calculateBookingCost(numTickets);
	    }

	    public void cancelBooking(int numTickets) {
	        event.cancelBooking(numTickets);
	    }

	    public int getAvailableNoOfTickets() {
	        return event.getAvailableSeats();
	    }

	    public void getEventDetails() {
	        event.displayEventDetails();
	    }
	}


