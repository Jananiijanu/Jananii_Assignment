package task8part4;


	import java.util.Scanner;
	import task8.*;
	import task8part3.BookingSystemServiceProviderImpl;
	import task8.Customer;

	public class TicketBookingSystem {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        BookingSystemServiceProviderImpl service = new BookingSystemServiceProviderImpl();

	        while (true) {
	            System.out.println("1. Create Event\n2. Book Tickets\n3. Cancel Tickets\n4. View Event Details\n5. Exit");
	            int ch = sc.nextInt();
	            sc.nextLine();
	            switch (ch) {
	                case 1:
	                    System.out.print("Enter event name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Date (yyyy-mm-dd): ");
	                    String date = sc.nextLine();
	                    System.out.print("Time (hh:mm): ");
	                    String time = sc.nextLine();
	                    System.out.print("Total seats: ");
	                    int seats = sc.nextInt();
	                    System.out.print("Ticket price: ");
	                    double price = sc.nextDouble();
	                    sc.nextLine();
	                    System.out.print("Event type (Movie/Sports/Concert): ");
	                    String type = sc.nextLine();
	                    System.out.print("Venue name: ");
	                    String vname = sc.nextLine();
	                    System.out.print("Venue address: ");
	                    String vaddr = sc.nextLine();

	                    Venue v = new Venue(vname, vaddr);
	                    service.createEvent(name, date, time, seats, price, type, v);
	                    System.out.println("Event created successfully.");
	                    break;

	                case 2:
	                    System.out.print("Enter event name: ");
	                    String eName = sc.nextLine();
	                    System.out.print("Number of tickets: ");
	                    int count = sc.nextInt();
	                    Customer[] customers = new Customer[count];
	                    sc.nextLine();
	                    for (int i = 0; i < count; i++) {
	                        System.out.print("Customer name: ");
	                        String cname = sc.nextLine();
	                        System.out.print("Email: ");
	                        String email = sc.nextLine();
	                        System.out.print("Phone: ");
	                        String phone = sc.nextLine();
	                        customers[i] = new Customer(cname, email, phone);
	                    }
	                    service.bookTickets(eName, count, customers);
	                    break;

	                case 3:
	                    System.out.print("Enter booking ID to cancel: ");
	                    String bid = sc.nextLine();
	                    service.cancelBooking(bid);
	                    break;

	                case 4:
	                    Event[] events = service.getEventDetails();
	                    for (Event e : events) {
	                        if (e != null) e.displayEventDetails();
	                    }
	                    break;

	                case 5:
	                    System.out.println("Thank you!");
	                    return;
	           
	    }
	            sc.close();
	}
	    }
	}
	
	





