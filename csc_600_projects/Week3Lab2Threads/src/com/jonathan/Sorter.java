package com.jonathan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Sorter implements Runnable{

    private List<ArrayBlockingQueue> theQueues;
    private List<Integer> theQueueSizeList;


    public Sorter(List<ArrayBlockingQueue> theQueues, List<Integer> theQueueSizeList) {
        this.theQueues = theQueues;
        this.theQueueSizeList = theQueueSizeList;
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


            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }


        }

        List<Double> theList = new ArrayList<>();

        for (ArrayBlockingQueue<Double> queue : theQueues) {
            // Put all items in the queue into a list, as queues do not support draining operations
            queue.drainTo(theList);

            // Sort the list
            Collections.sort(theList);

            // Added sorted items back to list
            queue.addAll(theList);

            // Clears the list for the next iteration of the loop
            theList.clear();

        }

    }
}
