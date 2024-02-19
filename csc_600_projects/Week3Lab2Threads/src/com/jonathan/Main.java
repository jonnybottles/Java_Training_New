package com.jonathan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

;

public class Main {
    public static void main(String[] args) {

        printStartMsg();
        List<ArrayBlockingQueue<Double>> queueList = createArrayBlockingQueues();
        List<NumberGenerator> theNumberGenerators = createNumberGenerators(queueList);
        List<Thread> theNumberGeneratorThreads = createThreads(theNumberGenerators);

        List<List<Integer>> theQueueSizeHistory = createQueueSizeHistoryListOfLists();

        Sorter theSorter = new Sorter(queueList, theQueueSizeHistory);

        Thread theSorterThread = new Thread(theSorter);

        startAllThreads(theNumberGeneratorThreads, theSorterThread);

        sleepForFiveMinutes();

        stopAllThreads(theNumberGeneratorThreads, theSorterThread);

        endThreadsGracefully(theNumberGeneratorThreads, theSorterThread);

        reportQueueSizeHistory(queueList, theQueueSizeHistory);

    }

    public static void printStartMsg() {
        System.out.println("Week 3 Lab 2 has started. Running for 5 minutes...");
    }

    public static void reportQueueSizeHistory(List<ArrayBlockingQueue<Double>> queueList, List<List<Integer>> theQueueSizeHistory) {
        System.out.println("Final Queue Sizes and Size History:");
        for (int i = 0; i < queueList.size(); i++) {
            System.out.println("Queue " + i + " final size: " + queueList.get(i).size());
            System.out.println("Queue " + i + " size history: " + theQueueSizeHistory.get(i).toString());
        }
    }


    public static void endThreadsGracefully(List<Thread> theNumberGeneratorThreads, Thread sorterThread) {
        try {
            for (Thread theNumberGeneratorThread : theNumberGeneratorThreads) {
                theNumberGeneratorThread.join();
            }
            sorterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void sleepForFiveMinutes() {
        // Sets program to sleep for 1 minute at a time, up to 5 minutes, printing a status message after each minute.
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(60000); // Sleep for 1 minute
                System.out.println(i + " minute(s) passed...");
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted.");
                Thread.currentThread().interrupt(); // Preserve interrupt status
                break; // Exit the loop if the sleep was interrupted
            }
        }
    }


    public static void startAllThreads(List<Thread> theNumberGeneratorThreads, Thread sorterThread) {
        for (Thread theNumberGeneratorThread : theNumberGeneratorThreads) {
            theNumberGeneratorThread.start();
        }

        sorterThread.start();
    }

    public static void stopAllThreads(List<Thread> theNumberGeneratorThreads, Thread sorterThread) {
        for (Thread theNumberGeneratorThread : theNumberGeneratorThreads) {
            theNumberGeneratorThread.interrupt();
        }
        sorterThread.interrupt();
        System.out.println("Waiting for all threads to finish...");
    }

    // Creates a List containing five ArrayBlockingQueues of doubles
    public static List<ArrayBlockingQueue<Double>> createArrayBlockingQueues() {

        List<ArrayBlockingQueue<Double>> queuesList = new ArrayList<ArrayBlockingQueue<Double>>();

        for (int i = 0; i < 5; i++) {
            queuesList.add(new ArrayBlockingQueue<>(200));
        }

        return queuesList;

    }

    // Creates five NumberGenerator instances
    public static List<NumberGenerator> createNumberGenerators(List<ArrayBlockingQueue<Double>> queueList) {
        List<NumberGenerator> theNumberGenerators = new ArrayList<NumberGenerator>();

        int rangeMin = 5;
        int rangeMax = 10;
        int sleepTime = 1000;


        for (int i = 0; i < 5; i++) {
            theNumberGenerators.add(new NumberGenerator(rangeMin, rangeMax, sleepTime, queueList.get(i)));
            rangeMin += 5;
            rangeMax += 5;
            sleepTime += 500;
        }

        return theNumberGenerators;
    }

    public static List<Thread> createThreads(List<NumberGenerator> theNumberGenerators) {
        List<Thread> theThreads = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(theNumberGenerators.get(i), String.valueOf(i));
            theThreads.add(thread);
        }

        return theThreads;

    }

    public static List<List<Integer>> createQueueSizeHistoryListOfLists() {
        List<List<Integer>> theQueueSizeHistory = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            theQueueSizeHistory.add(new ArrayList<>());
        }
        return theQueueSizeHistory;
    }

}