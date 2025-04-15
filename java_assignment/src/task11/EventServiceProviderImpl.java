package task11;
import java.util.ArrayList;
import java.util.List;


public class EventServiceProviderImpl implements IEventServiceProvider {
    protected List<Event> eventList = new ArrayList<>();

    @Override
    public Event createEvent(String name, String date, String time, int totalSeats, double price, String type, Venue venue) {
        Event event = null;
        switch (type.toLowerCase()) {
            case "movie":
                event = new Movie(name, date, time, totalSeats, price, type, venue);
                break;
            case "sports":
                event = new Sports(name, date, time, totalSeats, price, type, venue);
                break;
            case "concert":
                event = new Concert(name, date, time, totalSeats, price, type, venue);
                break;
            default:
                System.out.println("Invalid event type!");
        }
        if (event != null) {
            eventList.add(event);
        }
        return event;
    }

    @Override
    public List<Event> getEventDetails() {
        return eventList;
    }

    @Override
    public int getAvailableSeats(String eventName) {
        for (Event e : eventList) {
            if (e.getEventName().equalsIgnoreCase(eventName)) {
                return e.getAvailableSeats();
            }
        }
        return 0;
    }
}
