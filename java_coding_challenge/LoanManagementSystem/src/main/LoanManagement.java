import dao.LoanRepository;
import dao.LoanRepositoryImpl;
import entity.Loan;
import service.LoanService;
import service.LoanServiceImpl;

import java.util.Scanner;

public class LoanManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        LoanRepository loanRepository = new LoanRepositoryImpl();
        LoanService loanService = new LoanServiceImpl(loanRepository); 

        while (true) {
            System.out.println("Loan Management System");
            System.out.println("1. Apply for Loan");
            System.out.println("2. Get Loan by ID");
            System.out.println("3. Calculate EMI");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter Loan Type (HomeLoan/CarLoan):");
                String loanType = scanner.nextLine();
                System.out.println("Enter Principal Amount:");
                double principalAmount = scanner.nextDouble();
                System.out.println("Enter Interest Rate:");
                double interestRate = scanner.nextDouble();
                System.out.println("Enter Loan Term (months):");
                int loanTerm = scanner.nextInt();
                scanner.nextLine(); 

                
                int customerId = 1;  

                Loan loan = new Loan(customerId, loanType, principalAmount, interestRate, loanTerm, "Pending", "", "", 0.0);

                boolean loanApplied = loanService.applyLoan(loan);
                if (loanApplied) {
                    System.out.println("Loan applied successfully!");
                } else {
                    System.out.println("Loan application failed.");
                }
            } else if (choice == 2) {
                System.out.print("Enter Loan ID: ");
                int loanId = scanner.nextInt();
                Loan loan = loanService.getLoanById(loanId);
                if (loan != null) {
                    System.out.println("Loan ID: " + loan.getLoanId());
                    System.out.println("Customer ID: " + loan.getCustomerId());
                    System.out.println("Loan Type: " + loan.getLoanType());
                    System.out.println("Principal Amount: " + loan.getPrincipalAmount());
                    System.out.println("Interest Rate: " + loan.getInterestRate());
                    System.out.println("Loan Term: " + loan.getLoanTerm());
                    System.out.println("Loan Status: " + loan.getLoanStatus());
                    
                } else {
                    System.out.println("Loan not found.");
                }
            } else if (choice == 3) {
              
            } else if (choice == 4) {
                break;
            }
        }
        scanner.close();
    }
}