package com.hexaware.ticket.task7;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
	

	public class BookingSystem {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        ArrayList<Event> events = new ArrayList<>();
	        ArrayList<Booking> bookings = new ArrayList<>();

	        while (true) {
	            System.out.println("\n1. Create Event\n2. Book Tickets\n3. Cancel Booking\n4. Get Available Tickets\n5. Get Event Details\n6. Exit");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                    System.out.print("Event Type (movie/sports/concert): ");
	                    String type = sc.nextLine();
	                    System.out.print("Event Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Event Date (yyyy-mm-dd): ");
	                    LocalDate date = LocalDate.parse(sc.nextLine());
	                    System.out.print("Event Time (HH:mm): ");
	                    LocalTime time = LocalTime.parse(sc.nextLine());
	                    System.out.print("Total Seats: ");
	                    int seats = sc.nextInt();
	                    System.out.print("Ticket Price: ");
	                    double price = sc.nextDouble(); sc.nextLine();
	                    System.out.print("Venue Name: ");
	                    String venueName = sc.nextLine();
	                    System.out.print("Venue Address: ");
	                    String address = sc.nextLine();
	                    System.out.print("Parameter 1 (Genre/Artist/Sport Name): ");
	                    String param1 = sc.nextLine();
	                    System.out.print("Parameter 2 (Actor/Concert Type/Team Names): ");
	                    String param2 = sc.nextLine();

	                    Venue venue = new Venue(venueName, address);
	                    Event newEvent = null;

	                    if (type.equalsIgnoreCase("movie")) {
	                        newEvent = new Movie(name, date, time, venue, seats, price, type, param1, param2, "ActressName");
	                    } else if (type.equalsIgnoreCase("sports")) {
	                        newEvent = new Sport(name, date, time, venue, seats, price, type, param1, param2);
	                    } else if (type.equalsIgnoreCase("concert")) {
	                        newEvent = new Concert(name, date, time, venue, seats, price, type, param1, param2);
	                    }

	                    if (newEvent != null) {
	                        events.add(newEvent);
	                        System.out.println("Event created successfully.");
	                    } else {
	                        System.out.println("Invalid event type.");
	                    }
	                    break;

	                case 2:
	                    System.out.print("Enter Event Name to Book Tickets: ");
	                    String bookEventName = sc.nextLine();
	                    Event selectedEvent = null;
	                    for (Event ev : events) {
	                        if (ev.getEventName().equalsIgnoreCase(bookEventName)) {
	                            selectedEvent = ev;
	                            break;
	                        }
	                    }

	                    if (selectedEvent == null) {
	                        System.out.println("Event not found.");
	                        break;
	                    }

	                    System.out.print("Enter Number of Tickets: ");
	                    int ticketCount = sc.nextInt(); sc.nextLine();
	                    if (ticketCount > selectedEvent.getAvailableSeats()) {
	                        System.out.println("Not enough available seats.");
	                        break;
	                    }

	                    Customer[] customers = new Customer[ticketCount];
	                    for (int i = 0; i < ticketCount; i++) {
	                        System.out.println("Enter details for Customer " + (i + 1));
	                        System.out.print("Name: ");
	                        String cname = sc.nextLine();
	                        System.out.print("Email: ");
	                        String email = sc.nextLine();
	                        System.out.print("Phone: ");
	                        String phone = sc.nextLine();
	                        customers[i] = new Customer(cname, email, phone);
	                    }

	                    Booking newBooking = new Booking(customers, selectedEvent, ticketCount);
	                    bookings.add(newBooking);
	                    System.out.println("Booking successful. Booking ID: " + newBooking.getBookingId());
	                    break;

	                case 3:
	                    System.out.print("Enter Booking ID to Cancel: ");
	                    int cancelId = sc.nextInt(); sc.nextLine();
	                    Booking foundBooking = null;
	                    for (Booking b : bookings) {
	                        if (b.getBookingId() == cancelId) {
	                            foundBooking = b;
	                            break;
	                        }
	                    }

	                    if (foundBooking != null) {
	                        foundBooking.getEvent().cancelBooking(foundBooking.getNumTickets());
	                        bookings.remove(foundBooking);
	                        System.out.println("Booking cancelled.");
	                    } else {
	                        System.out.println("Booking ID not found.");
	                    }
	                    break;

	                case 4:
	                    for (Event ev : events) {
	                        System.out.println(ev.getEventName() + ": " + ev.getAvailableSeats() + " seats available.");
	                    }
	                    break;

	                case 5:
	                    for (Event ev : events) {
	                        ev.displayEventDetails();
	                    }
	                    break;

	                case 6:
	                    System.out.println("Exiting...");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	        }
	    }
	}

