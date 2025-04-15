package task7;
import java.time.LocalDate;
import java.time.LocalTime;

	public class Concert extends Event {
	    private String artist;
	    private String type;

	    public Concert(String name, LocalDate date, LocalTime time, Venue venue, int seats, double price, String eventType, String artist, String type) {
	        super(name, date, time, venue, seats, price, eventType);
	        this.artist = artist;
	        this.type = type;
	    }

	    public void displayEventDetails() {
	        System.out.println("Concert: " + eventName + ", Artist: " + artist + ", Type: " + type);
	        System.out.println("Date: " + eventDate + " Time: " + eventTime + " Price: " + ticketPrice + " Available: " + availableSeats);
	        venue.displayVenueDetails();
	    }
	}



