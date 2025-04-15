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

        
        try {
            VenueDAO vdao = new VenueDAO();
            int venueId = vdao.insertVenue(venue);
            venue.setVenueId(venueId);  

            EventDAO edao = new EventDAO();
            edao.insertEvent(event);  
        } catch (Exception e) {
            System.out.println("Failed to save to DB: " + e.getMessage());
        }

        return event;
    }

    @Override
    public List<Event> getEventDetails() {
        return new ArrayList<>(events);
    }

    @Override
    public int getAvailableSeats(String eventName) {
        for (Event e : events) {
            if (e.getEventName().equalsIgnoreCase(eventName)) {
                return e.getAvailableSeats();
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

        if (numTickets > eventToBook.getAvailableSeats()) {
            throw new Exception("Not enough available seats.");
        }

        double totalCost = calculateBookingCost(numTickets, eventToBook.getTicketPrice());
        Booking booking = new Booking(bookingIdCounter++, eventToBook, customers, totalCost, numTickets);

        
        BookingDAO bdao = new BookingDAO();
        int bookingId = bdao.insertBooking(booking); 
        booking.setBookingId(bookingId);

        
        CustomerDAO cdao = new CustomerDAO();
        for (Customer c : customers) {
            cdao.insertCustomer(c, bookingId);  
        }

        eventToBook.bookSeats(numTickets);
        bookings.put(bookingId, booking);

        System.out.println("Booking successful. Booking ID: " + bookingId);
    }

    @Override
    public void cancelBooking(int bookingId) throws Exception {
        if (bookings.containsKey(bookingId)) {
            Booking booking = bookings.get(bookingId);
            Event event = booking.getEvent();
            event.cancelSeats(booking.getNumTickets());
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
            System.out.println("Tickets Booked: " + booking.getNumTickets());
            System.out.println("Total Cost: ₹" + booking.getTotalCost());
        } else {
            throw new Exception("Booking not found.");
        }
    }
}