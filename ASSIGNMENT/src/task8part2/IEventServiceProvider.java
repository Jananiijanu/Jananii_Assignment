package task8part2;
import task8.Event;
import task8.Venue;
	public interface IEventServiceProvider {
	    Event createEvent(String name, String date, String time, int totalSeats, double price, String type, Venue venue);
	    Event[] getEventDetails();
	    int getAvailableNoOfTickets(String eventName);
	}


