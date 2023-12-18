package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int theArg;
        theArg = isValidArgs(args);
        EventManagementSystem theEventManagementSystem = null;
        if (theArg == 1) {
            System.out.println("Go interactive when instantiating object");
        } else {
            System.out.println("Do not go interactive when instantiating object");
            theEventManagementSystem = new EventManagementSystem();
        }


        Event theNewYearsBash = new Event("New Years 2024 Bash", "30 DEC 2023");
        theNewYearsBash.addAttendee(new Attendee("Jonathan", "xxbutler86xx@gmail.com"));
        theEventManagementSystem.addEvent(theNewYearsBash);


        List<Event> theEvents = theEventManagementSystem.getEvents();

        for (Event event : theEvents) {
            System.out.println(event.displayDetails());
        }



    }

    public static int isValidArgs(String[] args) {


        if (args.length != 0 && args.length != 1) {
            usage();
            return -1;
        }
        if (args.length == 1) {
            String userArg = args[0];
            return 1;
        } else {
            return 0;
        }
    }

    private static void usage() {
        System.out.println("java EventManagementSystem -i");
        System.exit(0);
    }

}
