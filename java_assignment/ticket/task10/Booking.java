package com.hexaware.ticket.task10;

import java.util.HashMap;
import java.util.Map;

public class Booking {
    private Event event;
    private Map<String, Customer> customers = new HashMap<>();
    private double totalCost;

    public Booking(Event event) {
        this.event = event;
    }

    public void addCustomer(String email, Customer customer) {
        customers.put(email, customer);
    }

    public void calculateTotalCost(int numTickets) {
        this.totalCost = numTickets * event.getTicketPrice();
        event.bookSeats(numTickets);
    }

    public double getTotalCost() {
        return totalCost;
    }
}
