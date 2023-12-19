package dev.lpa;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] randIntArray = createRandomIntegerArray();


        int max = getMax(randIntArray);
        int min = getMin(randIntArray);
        double avg = getAvg(randIntArray);

        System.out.println("The max value in the array is: " + max);
        System.out.println("The min value in the array is: " + min);
        System.out.println("The avg value in the array is: " + avg);


    }


    public static int[] createRandomIntegerArray() {
        Random random = new Random();

        int[] randIntArray = new int[100];

        for (int i = 0; i < 100; i++) {
            randIntArray[i] = random.nextInt(1, 101);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(randIntArray[i]);
        }

        return randIntArray;

    }

    public static int getMax(int[] randIntArray) {
        int max = Integer.MIN_VALUE;

        for (int theInt : randIntArray) {
            if (theInt > max) {
                max = theInt;
            }
        }

        return max;

    }

    public static int getMin(int[] randIntArray) {
        int min = Integer.MAX_VALUE;

        for (int theInt : randIntArray) {
            if (theInt < min) {
                min = theInt;
            }
        }

        return min;

    }

    public static double getAvg(int[] randIntArray) {
        double sum = 0;
        for (int theInt: randIntArray) {
            sum += (double)theInt;
        }
        return sum / randIntArray.length;
    }


}