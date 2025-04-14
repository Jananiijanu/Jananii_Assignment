package task11part2;

import task11.*;
import java.util.*;

public class BookingSystemServiceProviderImpl implements IEventServiceProvider, IBookingSystemServiceProvider {

    private List<Event> events = new ArrayList<>();
    private Map<Integer, Booking> bookings = new HashMap<>();
    private int bookingIdCounter = 1;

    @Override
    public Event createEvent(String name, String date, String time, int seats, double price, String type, Venue venue) {
        Event event = new Event(name, date, time, seats, price, type, venue);
        events.add(event);
        return event;
    }

    @Override
    public List<Event> getEventDetails() {
        return events;
    }

    @Override
    public int getAvailableSeats(String eventName) {
        for (Event e : events) {
            if (e.getEventName().equalsIgnoreCase(eventName)) {
                return e.getTotalSeats();
            }
        }
        return 0;
    }

    @Override
    public double calculateBookingCost(int numTickets, double price) {
        return numTickets * price;
    }

    @Override
    public void bookTickets(String eventName, int numTickets, List<Customer> customers) throws Exception {
        Event eventToBook = null;
        for (Event e : events) {
            if (e.getEventName().equalsIgnoreCase(eventName)) {
                eventToBook = e;
                break;
            }
        }

        if (eventToBook == null) {
            throw new Exception("Event not found.");
        }

        double totalCost = calculateBookingCost(numTickets, eventToBook.getTicketPrice());
        Booking booking = new Booking(bookingIdCounter++, eventToBook, customers, totalCost);
        bookings.put(booking.getBookingId(), booking);

        // Decrease the available seats
        eventToBook.bookSeats(numTickets);

        System.out.println("Booking successful. Booking ID: " + booking.getBookingId());
    }

    @Override
    public void cancelBooking(int bookingId) throws Exception {
        if (bookings.containsKey(bookingId)) {
            Booking booking = bookings.get(bookingId);
            Event event = booking.getEvent();
            event.cancelSeats(booking.getNumTickets());  // Assuming this method exists in Event
            bookings.remove(bookingId);
            System.out.println("Booking cancelled.");
        } else {
            throw new Exception("Invalid Booking ID.");
        }
    }

    @Override
    public void getBookingDetails(int bookingId) throws Exception {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Event: " + booking.getEvent().getEventName());
            System.out.println("Total Cost: ₹" + booking.getTotalCost());
        } else {
            throw new Exception("Booking not found.");
        }
    }
}