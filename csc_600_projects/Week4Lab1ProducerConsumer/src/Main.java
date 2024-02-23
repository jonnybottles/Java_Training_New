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

        // Monitor buffer and start consumer threads when condition (>= 70 packets) is met
        startConsumingPackets(buffer, theConsumerThreads);

        sleepForFiveMinutes();

        // Stop all threads
        stopAllThreads(theProducerThreads);
        stopAllThreads(theConsumerThreads);

    }

    // Starts consumer threads and consumes packets within the buffer when the condition is met
    public static void startConsumingPackets(Buffer buffer, List<Thread> theConsumerThreads) {
        boolean consumersStarted = false;
        while (!consumersStarted) {
            if (buffer.getSize() >= 70) {
                System.out.println("Buffer has reached the threshold, starting consumer threads...");
                startAllThreads(theConsumerThreads);
                consumersStarted = true;
            } else {
                try {
                    // Sleep if buffer is not >= 70
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Main thread interrupted during buffer monitoring.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    // Creates producer tasks and associated threads
    public static List<Thread> createProducerThreads(Buffer buffer, int numProducers) {
        List<Thread> theProducerThreads = new ArrayList<>();

        // Create N number of tasks / and threads with the associated producer tasks
        for (int i = 0; i < numProducers; i++) {
            Producer producer = new Producer(buffer);
            Thread producerThread = new Thread(producer, "Producer-" + i);
            theProducerThreads.add(producerThread);
        }

        // Return the producer threads list
        return theProducerThreads;
    }

    // Creates consumer tasks and associated threads
    public static List<Thread> createConsumerThreads(Buffer buffer, int numConsumers) {
        List<Thread> theConsumerThreads = new ArrayList<>();
        // Create N number of tasks / and threads with the associated consumer tasks
        for (int i = 0; i < numConsumers; i++) {
            Consumer consumer = new Consumer (buffer);
            Thread consumerThread = new Thread(consumer, "Consumer-" + i);
            theConsumerThreads.add(consumerThread);

        }

        // Return consumer threads list
        return theConsumerThreads;
    }

    // Iterate through and start all threads.
    public static void startAllThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    // Iterate through and stop all threads
    public static void stopAllThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.interrupt();
        }
        System.out.println("Waiting for all threads to finish...");
    }


    // Print welcome message to user
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