package task10;
import java.util.Comparator;

public class EventComparator implements Comparator<Event> {
    @Override
    public int compare(Event e1, Event e2) {
        int nameComparison = e1.getEventName().compareTo(e2.getEventName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return e1.getVenue().getVenueName().compareTo(e2.getVenue().getVenueName());
    }
}
