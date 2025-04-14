package task9;

public class Customer {
    private String customerName, email, phone;

    public Customer(String name, String email, String phone) {
        this.customerName = name;
        this.email = email;
        this.phone = phone;
    }

    public void displayCustomerDetails() {
        System.out.println("Name: " + customerName + ", Email: " + email + ", Phone: " + phone);
    }
}
