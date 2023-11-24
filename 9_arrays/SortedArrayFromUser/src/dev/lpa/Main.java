package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] userIntArray = getIntegers();
        System.out.println(Arrays.toString(userIntArray));
        userIntArray = sortIntegers(userIntArray);
        System.out.println(Arrays.toString(userIntArray));
        printArray(userIntArray);



        
    }

    public static int[] sortIntegers(int [] theArray) {
        Arrays.sort(theArray);
        int[] newArray = new int[theArray.length];

        int countDown = theArray.length - 1;
        int index = 0;

        while (countDown > -1) {
            newArray[index++] = theArray[countDown--];

        }
        return newArray;
    }
    public static int [] getIntegers() {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int [] theArray = new int[5];
        while (true) {

            try {
                System.out.println("Please enter an integer, or a character to quit");
                int userInt = Integer.parseInt(scanner.nextLine());
                theArray[count++] = userInt;
                if (count == 5) {
                    System.out.println("5 integers entered. Exiting user input.");
                    break;
                }

            } catch (NumberFormatException e) {
                if (count < 4) {
                    System.out.println("You need to enter at least 5 integers");
                    continue;
                } else {
                    break;
                }

            }

        }
        return theArray;

    }

    public static void printArray(int [] userSortedArray) {
        for (int i = 0; i < userSortedArray.length; i ++) {
            System.out.println("Element " + i + " contents " + userSortedArray[i]);
        }
    }


}