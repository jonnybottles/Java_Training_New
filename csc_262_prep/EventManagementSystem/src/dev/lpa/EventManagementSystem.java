package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void userAddConcert() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter in the event name: ");
        String eventName = scanner.nextLine();

        System.out.println("Please enter the event date: ");
        String eventDate = scanner.nextLine();

        System.out.println("Please enter in the band name: ");
        String bandName = scanner.nextLine();

        System.out.println("Please enter in the music genre: ");
        String genre = scanner.nextLine();

        addEvent(new Concert(eventName, eventDate, bandName, genre));





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
