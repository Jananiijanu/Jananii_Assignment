package task10;

import java.util.HashMap;
import java.util.Map;

public class BookingSystem {
    private Map<String, Event> events;

    public BookingSystem() {
        this.events = new HashMap<>();
    }

    public void addEvent(String eventName, Event event) {
        events.put(eventName, event);
    }

    public Event getEvent(String eventName) {
        return events.get(eventName);
    }

    public void displayEvents() {
        for (Event event : events.values()) {
            event.displayEventDetails();
        }
    }
}