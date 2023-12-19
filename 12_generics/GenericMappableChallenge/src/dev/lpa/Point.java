package dev.lpa;

public abstract class Point implements Mappable{
    double[] location;

    public Point(double[] location) {
        this.location = location;
    }

    private String location() {
        return location[0] + "," + location[1];
    }

    @Override
    public void render() {
        // Print the locations in the format shown in the example
        System.out.println("Render " + this.getClass().getSimpleName() + " as POINT " + location());
    }
}


