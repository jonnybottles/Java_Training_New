package dev.lpa;

public abstract class Line implements Mappable{
    double[][] locations;

    public Line(double[][] locations) {
        this.locations = locations;
    }

    private String locations() {
        // Use a StringBuilder to build the string efficiently
        StringBuilder builder = new StringBuilder();

        // Iterate through each point (which is an array of two doubles)
        for (double[] location : locations) {
            // Append the coordinates of the point to the StringBuilder
            if (location.length >= 2) { // Ensure there are at least two coordinates
                if (builder.length() > 0) {
                    builder.append(", "); // Separate each point with a comma and space
                }
                builder.append("[").append(location[0]).append(", ").append(location[1]).append("]");
            }
        }
        return builder.toString();
    }

    @Override
    public void render() {
        // Print the locations in the format shown in the example
        System.out.println("Render " + this.getClass().getSimpleName() + " as LINE " + locations());
    }
}
