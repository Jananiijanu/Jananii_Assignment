package task9;
import java.util.ArrayList;

public class BookingSystem {
    private static int idCounter = 1000;
    private int bookingId;
    private Event event;
    private ArrayList<Customer> customers;
    private double totalCost;

    public BookingSystem(Event event, ArrayList<Customer> customers, double cost) {
        this.bookingId = idCounter++;
        this.event = event;
        this.customers = customers;
        this.totalCost = cost;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Event getEvent() {
        return event;
    }

    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingId);
        event.displayEventDetails();
        System.out.println("Total Cost: ₹" + totalCost);
        for (Customer c : customers) {
            c.displayCustomerDetails();
        }
    }

    public int getNumTickets() {
        return customers.size();
    }
}
