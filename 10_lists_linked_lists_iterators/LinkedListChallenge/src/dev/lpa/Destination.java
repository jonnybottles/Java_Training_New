package dev.lpa;

public class Destination {

    private String town;
    private Integer distanceFromSydney;

    public Destination(String town, Integer distanceFromSydney) {
        this.town = town;
        this.distanceFromSydney = distanceFromSydney;
    }

    public String getTown() {
        return town;
    }

    public Integer getDistanceFromSydney() {
        return distanceFromSydney;
    }
}
