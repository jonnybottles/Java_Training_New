package dev.lpa;

import java.util.LinkedList;

public class ListDestinationsMenu extends Menu {
    protected LinkedList<Destination> destinations;

    public ListDestinationsMenu(String programName, String menuName, LinkedList<Destination> destinations, String... options) {
        super(programName, menuName, options);
        this.destinations = destinations;
    }

    // Constructor for SubMenu objects in MainMenu
    public ListDestinationsMenu(MainMenu parentMenu, String menuName, LinkedList<Destination> destinations, String... options) {
        super(parentMenu, menuName, options);
        this.destinations = destinations;
    }

    @Override
    public void displayCustomContent() {
        listPlaces();
    }


    private void listPlaces() {

        for (Destination destination : destinations) {
            String town = destination.getTown();
            int distance = destination.getDistanceFromSydney();
            System.out.println(town + " - " + distance + " km from Sydney");
        }
        System.out.println("");
    }

    public void start() {
        makeASelection();
    }

}
