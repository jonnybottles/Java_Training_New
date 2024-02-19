package com.jonathan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Sorter implements Runnable{

    private List<ArrayBlockingQueue<Double>> theQueues;
    private List<List<Integer>> theQueueSizeHistory;


    public Sorter(List<ArrayBlockingQueue<Double>> theQueues, List<List<Integer>> theQueueSizeHistory) {
        this.theQueues = theQueues;
        this.theQueueSizeHistory = theQueueSizeHistory;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {

                int minSleep = 1000;
                int maxSleep = 5000;
                // Using ThreadLocalRandom is the thread safe / better option
                // for random number generation with threads.
                int sleepTime = ThreadLocalRandom.current().nextInt(minSleep, maxSleep);

                Thread.sleep(sleepTime);

                for (int i = 0; i < 5; i++) {

                    // iterate over the queues list and get each queue
                    ArrayBlockingQueue<Double> queue = theQueues.get(i);

                    // Create a new list that contains the contents of the queue to allow for sorting
                    List<Double> theList = new ArrayList<>(queue);
                    Collections.sort(theList);

                    // Clear the queue
                    queue.clear();

                    // After the queue is cleared, add the new sorted contents back into the queue
                    queue.addAll(theList);

                    // Add the current size to the history
                    theQueueSizeHistory.get(i).add(queue.size());


                }


            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }


        }




    }
}
