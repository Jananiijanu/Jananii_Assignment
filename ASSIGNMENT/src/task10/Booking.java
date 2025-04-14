package task10;
import java.util.HashMap;
import java.util.Map;

public class Booking {
    private Map<String, Customer> customers;
    private Event event;
    private double totalCost;

    public Booking(Event event) {
        this.event = event;
        this.customers = new HashMap<>();
    }

    public void addCustomer(String email, Customer customer) {
        customers.put(email, customer);
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void calculateTotalCost(int numTickets) {
        this.totalCost = numTickets * event.getTicketPrice();
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Event getEvent() {
        return event;
    }
}