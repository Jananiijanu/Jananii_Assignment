package com.hexaware.ticket.task6;
	public class Sports extends Event {
	    private String sportName, teams;

	    public Sports(String eventName, String date, String time, int totalSeats, double ticketPrice, String venue,
	                  String sportName, String teams) {
	        super(eventName, date, time, totalSeats, ticketPrice, venue);
	        this.sportName = sportName;
	        this.teams = teams;
	    }

	    @Override
	    public void displayEventDetails() {
	        System.out.println("Sports Event");
	        System.out.println("Name: " + eventName + ", Sport: " + sportName + ", Teams: " + teams);
	        System.out.println("Date: " + date + ", Time: " + time + ", Venue: " + venue);
	        System.out.println("Price: " + ticketPrice + ", Available Seats: " + availableSeats);
	    }
	}



