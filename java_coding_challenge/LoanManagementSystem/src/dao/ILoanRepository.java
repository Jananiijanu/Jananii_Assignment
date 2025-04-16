package dao;

import entity.Loan;
import exception.InvalidLoanException;
import java.util.List;

public interface ILoanRepository {
    boolean applyLoan(Loan loan);
    Loan getLoanById(int loanId);
    double calculateEMI(int loanId);
}