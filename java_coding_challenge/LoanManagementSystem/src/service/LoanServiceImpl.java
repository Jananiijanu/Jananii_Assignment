package service;

import dao.LoanRepository;
import entity.Loan;

public class LoanServiceImpl implements LoanService {
    private LoanRepository loanRepository;

   
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public boolean applyLoan(Loan loan) {
        return loanRepository.applyLoan(loan);
    }

    @Override
    public Loan getLoanById(int loanId) {
        return loanRepository.getLoanById(loanId);
    }
}