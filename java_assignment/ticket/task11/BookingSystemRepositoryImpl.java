package com.hexaware.ticket.task11;

import java.sql.*;

public class BookingSystemRepositoryImpl implements IBookingSystemRepository {

    @Override
    public void createEvent(Event event) {
        String query = "INSERT INTO events (event_id, event_name, event_date, event_time, total_seats, available_seats, ticket_price, event_type, venue_name, venue_location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getDBConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, event.getEventId());
            stmt.setString(2, event.getEventName());
            stmt.setString(3, event.getEventDate());
            stmt.setString(4, event.getEventTime());
            stmt.setInt(5, event.getTotalSeats());
            stmt.setInt(6, event.getAvailableSeats());
            stmt.setDouble(7, event.getTicketPrice());
            stmt.setString(8, event.getEventType());
            stmt.setString(9, event.getVenue().getVenueName());
            stmt.setString(10, event.getVenue().getLocation());

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
                return new Event(
                    rs.getInt("event_id"),
                    rs.getString("event_name"),
                    rs.getString("event_date"),
                    rs.getString("event_time"),
                    rs.getInt("total_seats"),
                    rs.getInt("available_seats"),
                    rs.getDouble("ticket_price"),
                    rs.getString("event_type"),
                    new Venue(
                        rs.getString("venue_name"),
                        rs.getString("venue_location")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAvailableSeats(Event event) {
        String query = "UPDATE events SET available_seats = ? WHERE event_id = ?";
        try (Connection conn = DBUtil.getDBConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, event.getAvailableSeats());
            stmt.setInt(2, event.getEventId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bookTickets(Booking booking) {
        String query = "INSERT INTO bookings (booking_id, customer_id, event_id, num_tickets, total_amount) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getDBConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, booking.getBookingId());
            stmt.setInt(2, booking.getCustomerId());
            stmt.setInt(3, booking.getEvent().getEventId());
            stmt.setInt(4, booking.getNumTickets());
            stmt.setDouble(5, booking.getTotalAmount());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelBooking(int bookingId) {
        String query = "DELETE FROM bookings WHERE booking_id = ?";
        try (Connection conn = DBUtil.getDBConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Booking getBookingDetails(int bookingId) {
        String query = "SELECT b.*, e.*, v.venue_name, v.venue_location FROM bookings b " +
                       "JOIN events e ON b.event_id = e.event_id " +
                       "JOIN venue v ON e.venue_name = v.venue_name AND e.venue_location = v.venue_location " +
                       "WHERE b.booking_id = ?";
        try (Connection conn = DBUtil.getDBConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Event event = new Event(
                    rs.getInt("event_id"),
                    rs.getString("event_name"),
                    rs.getString("event_date"),
                    rs.getString("event_time"),
                    rs.getInt("total_seats"),
                    rs.getInt("available_seats"),
                    rs.getDouble("ticket_price"),
                    rs.getString("event_type"),
                    new Venue(
                        rs.getString("venue_name"),
                        rs.getString("venue_location")
                    )
                );
                return new Booking(
                    rs.getInt("booking_id"),
                    rs.getInt("customer_id"),
                    event,
                    rs.getInt("num_tickets"),
                    rs.getDouble("total_amount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
