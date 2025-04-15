package task7;
import java.time.LocalDate;
import java.time.LocalTime;

	public abstract class Event {
	    protected String eventName;
	    protected LocalDate eventDate;
	    protected LocalTime eventTime;
	    protected Venue venue;
	    protected int totalSeats;
	    protected int availableSeats;
	    protected double ticketPrice;
	    protected String eventType;

	    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue, int totalSeats, double ticketPrice, String eventType) {
	        this.eventName = eventName;
	        this.eventDate = eventDate;
	        this.eventTime = eventTime;
	        this.venue = venue;
	        this.totalSeats = totalSeats;
	        this.availableSeats = totalSeats;
	        this.ticketPrice = ticketPrice;
	        this.eventType = eventType;
	    }

	    public int getAvailableSeats() {
	        return availableSeats;
	    }

	    public String getEventName() {
	        return eventName;
	    }

	    public void bookTickets(int num) {
	        if (availableSeats >= num) {
	            availableSeats -= num;
	        }
	    }

	    public void cancelBooking(int num) {
	        availableSeats += num;
	    }

	    public double calculateTotalRevenue() {
	        return (totalSeats - availableSeats) * ticketPrice;
	    }

	    public int getBookedNoOfTickets() {
	        return totalSeats - availableSeats;
	    }

	    public abstract void displayEventDetails();
	}



