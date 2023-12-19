package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {

    private String name;
    private String date;
    private List<Attendee> attendees;

    public Event(String name, String date) {
        this.name = name;
        this.date = date;
        this.attendees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public boolean addAttendee(Attendee attendee) {
        if (findAttendee(attendee)) {
            System.out.println("Attendee " + attendee.getName() + "already attending event.");
            return false;
        }

        attendees.add(attendee);
        return true;

    }

    private boolean findAttendee(Attendee attendee) {
        if (attendees.contains(attendee)) {
            return true;
        }
        return false;
    }

    public String displayDetails() {

        String details =  "Event Type: " + getClass().getSimpleName() + " \n" +
                " Event Name: " + name + "\n" +
                " Event Date: " + date + "\n" +
                " Attendees:\n";

        for (Attendee attendee : attendees) {
            details += attendee.getName() + "\n";
        }

        return details;

    }


}
