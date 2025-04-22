package com.hexaware.ticket.task6;

	public class Movie extends Event {
	    private String genre, actorName, actressName;

	    public Movie(String eventName, String date, String time, int totalSeats, double ticketPrice, String venue,
	                 String genre, String actorName, String actressName) {
	        super(eventName, date, time, totalSeats, ticketPrice, venue);
	        this.genre = genre;
	        this.actorName = actorName;
	        this.actressName = actressName;
	    }

	    @Override
	    public void displayEventDetails() {
	        System.out.println("Movie Event");
	        System.out.println("Name: " + eventName + ", Genre: " + genre + ", Actor: " + actorName + ", Actress: " + actressName);
	        System.out.println("Date: " + date + ", Time: " + time + ", Venue: " + venue);
	        System.out.println("Price: " + ticketPrice + ", Available Seats: " + availableSeats);
	    }
	}


