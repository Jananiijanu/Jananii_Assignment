package task11;



	import java.sql.Connection;
	import java.sql.PreparedStatement;

	public class EventDAO {
	    public void insertEvent(Event event) throws Exception {
	        String sql = "INSERT INTO Event (event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	        try (Connection conn = DBUtil.getDBConn();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, event.getEventName());
	            stmt.setString(2, event.getDate());
	            stmt.setString(3, event.getTime());
	            stmt.setInt(4, event.getVenue().getVenueId()); 
	            stmt.setInt(5, event.getTotalSeats());
	            stmt.setInt(6, event.getAvailableSeats());
	            stmt.setDouble(7, event.getTicketPrice());
	            stmt.setString(8, event.getEventType());

	            stmt.executeUpdate();
	        }
	    }
	}

