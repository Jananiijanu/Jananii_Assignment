package com.hexaware.ticket.task6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketBookingSystem extends BookingSystem {
    private List<Event> events = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void createEvent() {
        System.out.print("Enter Event Type (movie/concert/sports): ");
        String type = sc.next().toLowerCase();
        System.out.print("Event Name: ");
        String name = sc.next();
        System.out.print("Date: ");
        String date = sc.next();
        System.out.print("Time: ");
        String time = sc.next();
        System.out.print("Total Seats: ");
        int seats = sc.nextInt();
        System.out.print("Ticket Price: ");
        double price = sc.nextDouble();
        System.out.print("Venue: ");
        String venue = sc.next();

        Event event = null;
        switch (type) {
            case "movie":
                System.out.print("Genre: ");
                String genre = sc.next();
                System.out.print("Actor Name: ");
                String actor = sc.next();
                System.out.print("Actress Name: ");
                String actress = sc.next();
                event = new Movie(name, date, time, seats, price, venue, genre, actor, actress);
                break;
            case "concert":
                System.out.print("Artist: ");
                String artist = sc.next();
                System.out.print("Type: ");
                String concertType = sc.next();
                event = new Concert(name, date, time, seats, price, venue, artist, concertType);
                break;
            case "sports":
                System.out.print("Sport Name: ");
                String sport = sc.next();
                System.out.print("Teams: ");
                String teams = sc.next();
                event = new Sports(name, date, time, seats, price, venue, sport, teams);
                break;
            default:
                System.out.println("Invalid event type.");
                return;
        }
        events.add(event);
        System.out.println("Event created successfully!");
    }

    @Override
    public void bookTickets() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
        displayEvents();
        System.out.print("Enter event number to book: ");
        int index = sc.nextInt();
        if (index < 1 || index > events.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Event e = events.get(index - 1);
        System.out.print("Number of tickets: ");
        int tickets = sc.nextInt();
        double cost = e.bookTickets(tickets);
        if (cost == -1) {
            System.out.println("Not enough seats.");
        } else {
            System.out.println("Booking successful! Total cost: " + cost);
        }
    }

    @Override
    public void cancelTickets() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
        displayEvents();
        System.out.print("Enter event number to cancel tickets: ");
        int index = sc.nextInt();
        if (index < 1 || index > events.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Event e = events.get(index - 1);
        System.out.print("Number of tickets to cancel: ");
        int tickets = sc.nextInt();
        e.cancelTickets(tickets);
        System.out.println("Tickets cancelled.");
    }

    @Override
    public void getAvailableSeats() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
        displayEvents();
        System.out.print("Enter event number to check available seats: ");
        int index = sc.nextInt();
        if (index < 1 || index > events.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Event e = events.get(index - 1);
        System.out.println("Available Seats: " + e.getAvailableSeats());
    }

    private void displayEvents() {
        System.out.println("\n--- Events ---");
        for (int i = 0; i < events.size(); i++) {
            System.out.print((i + 1) + ". ");
            events.get(i).displayEventDetails();
        }
    }

    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Ticket Booking System ---");
            System.out.println("Commands: create_event | book_tickets | cancel_tickets | get_available_seats | exit");
            System.out.print("Enter command: ");
            String command = sc.next().toLowerCase();
            switch (command) {
                case "create_event":
                    system.createEvent();
                    break;
                case "book_tickets":
                    system.bookTickets();
                    break;
                case "cancel_tickets":
                    system.cancelTickets();
                    break;
                case "get_available_seats":
                    system.getAvailableSeats();
                    break;
                case "exit":
                    System.out.println("Exiting system. Thank you!");
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}