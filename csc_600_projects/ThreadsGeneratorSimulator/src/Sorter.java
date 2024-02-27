import java.util.Collections;
import java.util.List;

public class Sorter implements  Runnable{

    private List<Integer> theIntegerList;
    private final Object theLock;
    private final Runnable thePrintRunnable;

    public Sorter(List<Integer> theIntegerList, Object theLock, Runnable thePrintRunnable) {
        this.theIntegerList = theIntegerList;
        this.theLock = theLock;
        this.thePrintRunnable = thePrintRunnable;
    }

    // Sorts theIntegerList after the Generator has populated it appropriately
    @Override
    public void run() {
        // Thread runs in a while loop until it is interrupted
        while (!Thread.currentThread().isInterrupted()) {
            // Obtain theLock
            synchronized (theLock) {
                try {
                    // Loop while waiting for Generator to fill the list with 10 random digits
                    while (theIntegerList.size() != 10) {
                        // Release the lock and wait to be notified to be awoken
                        theLock.wait();
                    }
                    // Sort theIntegerList
                    Collections.sort(theIntegerList);
                    System.out.println("List sorted by Sorter.");
                    // Execute the print runnable passed by the Simulation class
                    thePrintRunnable.run();
                    // Notify the other threads that the Sorters work is done.
                    theLock.notifyAll();
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
