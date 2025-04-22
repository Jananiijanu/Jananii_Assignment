package com.hexaware.ticket.task5;

	public class Movie extends Event {
	    private String genre, actorName, actressName;

	    public Movie() {}

	    public Movie(String eventName, String date, String time, int totalSeats, double ticketPrice, String venueName,
	                 String genre, String actorName, String actressName) {
	        super(eventName, date, time, totalSeats, ticketPrice, venueName);
	        this.genre = genre;
	        this.actorName = actorName;
	        this.actressName = actressName;
	    }

	    public void displayEventDetails() {
	        super.displayEventDetails();
	        System.out.println("Genre: " + genre);
	        System.out.println("Actor: " + actorName);
	        System.out.println("Actress: " + actressName);
	    }
}


