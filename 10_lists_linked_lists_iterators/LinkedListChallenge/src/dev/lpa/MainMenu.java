package dev.lpa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MainMenu extends Menu {
    private static final String FORWARD = "F";
    private static final String BACKWARD = "B";
    private static final String LIST_PLACES = "L";
    private static final String MENU = "M";

    private LinkedList<Destination> destinations;

    public MainMenu(String programName, String menuName, String... options) {
        super(programName, menuName, options);
        this.destinations = new LinkedList<>();
    }

    // Constructor for SubMenu objects in MainMenu
    public MainMenu(MainMenu parentMenu, String menuName, String... options) {
        super(parentMenu, menuName, options);
        this.destinations = new LinkedList<>();
    }

    public void destinationsMenu() {
        while (true) {
            String userSelection = makeASelection();

            if (userSelection.equals(FORWARD)) {
                System.out.println("Forward selected");
            } else if (userSelection.equals(BACKWARD)) {
                System.out.println("Backward selected");
            } else if (userSelection.equals(LIST_PLACES)) {
                System.out.println("List places selected");
            } else {
                System.out.println("Menu selected");
            }
        }
    }


    @Override
    public void start() {
        printMenuName();
        destinationsMenu();
    }



}
