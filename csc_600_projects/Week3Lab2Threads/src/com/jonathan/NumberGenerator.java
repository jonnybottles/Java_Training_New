package com.jonathan;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerator implements Runnable {

    private int rangeMin;
    private int rangeMax;
    private int sleepTime;
    private ArrayBlockingQueue<Double> numQueue;

    public NumberGenerator(int rangeMin, int rangeMax, int sleepTime, ArrayBlockingQueue<Double> numQueue) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        this.sleepTime = sleepTime;
        this.numQueue = numQueue;
    }

    private double generateRandomDouble() {
        // Uses ThreadLocalRandom as this is the thread safe alternative to using a Random object
        return ThreadLocalRandom.current().nextDouble(rangeMin,rangeMax);
    }

    @Override
    public void run() {

        System.out.println("Starting Number Generator: Thread: " + Thread.currentThread().getName());
        while (!Thread.currentThread().isInterrupted()) {
            try {
                double randomDouble = generateRandomDouble();
                numQueue.put(randomDouble);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Stopping Number Generator: Thread: " + Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }

    }
}
