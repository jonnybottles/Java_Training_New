package com.jonathan;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerator implements Runnable {

    private int rangeMin;
    private int rangeMax;
    private int sleepTime;
    private BlockingQueue<Double> numQueue;

    public NumberGenerator(int rangeMin, int rangeMax, int sleepTime, BlockingQueue<Double> numQueue) {
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

        while (!Thread.currentThread().isInterrupted()) {
            try {
                double randomDouble = generateRandomDouble();
                numQueue.put(randomDouble);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
