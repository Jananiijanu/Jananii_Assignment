package service;

import entity.Loan;

public interface LoanService {
    boolean applyLoan(Loan loan);
    Loan getLoanById(int loanId);
    double calculateEMI(double loanAmount, double interestRate, int loanTerm);
}
