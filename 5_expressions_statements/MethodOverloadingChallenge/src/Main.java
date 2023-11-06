// 1 inch = 2.54
// call both methods, and print out the results
public class Main {
    public static void main(String[] args) {

        System.out.println("height in centimeters: " + convertToCentimeters(2));
        System.out.println("height in centimeters: "+ convertToCentimeters(2, 2));

    }

    public static double convertToCentimeters(int height_inches) {
        return height_inches * 2.54;
    }

    public static double convertToCentimeters(int height_feet, int height_inches) {
//        int total_inches = (height_feet * 12) + height_inches;
        return convertToCentimeters((height_feet * 12) + height_inches);


    }




}

