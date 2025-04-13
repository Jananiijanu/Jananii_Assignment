package Main;
import java.util.Scanner;

public class task1 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter available tickets: ");
	        int availableTicket = scanner.nextInt();

	        System.out.print("Enter number of tickets to book: ");
	        int noOfBookingTicket = scanner.nextInt();

	        if (availableTicket >= noOfBookingTicket) {
	            availableTicket -= noOfBookingTicket;
	            System.out.println("Tickets booked successfully!");
	            System.out.println("Remaining tickets: " + availableTicket);
	        } else {
	            System.out.println("Tickets not available. Only " + availableTicket + " tickets left.");
	        }

	        scanner.close();
	    }
	}


