package task11;
import java.util.ArrayList;
import java.util.List;

public class Booking {
	private int bookingId;
    private List<Customer> customers;
    private Event event;
    private double totalCost;

    public Booking(int bookingId, Event event, List<Customer> customers, double totalCost) {
        this.bookingId = bookingId;
        this.event = event;
        this.customers = customers;
        this.totalCost = totalCost;
    }
    public int getBookingId() {
        return bookingId;
    }
    public Booking(Event event) {
        this.event = event;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public double calculateBookingCost(int numTickets) {
        this.totalCost = numTickets * event.ticketPrice;
        return totalCost;
    }
    

    public void displayBookingDetails() {
        System.out.println("Event: " + event.eventName);
        System.out.println("Total Cost: ₹" + totalCost);
        System.out.println("Booking for " + customers.size() + " customers.");
    }
    public Event getEvent() {
        return event;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public int getNumTickets() {
        return customers.size();
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    }

