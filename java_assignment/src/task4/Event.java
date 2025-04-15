package task4;
import java.util.Date;

public class Event {

	    private String eventName;
	    private Date eventDate;
	    private String eventTime;
	    private String venueName;
	    private int totalSeats;
	    private int availableSeats;
	    private double ticketPrice;
	    private String eventType;

	    public Event() {}

	    public Event(String eventName, Date eventDate, String eventTime, String venueName, int totalSeats, int availableSeats, double ticketPrice, String eventType) {
	        this.eventName = eventName;
	        this.eventDate = eventDate;
	        this.eventTime = eventTime;
	        this.venueName = venueName;
	        this.totalSeats = totalSeats;
	        this.availableSeats = availableSeats;
	        this.ticketPrice = ticketPrice;
	        this.eventType = eventType;
	    }

	    public String getEventName() {
	        return eventName;
	    }

	    public void setEventName(String eventName) {
	        this.eventName = eventName;
	    }

	    public Date getEventDate() {
	        return eventDate;
	    }

	    public void setEventDate(Date eventDate) {
	        this.eventDate = eventDate;
	    }

	    public String getEventTime() {
	        return eventTime;
	    }

	    public void setEventTime(String eventTime) {
	        this.eventTime = eventTime;
	    }

	    public String getVenueName() {
	        return venueName;
	    }

	    public void setVenueName(String venueName) {
	        this.venueName = venueName;
	    }

	    public int getTotalSeats() {
	        return totalSeats;
	    }

	    public void setTotalSeats(int totalSeats) {
	        this.totalSeats = totalSeats;
	    }

	    public int getAvailableSeats() {
	        return availableSeats;
	    }

	    public void setAvailableSeats(int availableSeats) {
	        this.availableSeats = availableSeats;
	    }

	    public double getTicketPrice() {
	        return ticketPrice;
	    }

	    public void setTicketPrice(double ticketPrice) {
	        this.ticketPrice = ticketPrice;
	    }

	    public String getEventType() {
	        return eventType;
	    }

	    public void setEventType(String eventType) {
	        this.eventType = eventType;
	    }

	    public double calculateTotalRevenue() {
	        return (totalSeats - availableSeats) * ticketPrice;
	    }

	    public int getBookedNoOfTickets() {
	        return totalSeats - availableSeats;
	    }

	    public void bookTickets(int numTickets) {
	        if (availableSeats >= numTickets) {
	            availableSeats -= numTickets;
	            System.out.println(numTickets + " tickets booked successfully.");
	        } else {
	            System.out.println("Not enough available seats.");
	        }
	    }

	    public void cancelBooking(int numTickets) {
	        availableSeats += numTickets;
	        System.out.println(numTickets + " tickets canceled successfully.");
	    }

	    public void displayEventDetails() {
	        System.out.println("Event: " + eventName);
	        System.out.println("Date: " + eventDate);
	        System.out.println("Time: " + eventTime);
	        System.out.println("Venue: " + venueName);
	        System.out.println("Total Seats: " + totalSeats);
	        System.out.println("Available Seats: " + availableSeats);
	    }
	}


