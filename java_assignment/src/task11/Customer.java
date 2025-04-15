package task11;

public class Customer {
    private String customerName;
    private String email;

  
    public Customer(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
    }

    
    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}