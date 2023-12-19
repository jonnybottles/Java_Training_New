package dev.lpa;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // I am having a brain fart as to how to calculate the area of a rectangle!
    // The formula was not provided as it has been in other CBE exams
    // If this isn't it below then it is (length * 2) + (width * 2). However, that would be the perimter I believe
    public double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Shape: " + getClass().getSimpleName() + "\n" +
                "Length: " + length + "\n" +
                "Width: " + width + "\n" +
                "Area: " + area() + "\n";
    }
}
