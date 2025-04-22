package com.hexaware.ticket.task7;
import java.time.LocalDate;
import java.time.LocalTime;

	public class Sport extends Event {
	    private String sportName;
	    private String teamsName;

	    public Sport(String name, LocalDate date, LocalTime time, Venue venue, int seats, double price, String type, String sportName, String teams) {
	        super(name, date, time, venue, seats, price, type);
	        this.sportName = sportName;
	        this.teamsName = teams;
	    }

	    public void displayEventDetails() {
	        System.out.println("Sport: " + eventName + ", Game: " + sportName + ", Teams: " + teamsName);
	        System.out.println("Date: " + eventDate + " Time: " + eventTime + " Price: " + ticketPrice + " Available: " + availableSeats);
	        venue.displayVenueDetails();
	    }
	}

