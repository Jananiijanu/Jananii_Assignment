package task11;
import task11part2.BookingSystemServiceProviderImpl;

import java.util.*;

public class TicketBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingSystemServiceProviderImpl system = new BookingSystemServiceProviderImpl();

        while (true) {
            System.out.println("\n1. Create Event\n2. Book Tickets\n3. Cancel Booking\n4. View Booking\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Event name: ");
                        String name = sc.nextLine();
                        System.out.print("Date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        System.out.print("Time (HH:MM): ");
                        String time = sc.nextLine();
                        System.out.print("Total seats: ");
                        int seats = sc.nextInt();
                        System.out.print("Ticket price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Type (Movie/Sports/Concert): ");
                        String type = sc.nextLine();
                        System.out.print("Venue name: ");
                        String vName = sc.nextLine();
                        System.out.print("Venue location: ");
                        String vLoc = sc.nextLine();

                        Venue venue = new Venue(vName, vLoc);
                        system.createEvent(name, date, time, seats, price, type, venue);
                        break;

                    case 2:
                        System.out.print("Event name: ");
                        String evName = sc.nextLine();
                        System.out.print("Number of tickets: ");
                        int count = sc.nextInt();
                        sc.nextLine();

                        List<Customer> customers = new ArrayList<>();
                        for (int i = 0; i < count; i++) {
                            System.out.print("Customer name: ");
                            String cname = sc.nextLine();
                            System.out.print("Customer email: ");
                            String cemail = sc.nextLine();
                            customers.add(new Customer(cname, cemail));
                        }

                        system.bookTickets(evName, count, customers);
                        break;

                    case 3:
                        System.out.print("Enter booking ID: ");
                        int bid = sc.nextInt();
                        system.cancelBooking(bid);
                        break;

                    case 4:
                        System.out.print("Enter booking ID: ");
                        int bview = sc.nextInt();
                        system.getBookingDetails(bview);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}