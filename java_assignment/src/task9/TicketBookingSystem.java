package task9;
import java.util.*;

public class TicketBookingSystem {
    static List<Event> events = new ArrayList<>();
    static Map<Integer, BookingSystem> bookings = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n1. Create Event\n2. Book Tickets\n3. Cancel Booking\n4. View Booking\n5. Exit");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter event name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter date (dd-mm-yyyy): ");
                        String date = sc.nextLine();
                        System.out.print("Enter time (hh:mm): ");
                        String time = sc.nextLine();
                        System.out.print("Enter total seats: ");
                        int seats = sc.nextInt();
                        System.out.print("Enter price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter type (Movie/Sports/Concert): ");
                        String type = sc.nextLine();
                        System.out.print("Enter venue name: ");
                        String vname = sc.nextLine();
                        System.out.print("Enter venue address: ");
                        String vaddr = sc.nextLine();

                        Venue v = new Venue(vname, vaddr);
                        Event e = new Event(name, date, time, seats, price, type, v);
                        events.add(e);
                        System.out.println("Event created successfully!");
                        break;

                    case 2:
                        System.out.print("Enter event name to book: ");
                        String ename = sc.nextLine();
                        Event bookEvent = findEvent(ename);
                        if (bookEvent == null) throw new EventNotFoundException("Event not found!");

                        System.out.print("How many tickets? ");
                        int count = sc.nextInt();
                        sc.nextLine();

                        if (bookEvent.getAvailableSeats() < count) {
                            System.out.println("Not enough seats available.");
                            break;
                        }

                        ArrayList<Customer> customers = new ArrayList<>();
                        for (int i = 0; i < count; i++) {
                            System.out.print("Enter customer name: ");
                            String cname = sc.nextLine();
                            System.out.print("Enter email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter phone: ");
                            String phone = sc.nextLine();
                            customers.add(new Customer(cname, email, phone));
                        }

                        double total = count * bookEvent.getTicketPrice();
                        bookEvent.bookSeats(count);
                        BookingSystem booking = new BookingSystem(bookEvent, customers, total);
                        bookings.put(booking.getBookingId(), booking);
                        System.out.println("Booking successful! ID: " + booking.getBookingId());
                        break;

                    case 3:
                        System.out.print("Enter booking ID to cancel: ");
                        int bid = sc.nextInt();
                        BookingSystem cancel = bookings.get(bid);
                        if (cancel == null) throw new InvalidBookingIDException("Booking ID invalid!");

                        Event ev = cancel.getEvent();
                        ev.cancelSeats(cancel.getNumTickets());
                        bookings.remove(bid);
                        System.out.println("Booking cancelled.");
                        break;

                    case 4:
                        System.out.print("Enter booking ID to view: ");
                        int vid = sc.nextInt();
                        BookingSystem view = bookings.get(vid);
                        if (view == null) throw new InvalidBookingIDException("Booking ID not found!");
                        view.displayBookingDetails();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (EventNotFoundException | InvalidBookingIDException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null error occurred. Please try again.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e);
        } finally {
            if (sc != null) sc.close();
        }
    }

    static Event findEvent(String name) {
        for (Event e : events) {
            if (e.getEventName().equalsIgnoreCase(name)) return e;
        }
        return null;
    }
}