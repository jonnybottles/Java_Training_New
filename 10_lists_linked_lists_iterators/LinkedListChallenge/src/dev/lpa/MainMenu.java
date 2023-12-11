package dev.lpa;

import java.util.*;

public class MainMenu extends Menu {
    private static final String FORWARD = "F";
    private static final String BACKWARD = "B";
    private static final String LIST_PLACES = "L";
    private static final String MENU = "M";

    protected LinkedList<Destination> destinations;
    protected ListIterator<Destination> iterator;

    public MainMenu(String programName, String menuName, LinkedList<Destination> destinations, String... options) {
        super(programName, menuName, options);
        this.destinations = destinations;
        this.iterator = destinations.listIterator();
    }

    // Constructor for SubMenu objects in MainMenu
    public MainMenu(MainMenu parentMenu, String menuName, LinkedList<Destination> destinations, String... options) {
        super(parentMenu, menuName, options);
        this.destinations = destinations;
    }

    public void destinationsMenu() {
        while (true) {
            String userSelection = makeASelection();

            if (userSelection.equals(FORWARD)) {
                moveForward();
            } else if (userSelection.equals(BACKWARD)) {
                moveBack();
            } else if (userSelection.equals(LIST_PLACES)) {
                instantiateListDestinationsMenu();
            } else {
                System.out.println("Menu selected");
            }
        }
    }

    private void moveForward() {
        System.out.println("User wants to travel forward");
        Destination theDestination = this.iterator.next();
        String town = theDestination.getTown();
        int distance = theDestination.getDistanceFromSydney();
        System.out.println(town + " (" + distance + "km)");
        try {
            Thread.sleep(3000); // Sleep for 3 seconds (3000 milliseconds)
        } catch (InterruptedException e) {
            // Handle the InterruptedException if needed
        }
    }

    private void moveBack() {
        System.out.println("User wants to travel backward");
        Destination theDestination = this.iterator.previous();
        String town = theDestination.getTown();
        int distance = theDestination.getDistanceFromSydney();
        System.out.println(town + " (" + distance + "km)");
        try {
            Thread.sleep(3000); // Sleep for 3 seconds (3000 milliseconds)
        } catch (InterruptedException e) {
            // Handle the InterruptedException if needed
        }
    }

    private void instantiateListDestinationsMenu() {
        ListDestinationsMenu theListDestinationsMenu = new ListDestinationsMenu(this, "Destinations List", this.destinations);
        theListDestinationsMenu.start();
    }

    @Override
    public void start() {
        printMenuName();
        destinationsMenu();
    }



}
