package task11;

import java.sql.*;

public class BookingSystemRepositoryImpl implements IBookingSystemRepository {

    @Override
    public void createEvent(Event event) {
        String query = "INSERT INTO events (event_name, event_date, event_time, total_seats, available_seats, ticket_price, event_type, venue_name, venue_location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getDBConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, event.eventName);
            stmt.setString(2, event.eventDate);
            stmt.setString(3, event.eventTime);
            stmt.setInt(4, event.totalSeats);
            stmt.setInt(5, event.availableSeats);
            stmt.setDouble(6, event.ticketPrice);
            stmt.setString(7, event.eventType);
            stmt.setString(8, event.venue.getVenueName());
            stmt.setString(9, event.venue.getLocation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Event getEvent(String eventName) {
        String query = "SELECT * FROM events WHERE event_name = ?";
        try (Connection conn = DBUtil.getDBConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, eventName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Event(rs.getString("event_name"), rs.getString("event_date"), rs.getString("event_time"), rs.getInt("total_seats"), rs.getDouble("ticket_price"), rs.getString("event_type"), new Venue(rs.getString("venue_name"), rs.getString("venue_location")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAvailableSeats(Event event) {
        String query = "UPDATE events SET available_seats = ? WHERE event_name = ?";
        try (Connection conn = DBUtil.getDBConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, event.getAvailableSeats());
            stmt.setString(2, event.eventName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bookTickets(Booking booking) {
        // Booking logic can be implemented here
    }

    @Override
    public void cancelBooking(int bookingId) {
        // Cancel logic can be implemented here
    }

    @Override
    public Booking getBookingDetails(int bookingId) {
        // Fetch booking details logic here
        return null;
    }
}