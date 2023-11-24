package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] ranArray = createRandomArray(5);
        System.out.println(Arrays.toString(ranArray));
        int [] sortedHighToLow = reverseArray(ranArray);
        System.out.println(Arrays.toString(sortedHighToLow));


        
    }

    public static int [] createRandomArray(int len) {
        Random random = new Random();
        int [] ranArray = new int[len];

        for (int i = 0; i < len; i++) {
            ranArray[i] = random.nextInt(100);
        }

        return ranArray;
    }

    public static int[] reverseArray(int [] theArray) {
        Arrays.sort(theArray);
        int[] newArray = new int[theArray.length];

        int countDown = theArray.length - 1;
        int index = 0;

        while (countDown > -1) {
            newArray[index++] = theArray[countDown--];

        }
        return newArray;
    }
}