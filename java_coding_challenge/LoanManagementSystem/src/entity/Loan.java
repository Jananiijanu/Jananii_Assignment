package entity;

public class Loan {
    private int loanId;
    private int customerId;
    private String loanType;
    private double principalAmount;
    private double interestRate;
    private int loanTerm;
    private String loanStatus;
    private String carModel;
    private String homeValue;
    private double emi;

    public Loan(int customerId, String loanType, double principalAmount, double interestRate, 
                int loanTerm, String loanStatus, String carModel, String homeValue, double emi) {
        this.customerId = customerId;
        this.loanType = loanType;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.loanStatus = loanStatus;
        this.carModel = carModel;
        this.homeValue = homeValue;
        this.emi = emi;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getHomeValue() {
        return homeValue;
    }

    public void setHomeValue(String homeValue) {
        this.homeValue = homeValue;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }
}

   