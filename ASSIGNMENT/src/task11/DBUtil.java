package task11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class DBUtil {
	    public static Connection getDBConn() throws SQLException {
	        try {
	            // Register the JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // Create the connection using MySQL database URL
	            return DriverManager.getConnection("jdbc:mysql://localhost:3306/TicketBookingSystem", "root", "Jananii@123");
	        } catch (ClassNotFoundException | SQLException e) {
	            throw new SQLException("Database connection failed.", e);
	        }
	    }
	}


