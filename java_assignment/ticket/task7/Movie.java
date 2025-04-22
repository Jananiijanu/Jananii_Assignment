package com.hexaware.ticket.task7;
import java.time.LocalDate;
import java.time.LocalTime;

	public class Movie extends Event {
	    private String genre;
	    private String actorName;
	    private String actressName;

	    public Movie(String name, LocalDate date, LocalTime time, Venue venue, int seats, double price, String type, String genre, String actor, String actress) {
	        super(name, date, time, venue, seats, price, type);
	        this.genre = genre;
	        this.actorName = actor;
	        this.actressName = actress;
	    }

	    public void displayEventDetails() {
	        System.out.println("Movie: " + eventName + ", Genre: " + genre + ", Actor: " + actorName + ", Actress: " + actressName);
	        System.out.println("Date: " + eventDate + " Time: " + eventTime + " Price: " + ticketPrice + " Available: " + availableSeats);
	        venue.displayVenueDetails();
	    }
	}


