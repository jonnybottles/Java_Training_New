package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int theArg;
        theArg = isValidArgs(args);
        EventManagementSystem theEventManagementSystem = new EventManagementSystem();
        if (theArg == 1) {
            theEventManagementSystem.userAddConcert();

        }

        Event theNewYearsBash = new Event("New Years 2024 Bash", "30 DEC 2023");
        theNewYearsBash.addAttendee(new Attendee("Jonathan", "xxbutler86xx@gmail.com"));

        Concert theMetalFest = new Concert("MetalFest", "18 JAN 2024", "BearTooth", "Metal");
        theMetalFest.addAttendee(new Attendee("Amanda", "abutler132@gmail.com"));

        theEventManagementSystem.addEvent(theNewYearsBash);
        theEventManagementSystem.addEvent(theMetalFest);


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
            if (args[0].equalsIgnoreCase("-c")) {
                return 1;
            }
            return -1;

        } else {
            return 0;
        }
    }

    private static void usage() {
        System.out.println("java EventManagementSystem -c");
        System.exit(0);
    }

}
