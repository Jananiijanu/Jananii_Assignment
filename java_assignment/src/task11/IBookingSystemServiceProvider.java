package task11;

import java.util.List;

public interface IBookingSystemServiceProvider {
    double calculateBookingCost(int numTickets, double price);
    void bookTickets(String eventName, int numTickets, List<Customer> customers) throws Exception;
    void cancelBooking(int bookingId) throws Exception;
    void getBookingDetails(int bookingId) throws Exception;
}