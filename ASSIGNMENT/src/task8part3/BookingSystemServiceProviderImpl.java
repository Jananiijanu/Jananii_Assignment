package task8part3;


import task8.Customer;
import task8.Event;
import task8part2.IBookingSystemServiceProvider;

public class BookingSystemServiceProviderImpl extends EventServiceProviderImpl implements IBookingSystemServiceProvider {
    public static int bookingCounter = 1000;

    public double calculateBookingCost(int tickets, double price) {
        return tickets * price;
    }

    public void bookTickets(String eventName, int count, Customer[] customers) {
        for (Event e : events) {
            if (e != null && e.getEventName().equalsIgnoreCase(eventName)) {
                if (e.getAvailableSeats() >= count) {
                    e.bookSeats(count);
                    System.out.println("Booking ID: B" + bookingCounter++);
                    System.out.println("Booking Successful! Cost: ₹" + calculateBookingCost(count, e.getTicketPrice()));
                } else {
                    System.out.println("Not enough seats available.");
                }
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public void cancelBooking(String bookingId) {
        System.out.println("Cancelled Booking ID: " + bookingId);
    }

    public void getBookingDetails(String bookingId) {
        System.out.println("Booking details for: " + bookingId);
    }
}


