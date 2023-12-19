package dev.lpa;

public class Destination {

    private String town;
    private int distanceFromSydney;

    public Destination(String town, Integer distanceFromSydney) {
        this.town = town;
        this.distanceFromSydney = distanceFromSydney;
    }

    public String getTown() {
        return town;
    }

    public int getDistanceFromSydney() {
        return distanceFromSydney;
    }



}
