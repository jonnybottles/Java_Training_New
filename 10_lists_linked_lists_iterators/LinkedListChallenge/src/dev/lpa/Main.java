package dev.lpa;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Destination> destinations = new LinkedList<Destination>();
        Destination adelaide = new Destination("Adelaide", 1374);
        Destination aliceSprings = new Destination("Alice Springs", 2771);
        Destination brisbane = new Destination("Brisbane", 917);
        Destination darwin = new Destination("Darwin", 3972);
        Destination melbourne = new Destination("Melbourne", 877);
        Destination perth = new Destination("Perth", 3923);

        destinations.add(adelaide);
        destinations.add(aliceSprings);
        destinations.add(brisbane);
        destinations.add(darwin);
        destinations.add(melbourne);
        destinations.add(perth);

        //Create a custom comparator based on distance
        Comparator<Destination> distanceComparator = Comparator.comparingInt(Destination::getDistanceFromSydney);

        //Sort the destinations using the comparator
        Collections.sort(destinations, distanceComparator);

        MainMenu theMainMenu = new MainMenu("Itinerary Planner", "Main Menu", destinations,
                "F, Forward",
                "B, Backward",
                "L, List places",
                "M, Menu");
        theMainMenu.start();
    }
}