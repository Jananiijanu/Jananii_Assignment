package task11;

import java.util.List;

public class Booking {
    private int bookingId;
    private Event event;
    private List<Customer> customers;
    private double totalCost;
    private int numTickets;

    
    public Booking(int bookingId, Event event, List<Customer> customers, double totalCost, int numTickets) {
        this.bookingId = bookingId;
        this.event = event;
        this.customers = customers;
        this.totalCost = totalCost;
        this.numTickets = numTickets;
    }

  
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }
}
