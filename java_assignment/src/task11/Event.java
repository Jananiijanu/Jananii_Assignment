package task11;


public class Event {
    private String eventName;
    private String eventDate;
    private String eventTime;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private String eventType;
    private Venue venue;
    private int EventId;

    public Event(String eventName, String date, String time, int totalSeats, double ticketPrice, String eventType, Venue venue) {
        this.eventName = eventName;
        this.eventDate = date;
        this.eventTime = time;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
        this.venue = venue;
    }

    
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void bookSeats(int count) {
        if (availableSeats >= count) {
            availableSeats -= count;
        }
    }

    public void cancelSeats(int count) {
        availableSeats += count;
        if (availableSeats > totalSeats) {
            availableSeats = totalSeats;
        }
    }
    public String getEventName() { return eventName; }
    public String getDate() { return eventDate; }
    public String getTime() { return eventTime; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }
    public double getTicketPrice() { return ticketPrice; }
    public String getEventType() { return eventType; }
    public Venue getVenue() { return venue; }
    public int getEventId() {return EventId;}
}
