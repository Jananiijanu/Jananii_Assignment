package task11;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAO {

    public void insertCustomer(Customer customer, int bookingId) throws Exception {
        String sql = "INSERT INTO Customer (customer_name, email, booking_id) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getDBConn();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getEmail());
            stmt.setInt(3, bookingId);
            stmt.executeUpdate();
        }
    }
}