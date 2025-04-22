package com.hexaware.ticket.task6;
	public abstract class Event {
	    protected String eventName, date, time, venue;
	    protected int totalSeats, availableSeats;
	    protected double ticketPrice;

	    public Event(String eventName, String date, String time, int totalSeats, double ticketPrice, String venue) {
	        this.eventName = eventName;
	        this.date = date;
	        this.time = time;
	        this.totalSeats = totalSeats;
	        this.availableSeats = totalSeats;
	        this.ticketPrice = ticketPrice;
	        this.venue = venue;
	    }

	    public abstract void displayEventDetails();

	    public int getAvailableSeats() {
	        return availableSeats;
	    }

	    public double bookTickets(int numTickets) {
	        if (numTickets <= availableSeats) {
	            availableSeats -= numTickets;
	            return ticketPrice * numTickets;
	        } else {
	            return -1;
	        }
	    }

	    public void cancelTickets(int numTickets) {
	        availableSeats += numTickets;
	        if (availableSeats > totalSeats)
	            availableSeats = totalSeats;
	    }
	}


