package task5;
import java.util.Scanner;

public class mainmethod {
	public Event createEvent(String eventType, Scanner sc) {
	        System.out.print("Enter Event Name: ");
	        String name = sc.next();
	        System.out.print("Enter Date: ");
	        String date = sc.next();
	        System.out.print("Enter Time: ");
	        String time = sc.next();
	        System.out.print("Enter Total Seats: ");
	        int seats = sc.nextInt();
	        System.out.print("Enter Ticket Price: ");
	        double price = sc.nextDouble();
	        System.out.print("Enter Venue: ");
	        String venue = sc.next();

	        switch (eventType.toLowerCase()) {
	            case "movie":
	                System.out.print("Enter Genre: ");
	                String genre = sc.next();
	                System.out.print("Enter Actor Name: ");
	                String actor = sc.next();
	                System.out.print("Enter Actress Name: ");
	                String actress = sc.next();
	                return new Movie(name, date, time, seats, price, venue, genre, actor, actress);
	            case "concert":
	                System.out.print("Enter Artist: ");
	                String artist = sc.next();
	                System.out.print("Enter Type (Theatrical/Classical/Rock/Recital): ");
	                String type = sc.next();
	                return new Concert(name, date, time, seats, price, venue, artist, type);
	            case "sports":
	                System.out.print("Enter Sport Name: ");
	                String sport = sc.next();
	                System.out.print("Enter Teams (e.g., India vs Pakistan): ");
	                String teams = sc.next();
	                return new Sports(name, date, time, seats, price, venue, sport, teams);
	            default:
	                return null;
	        }
	    }

	    public void displayEventDetails(Event event) {
	        if (event != null) {
	            event.displayEventDetails();  
	        }
	    }

	    public double bookTickets(Event event, int numTickets) {
	        if (event.availableSeats >= numTickets) {
	            event.availableSeats -= numTickets;
	            return numTickets * event.ticketPrice;
	        } else {
	            System.out.println("Not enough seats available.");
	            return 0.0;
	        }
	    }

	    public void cancelTickets(Event event, int numTickets) {
	        event.availableSeats += numTickets;
	        System.out.println(numTickets + " ticket(s) cancelled.");
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        mainmethod system = new mainmethod();
	        Event event = null;
	        while (true) {
	            System.out.println("\n--- Ticket Booking System ---");
	            System.out.println("1. Create Event");
	            System.out.println("2. Display Event Details");
	            System.out.println("3. Book Tickets");
	            System.out.println("4. Cancel Tickets");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int ch = sc.nextInt();

	            switch (ch) {
	                case 1:
	                    System.out.print("Enter Event Type (movie/sports/concert): ");
	                    String type = sc.next();
	                    event = system.createEvent(type, sc);
	                    break;
	                case 2:
	                    if (event != null) {
	                        system.displayEventDetails(event);
	                    } else {
	                        System.out.println("No event created yet.");
	                    }
	                    break;
	                case 3:
	                    if (event != null) {
	                        System.out.print("Enter number of tickets to book: ");
	                        int bookCount = sc.nextInt();
	                        double cost = system.bookTickets(event, bookCount);
	                        if (cost > 0)
	                            System.out.println("Total Cost: " + cost);
	                    } else {
	                        System.out.println("No event created yet.");
	                    }
	                    break;
	                case 4:
	                    if (event != null) {
	                        System.out.print("Enter number of tickets to cancel: ");
	                        int cancelCount = sc.nextInt();
	                        system.cancelTickets(event, cancelCount);
	                    } else {
	                        System.out.println("No event created yet.");
	                    }
	                    break;
	                case 5:
	                    System.out.println("Thank you for using the system!");
	                    return;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	    }
	}




