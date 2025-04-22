package com.hexaware.ticket.Main;
import java.util.Scanner;

public class task2 {
	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        
	        System.out.println("Choose your ticket type: ");
	        System.out.println("1. Silver");
	        System.out.println("2. Gold");
	        System.out.println("3. Diamond");

	        
	        System.out.print("Enter your choice (1/2/3): ");
	        int ticketType = scanner.nextInt();

	        
	        System.out.print("Enter the number of tickets: ");
	        int noOfTickets = scanner.nextInt();

	        
	        double basePrice = 0.0;
	        String ticketCategory = "";

	        
	        if (ticketType == 1) {
	            ticketCategory = "Silver";
	            basePrice = 100.0; 
	        } else if (ticketType == 2) {
	            ticketCategory = "Gold";
	            basePrice = 200.0;
	        } else if (ticketType == 3) {
	            ticketCategory = "Diamond";
	            basePrice = 500.0; 
	        } else {
	            System.out.println("Invalid ticket type!");
	            return;
	        }

	        
	        double totalCost = basePrice * noOfTickets;

	        
	        System.out.println("You have chosen " + ticketCategory + " tickets.");
	        System.out.println("Total cost for " + noOfTickets + " " + ticketCategory + " tickets: " + totalCost);

	        scanner.close();
	    }
	}


