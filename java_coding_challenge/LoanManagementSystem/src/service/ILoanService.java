package service;

import entity.Loan;
import exception.InvalidLoanException;

public interface ILoanService {
    boolean applyLoan(Loan loan);
    double calculateInterest(int loanId) throws InvalidLoanException;
    double calculateEMI(int loanId) throws InvalidLoanException;
    boolean loanStatus(int loanId);
    boolean loanRepayment(int loanId, double amount) throws InvalidLoanException;
    void getAllLoans();
    Loan getLoanById(int loanId) throws InvalidLoanException;
}
