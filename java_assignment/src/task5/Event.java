package task5;

	public class Event {
	    protected String eventName, date, time, venueName;
	    protected int totalSeats, availableSeats;
	    protected double ticketPrice;

	    public Event() {}

	    public Event(String eventName, String date, String time, int totalSeats, double ticketPrice, String venueName) {
	        this.eventName = eventName;
	        this.date = date;
	        this.time = time;
	        this.totalSeats = totalSeats;
	        this.availableSeats = totalSeats;
	        this.ticketPrice = ticketPrice;
	        this.venueName = venueName;
	    }

	    public void displayEventDetails() {
	        System.out.println("Event Name: " + eventName);
	        System.out.println("Date: " + date);
	        System.out.println("Time: " + time);
	        System.out.println("Venue: " + venueName);
	        System.out.println("Ticket Price: " + ticketPrice);
	        System.out.println("Available Seats: " + availableSeats);
	    }
	}
	
	
	


