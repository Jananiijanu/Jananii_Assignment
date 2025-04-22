package com.hexaware.ticket.task11;

import java.sql.*;
import java.time.LocalDate;

public class BookingDAO {

    // Method to insert a new booking into the database
    public int insertBooking(Booking booking) throws Exception {
        String sql = "INSERT INTO Booking (customer_id, event_id, num_tickets, total_cost, booking_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getDBConn();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            Event event = booking.getEvent();  // Get the event related to the booking

            // Set the parameters for the PreparedStatement
            stmt.setInt(1, booking.getCustomerId());  // Assuming customer_id is set to the customerId in booking
            stmt.setInt(2, event.getEventId());  // Get event ID from the event object
            stmt.setInt(3, booking.getNumTickets());  // Number of tickets to be booked
            stmt.setDouble(4, booking.getTotalAmount());  // Total cost of the booking
            stmt.setDate(5, Date.valueOf(LocalDate.now()));  // Booking date as the current date

            // Execute the query
            stmt.executeUpdate();

            // Get the generated booking ID and set it in the booking object
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                booking.setBookingId(rs.getInt(1));  // Set the generated booking ID
                return rs.getInt(1);  // Return the generated booking ID
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle SQL exception
        }
        return -1;  // Return -1 if the insertion failed
    }
}