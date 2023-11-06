public class Main {


    public static void main(String[] args) {
        System.out.println(area(5.0));
        System.out.println(area(-1));
        System.out.println(area(5.0, 4.0));
        System.out.println(area(-1, 4.0));



    }

    public static double area(double radius) {
        if (isValidNum(radius)) {
            return (radius * radius) * Math.PI;
        }
        return -1.0;
    }

    public static double area(double side1, double side2) {
        if (isValidNum(side1) && isValidNum(side2)) {
            return side1 * side2;
        }
        return -1.0;
    }

    public static boolean isValidNum(double radius) {
        return radius >= 0;
    }
}