package com.hexaware.ticket.task11;

import java.sql.*;

public class VenueDAO {

    public int insertVenue(Venue venue) {
        String sql = "INSERT INTO Venue (name, address) VALUES (?, ?)";
        try (Connection conn = DBUtil.getDBConn();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, venue.getVenueName());
            stmt.setString(2, venue.getAddress());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    venue.setVenueId(rs.getInt(1));
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Logging the error for troubleshooting
        }
        return -1;
    }
}

