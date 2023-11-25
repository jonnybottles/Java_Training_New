package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String userStringNums = getInput();
        String [] userStringNumsArray = userStringNums.split(",");

        int [] userIntNumsArray = returnArrayOfIntegers(userStringNumsArray);
        System.out.println(Arrays.toString(userIntNumsArray));

        int min = findMin(userIntNumsArray);

        System.out.println("MIN: " + min);

    }

    public static int[] returnArrayOfIntegers(String... userStringNumsArray) {


        int[] userIntNumsArray = new int[userStringNumsArray.length];
        for (int i = 0; i < userStringNumsArray.length; i++) {
            userIntNumsArray[i] = Integer.parseInt(userStringNumsArray[i]);

        }
        return userIntNumsArray;
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a comma delimited list of numbers");
        return scanner.nextLine();
    }

    public static int findMin(int[] userIntNumsArray) {
        int min = Integer.MAX_VALUE;
        for (int theInt: userIntNumsArray) {
            if (theInt < min) {
                min = theInt;
            }
        }
        return min;
    }


}