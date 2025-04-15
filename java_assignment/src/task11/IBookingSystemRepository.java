package task11;
public interface IBookingSystemRepository {
    void createEvent(Event event);
    Event getEvent(String eventName);
    void updateAvailableSeats(Event event);
    void bookTickets(Booking booking);
    void cancelBooking(int bookingId);
    Booking getBookingDetails(int bookingId);
}