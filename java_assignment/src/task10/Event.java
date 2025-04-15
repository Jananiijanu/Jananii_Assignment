package task10;

public class Event {
    protected String eventName;
    protected String eventDate;
    protected String eventTime;
    protected Venue venue;
    protected int totalSeats;
    protected int availableSeats;
    protected double ticketPrice;
    protected String eventType;

    public Event(String eventName, String eventDate, String eventTime, int totalSeats, double ticketPrice, String eventType, Venue venue) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
        this.venue = venue;
    }

    public void displayEventDetails() {
        System.out.println("Event: " + eventName + ", Type: " + eventType);
        System.out.println("Date: " + eventDate + ", Time: " + eventTime);
        System.out.println("Available Seats: " + availableSeats + "/" + totalSeats);
        System.out.println("Price: ₹" + ticketPrice);
        venue.displayVenueDetails();
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getEventName() {
        return eventName;
    }

    public Venue getVenue() {
        return venue;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int count) {
        availableSeats -= count;
    }

    public void cancelSeats(int count) {
        availableSeats += count;
    }
}