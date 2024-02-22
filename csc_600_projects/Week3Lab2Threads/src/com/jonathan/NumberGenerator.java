package com.jonathan;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

// Class that contains the appropriate methods to generate random numbers
// and add them to an ArrayBlockingQueue
public class NumberGenerator implements Runnable {

    private int rangeMin;
    private int rangeMax;
    private int sleepTime;

    // Using arrayBlockingQueue as this is thread safe
    private ArrayBlockingQueue<Double> numQueue;

    public NumberGenerator(int rangeMin, int rangeMax, int sleepTime, ArrayBlockingQueue<Double> numQueue) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        this.sleepTime = sleepTime;
        this.numQueue = numQueue;
    }

    // Generates a random double
    private double generateRandomDouble() {
        // Uses ThreadLocalRandom as this is the thread safe alternative to using a Random object
        return ThreadLocalRandom.current().nextDouble(rangeMin,rangeMax);
    }

    @Override
    public void run() {

        System.out.println("Starting Number Generator: Thread: " + Thread.currentThread().getName());

        // loop while thread is not interrupted
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // try block gets a random double, adds it to the queue, and then sleeps for the random time
                double randomDouble = generateRandomDouble();
                // Offer is used here instead of put, as I was getting exceptions
                // when my queue would reach capacity using put.
                numQueue.offer(randomDouble);

                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                // If interrupted, print message to the user
                System.out.println("Stopping Number Generator: Thread: " + Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }

    }
}
