package dev.lpa;

import java.util.ArrayList;
import java.util.List;

interface Mappable {

    void render();

    // Overloaded method for a single point
    static double[] stringToLatLon(String theString) {
        String[] latLong = theString.split(",");
        return new double[]{Double.parseDouble(latLong[0].trim()), Double.parseDouble(latLong[1].trim())};
    }

    // Overloaded method for multiple points
    static double[][] stringsToLatLon(String... theStrings) {
        double[][] latLongDoubleArray = new double[theStrings.length][2];
        for (int i = 0; i < theStrings.length; i++) {
            latLongDoubleArray[i] = stringToLatLon(theStrings[i]); // Use the single point method
        }
        return latLongDoubleArray;
    }

}

public class Main {
    public static void main(String[] args) {

        Park yellowStone = new Park("Yellowstone", Mappable.stringToLatLon("44.4882, -110.5916"));
        Park grandCanyon = new Park("Grand Canyon", Mappable.stringToLatLon("36.0636, -112.1079"));
        Park Yosemite = new Park("Yosemite", Mappable.stringToLatLon("37.8855, -119.5360"));

        // Instantiate River objects based on the screenshot data
        River mississippi = new River("Mississippi", Mappable.stringsToLatLon(
                "47.2160, -95.2348",
                "35.1556, -90.0659",
                "29.1566, -89.2495"
        ));
        River missouri = new River("Missouri", Mappable.stringsToLatLon(
                "45.9239, -111.4983",
                "38.8146, -90.1218"
        ));
        River colorado = new River("Colorado", Mappable.stringsToLatLon(
                "40.4708, -105.8286",
                "36.1015, -112.0892",
                "34.2964, -114.1148",
                "31.7811, -114.7724"
        ));
        River delaware = new River("Delaware", Mappable.stringsToLatLon(
                "42.2026, -75.00836",
                "39.4955, -75.5592"
        ));

        // Render all parks and rivers
        yellowStone.render();
        grandCanyon.render();
        Yosemite.render();
        mississippi.render();
        missouri.render();
        colorado.render();
        delaware.render();

        // Now let's test the Layer class by adding elements and rendering the layer
        List<Mappable> parksAndRivers = new ArrayList<>();
        parksAndRivers.add(yellowStone);
        parksAndRivers.add(grandCanyon);
        parksAndRivers.add(Yosemite);
        parksAndRivers.add(mississippi);
        parksAndRivers.add(missouri);
        parksAndRivers.add(colorado);
        parksAndRivers.add(delaware);

        // Create a Layer object for parks and rivers
        Layer<Mappable> layer = new Layer<>(new ArrayList<>()); // Start with an empty list

        // Add all parks and rivers to the layer
        layer.addElements(parksAndRivers);

        // Render the entire layer
        layer.renderLayer();

    }
}
