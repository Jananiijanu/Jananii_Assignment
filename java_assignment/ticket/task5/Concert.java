package com.hexaware.ticket.task5;

	public class Concert extends Event {
	    private String artist, type;

	    public Concert() {}

	    public Concert(String eventName, String date, String time, int totalSeats, double ticketPrice, String venueName,
	                   String artist, String type) {
	        super(eventName, date, time, totalSeats, ticketPrice, venueName);
	        this.artist = artist;
	        this.type = type;
	    }

	    public void displayEventDetails() {
	        super.displayEventDetails();
	        System.out.println("Artist: " + artist);
	        System.out.println("Type: " + type);
	    }
	}


