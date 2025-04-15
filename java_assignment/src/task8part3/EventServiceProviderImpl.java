package task8part3;
import task8.Event;
import task8.Venue;
import task8part2.IEventServiceProvider;
public class EventServiceProviderImpl implements IEventServiceProvider {
	    protected static Event[] events = new Event[10];
	    protected static int eventIndex = 0;

	    public Event createEvent(String name, String date, String time, int totalSeats, double price, String type, Venue venue) {
	        Event event = new Event(name, date, time, totalSeats, price, type, venue);
	        events[eventIndex++] = event;
	        return event;
	    }

	    public Event[] getEventDetails() {
	        return events;
	    }

	    public int getAvailableNoOfTickets(String eventName) {
	        for (Event e : events) {
	            if (e != null && e.getEventName().equalsIgnoreCase(eventName)) {
	                return e.getAvailableSeats();
	            }
	        }
	        return -1;
	    }
	}

