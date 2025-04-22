package com.hexaware.ticket.task10;

import java.util.HashMap;
import java.util.Map;

public class BookingSystem {
    private Map<String, Event> eventMap = new HashMap<>();

    public void addEvent(String name, Event event) {
        eventMap.put(name, event);
    }

    public void displayEvents() {
        for (String name : eventMap.keySet()) {
            System.out.println("Event: " + name);
        }
    }

    public Event getEvent(String name) {
        return eventMap.get(name);
    }
}
