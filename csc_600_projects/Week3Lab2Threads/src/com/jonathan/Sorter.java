package com.jonathan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

// A class that contains the logic and attributes for sorting / keeping track of queue sizes
public class Sorter implements Runnable{

    private List<ArrayBlockingQueue<Double>> theQueues;

    // List of lists is used for tracking each threads queue size over time
    private List<List<Integer>> theQueueSizeHistory;


    public Sorter(List<ArrayBlockingQueue<Double>> theQueues, List<List<Integer>> theQueueSizeHistory) {
        this.theQueues = theQueues;
        this.theQueueSizeHistory = theQueueSizeHistory;
    }

    @Override
    public void run() {
        System.out.println("Starting Sorter Thread.");

        // Run the loop until the thread is interrupted
        while (!Thread.currentThread().isInterrupted()) {

            try {

                int minSleep = 250;
                int maxSleep = 500;
                // Using ThreadLocalRandom is the thread safe / better option
                // for random number generation with threads.
                int sleepTime = ThreadLocalRandom.current().nextInt(minSleep, maxSleep);

                Thread.sleep(sleepTime);

                // Begin logic for sorting / tracking queue size history
                // whenever the sort thread is awoken
                for (int i = 0; i < 5; i++) {

                    // iterate over the queues list and get each queue
                    ArrayBlockingQueue<Double> queue = theQueues.get(i);

                    // Create a new list that contains the contents of the queue to allow for sorting
                    // As sorting is not supported by queues
                    List<Double> theList = new ArrayList<>(queue);
                    Collections.sort(theList);

                    // Clear the queue
                    queue.clear();

                    // After the queue is cleared, add the new sorted contents back into the queue
                    queue.addAll(theList);

                    // Add current queue size to the list, tracking queue sizes over time for each
                    // thread
                    theQueueSizeHistory.get(i).add(queue.size());
                }

            // Once interrupted, print message to the user
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Sorter thread interrupted. Stopping sorter thread.");
                break;
            }
        }
    }
}
