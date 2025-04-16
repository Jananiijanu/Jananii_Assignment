package dao;

import entity.Loan;

public interface LoanRepository {
    boolean applyLoan(Loan loan);
    Loan getLoanById(int loanId);
}