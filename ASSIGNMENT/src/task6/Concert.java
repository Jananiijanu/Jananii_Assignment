package task6;

	public class Concert extends Event {
	    private String artist, type;

	    public Concert(String eventName, String date, String time, int totalSeats, double ticketPrice, String venue,
	                   String artist, String type) {
	        super(eventName, date, time, totalSeats, ticketPrice, venue);
	        this.artist = artist;
	        this.type = type;
	    }

	    @Override
	    public void displayEventDetails() {
	        System.out.println("Concert Event");
	        System.out.println("Name: " + eventName + ", Artist: " + artist + ", Type: " + type);
	        System.out.println("Date: " + date + ", Time: " + time + ", Venue: " + venue);
	        System.out.println("Price: " + ticketPrice + ", Available Seats: " + availableSeats);
	    }
	}


