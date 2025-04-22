package com.hexaware.ticket.task11;

import java.sql.*;

public class EventDAO {

	public void insertEvent(Event event) throws Exception {
	    String sql = "INSERT INTO Event (event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = DBUtil.getDBConn();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, event.getEventName());
	        stmt.setString(2, event.getEventDate());
	        stmt.setString(3, event.getEventTime());
	        
	        // Check if venue is not null before calling getVenueId()
	        if (event.getVenue() != null) {
	            stmt.setInt(4, event.getVenue().getVenueId());
	        } else {
	            throw new IllegalArgumentException("Venue is not provided for the event.");
	        }

	        stmt.setInt(5, event.getTotalSeats());
	        stmt.setInt(6, event.getAvailableSeats());
	        stmt.setDouble(7, event.getTicketPrice());
	        stmt.setString(8, event.getEventType());

	        stmt.executeUpdate();
	    }
	}
}
	
