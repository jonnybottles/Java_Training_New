package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class EventManagementSystem {

    private List<Event> events;

    public EventManagementSystem() {
        this.events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public boolean addEvent (Event event) {

            if (findEvent(event.getName())) {
                System.out.println("Event " + event.getName() + "Already exists.");
                return false;
            }

        events.add(event);
        return true;
    }



    private boolean findEvent (String eventName)  {
        for (Event event: events) {
            if (event.getName().equals(eventName)) {
                return true;
            }
        }

        return false;
    }


}
