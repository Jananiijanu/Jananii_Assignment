package task7;
import java.time.LocalDateTime;

	public class Booking {
	    private static int counter = 1;
	    private int bookingId;
	    private Customer[] customers;
	    private Event event;
	    private int numTickets;
	    private double totalCost;
	    private LocalDateTime bookingDate;

	    public Booking(Customer[] customers, Event event, int numTickets) {
	        this.bookingId = counter++;
	        this.customers = customers;
	        this.event = event;
	        this.numTickets = numTickets;
	        this.totalCost = numTickets * event.ticketPrice;
	        this.bookingDate = LocalDateTime.now();
	        event.bookTickets(numTickets);
	    }

	    public int getBookingId() {
	        return bookingId;
	    }

	    public int getNumTickets() {
	        return numTickets;
	    }

	    public Event getEvent() {
	        return event;
	    }

	    public void displayBookingDetails() {
	        System.out.println("Booking ID: " + bookingId + ", Tickets: " + numTickets + ", Total: " + totalCost + ", Date: " + bookingDate);
	        for (Customer c : customers) {
	            c.displayCustomerDetails();
	        }
	    }
	}


