import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int userInt = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (true) {
            userInt = getInt(scanner);
            if (userInt == -1) {
                System.out.println("Character entered, exiting program...");
                break;
            }

            int[] minMaxValues = minMax(min, max, userInt);
            min = minMaxValues[0];
            max = minMaxValues[1];

            printMinMax(min, max);

        }

        scanner.close();
    }

    public static int getInt(Scanner scanner) {

        int userInt = 0;
        while (true) {
            System.out.println("Enter a number, or any character to quit:");
            try {
                userInt = Integer.parseInt(scanner.nextLine());
                return userInt;
            } catch (NumberFormatException badUserData) {
                return -1;
            }
        }
    }

    public static int[] minMax(int currentMin, int currentMax, int userInt) {

        if (userInt < currentMin) {
            currentMin = userInt;
        }

        if (userInt > currentMax) {
            currentMax = userInt;
        }

        return new int[] {currentMin, currentMax};
    }

    public static void printMinMax(int min, int max) {
        System.out.println("MIN: " + min);
        System.out.println("MAX: " + max);
    }



}