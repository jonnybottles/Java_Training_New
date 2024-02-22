import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        printStartMsg();

        // Set buffer capacity to 70 as per requirements
        Buffer buffer = new Buffer(70);

        // Number of producer / consumer threads
        int numberOfProducers = 2;
        int numberOfConsumers = 2;

        // Create producer runnables / tasks and threads.
        List<Thread> theProducerThreads = createProducerThreads(buffer, numberOfProducers);

        // Start all producer threads
        startAllThreads(theProducerThreads);

        // Create consumer runnables / tasks and threads.
        List<Thread> theConsumerThreads = createConsumerThreads(buffer, numberOfConsumers);

        // Monitor buffer and start consumer threads when condition is met
        startConsumingPackets(buffer, theConsumerThreads);


        sleepForFiveMinutes();

        // Stop all threads
        stopAllThreads(theProducerThreads);
        stopAllThreads(theConsumerThreads);

    }

    public static void startConsumingPackets(Buffer buffer, List<Thread> theConsumerThreads) {

        boolean consumersStarted = false;
        while (!consumersStarted) {
            if (buffer.getSize() >= 70) {
                System.out.println("Buffer has reached the threshold, starting consumer threads...");
                startAllThreads(theConsumerThreads);
                consumersStarted = true;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Main thread interrupted during buffer monitoring.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public static List<Thread> createProducerThreads(Buffer buffer, int numProducers) {
        List<Thread> theProducerThreads = new ArrayList<>();
        for (int i = 0; i < numProducers; i++) {
            Producer producer = new Producer(buffer);
            Thread producerThread = new Thread(producer, "Producer-" + i);
            theProducerThreads.add(producerThread);
        }

        return theProducerThreads;
    }

    public static List<Thread> createConsumerThreads(Buffer buffer, int numConsumers) {
        List<Thread> theConsumerThreads = new ArrayList<>();
        for (int i = 0; i < numConsumers; i++) {
            Consumer consumer = new Consumer (buffer);
            Thread consumerThread = new Thread(consumer, "Consumer-" + i);
            theConsumerThreads.add(consumerThread);

        }
        return theConsumerThreads;
    }

    public static void startAllThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void stopAllThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.interrupt();
        }
        System.out.println("Waiting for all threads to finish...");
    }


    public static void printStartMsg() {
        System.out.println("Week 4 Lab 1 has started. Running for 5 minutes...");
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

}