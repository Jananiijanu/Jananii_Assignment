package task11;

import java.sql.*;
import java.time.LocalDate;

public class BookingDAO {

    public int insertBooking(Booking booking) throws Exception {
        String sql = "INSERT INTO Booking (customer_id, event_id, num_tickets, total_cost, booking_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getDBConn();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            Event event = booking.getEvent();
            stmt.setInt(1, 0); 
            stmt.setInt(2, event.getEventId());
            stmt.setInt(3, booking.getNumTickets());
            stmt.setDouble(4, booking.getTotalCost());
            stmt.setDate(5, Date.valueOf(LocalDate.now()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                booking.setBookingId(rs.getInt(1));
                return rs.getInt(1);
            }
        }
        return -1;
    }
}
