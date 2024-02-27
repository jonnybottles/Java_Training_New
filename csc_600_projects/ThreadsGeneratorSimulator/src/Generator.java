import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generator implements Runnable{

    private final List<Integer> theIntegerList;
    private final Object theLock;
    private final Runnable thePrintRunnable;

    public Generator(List<Integer> theIntegerList, Object theLock, Runnable thePrintRunnable) {
        this.theIntegerList = theIntegerList;
        this.theLock = theLock;
        this.thePrintRunnable = thePrintRunnable;
    }


    // Generates a random integer in a thread safe fashion between 1 - 100
    private int generateRandomInteger() {
        return ThreadLocalRandom.current().nextInt(1, 101);
    }

    // Fills  theIntegerList with 10 random integers
    private void fillList() {
        for (int i = 0; i < 10; i++) {
            theIntegerList.add(generateRandomInteger());
        }
    }

    // Fills the integer list with 10 random integers between 1 and 100
    @Override
    public void run() {
        // Thread runs in a while loop until it is interrupted
        while (!Thread.currentThread().isInterrupted()) {
            // Obtain theLock
            synchronized (theLock) {
                try {
                    // Wait until the integer list is empty
                    while (!theIntegerList.isEmpty()) {
                        // Release the lock while there is not work to do and waits to be notified
                        theLock.wait();
                    }
                    // Once the integer list is confirmed empty, fill the list
                    fillList();
                    System.out.println("List filled by Generator.");
                    // Execute the print runnable passed by the Simulation class
                    thePrintRunnable.run();
                    // Notify the other threads that the generators work is done.
                    theLock.notifyAll();
                    // Sleep for 5 milliseconds
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
