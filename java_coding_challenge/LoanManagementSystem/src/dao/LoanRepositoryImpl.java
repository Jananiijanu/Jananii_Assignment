package dao;

import entity.Loan;
import java.sql.*;

public class LoanRepositoryImpl implements LoanRepository {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/loanmanagementsystem";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Jananii@123"; 

    @Override
    public boolean applyLoan(Loan loan) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "INSERT INTO loans (customer_id, loan_type, principal_amount, interest_rate, loan_term, loan_status) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, loan.getCustomerId());
                stmt.setString(2, loan.getLoanType());
                stmt.setDouble(3, loan.getPrincipalAmount());
                stmt.setDouble(4, loan.getInterestRate());
                stmt.setInt(5, loan.getLoanTerm());
                stmt.setString(6, loan.getLoanStatus());
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Loan getLoanById(int loanId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "SELECT * FROM loans WHERE loan_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, loanId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Loan loan = new Loan(
                            rs.getInt("customer_id"),
                            rs.getString("loan_type"),
                            rs.getDouble("principal_amount"),
                            rs.getDouble("interest_rate"),
                            rs.getInt("loan_term"),
                            rs.getString("loan_status"),
                            rs.getString("car_model"),
                            rs.getString("home_value"),
                            rs.getDouble("emi")
                        );
                        loan.setLoanId(rs.getInt("loan_id"));
                        return loan;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}