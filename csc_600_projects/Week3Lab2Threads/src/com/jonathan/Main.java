package com.jonathan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


public class Main {
    public static void main(String[] args) {

        // Print start msg to users
        printStartMsg();

        // Create all lists for managing, the queues, tasks, and threads.
        List<ArrayBlockingQueue<Double>> queueList = createArrayBlockingQueues();
        List<NumberGenerator> theNumberGenerators = createNumberGenerators(queueList);
        List<Thread> theNumberGeneratorThreads = createThreads(theNumberGenerators);
        List<List<Integer>> theQueueSizeHistory = createQueueSizeHistoryListOfLists();

        // Create Sorter task / thread
        Sorter theSorter = new Sorter(queueList, theQueueSizeHistory);
        Thread theSorterThread = new Thread(theSorter);

        // Start all the threads
        startAllThreads(theNumberGeneratorThreads, theSorterThread);

        // Put main thread to sleep for 5 minutes
        sleepForFiveMinutes();

        // Interrupt all threads
        stopAllThreads(theNumberGeneratorThreads, theSorterThread);

        // Call join on all threads, waiting for their tasks to complete
        endThreadsGracefully(theNumberGeneratorThreads, theSorterThread);

        // Display queue size history / stats
        reportQueueInformation(queueList, theQueueSizeHistory);

    }

    // Prints a message to the user indicating the program has started.
    public static void printStartMsg() {
        System.out.println("Week 3 Lab 2 has started. Running for 5 minutes...");
    }

    // Reports the size of each threads queue, queue size history, and queue contents.
    public static void reportQueueInformation(List<ArrayBlockingQueue<Double>> queueList,
                                              List<List<Integer>> theQueueSizeHistory) {
        System.out.println("Final Queue Sizes, Size History, and Queue Contents:");
        for (int i = 0; i < queueList.size(); i++) {
            System.out.println("Queue " + i + " final size: " + queueList.get(i).size());
            System.out.println("Queue " + i + " size history: " + theQueueSizeHistory.get(i).toString());
            // Display contents of the queue
            System.out.println("Queue " + i + " contents: " + queueList.get(i).toString());
        }
    }

    // Calls join() on all threads to ensure tasks are completed prior to main exiting.
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

    // Puts main thread to sleep for five minutes
    public static void sleepForFiveMinutes() {
        // Sets program to sleep for 1 minute at a time, up to 5 minutes
        // printing a status message after each minute.
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(60000);
                System.out.println(i + " minute(s) passed...");
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }


    // Starts all threads.
    public static void startAllThreads(List<Thread> theNumberGeneratorThreads, Thread sorterThread) {
        for (Thread theNumberGeneratorThread : theNumberGeneratorThreads) {
            theNumberGeneratorThread.start();
        }

        sorterThread.start();
    }

    // Stops all threads
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
            queuesList.add(new ArrayBlockingQueue<>(300));
        }

        return queuesList;

    }

    // Creates five NumberGenerator instances
    public static List<NumberGenerator> createNumberGenerators(List<ArrayBlockingQueue<Double>> queueList) {
        List<NumberGenerator> theNumberGenerators = new ArrayList<NumberGenerator>();

        int rangeMin = 5;
        int rangeMax = 10;
        int sleepTime = 1500;


        for (int i = 0; i < 5; i++) {
            theNumberGenerators.add(new NumberGenerator(rangeMin, rangeMax, sleepTime, queueList.get(i)));
            rangeMin += 10;
            rangeMax += 10;
            sleepTime += 1000;
        }

        return theNumberGenerators;
    }

    // Creates all threads, returning a list of threads.
    public static List<Thread> createThreads(List<NumberGenerator> theNumberGenerators) {
        List<Thread> theThreads = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(theNumberGenerators.get(i), String.valueOf(i));
            theThreads.add(thread);
        }

        return theThreads;

    }

    // Creates a list of lists, used for tracking queue size history.
    public static List<List<Integer>> createQueueSizeHistoryListOfLists() {
        List<List<Integer>> theQueueSizeHistory = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            theQueueSizeHistory.add(new ArrayList<>());
        }
        return theQueueSizeHistory;
    }

}