package task8part2;
import task8.Customer;
	public interface IBookingSystemServiceProvider {
	    double calculateBookingCost(int tickets, double price);
	    void bookTickets(String eventName, int count, Customer[] customers);
	    void cancelBooking(String bookingId);
	    void getBookingDetails(String bookingId);
	}
