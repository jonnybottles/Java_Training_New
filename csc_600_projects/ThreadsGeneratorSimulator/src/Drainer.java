import java.util.List;

public class Drainer implements Runnable {

    private List<Integer> theIntegerList;
    private final Object theLock;
    private final Runnable thePrintRunnable;


    public Drainer(List<Integer> theIntegerList, Object theLock, Runnable thePrintRunnable) {
        this.theIntegerList = theIntegerList;
        this.theLock = theLock;
        this.thePrintRunnable = thePrintRunnable;
    }

    // Drains theIntegerList after the Generator has populated it and Sorter has sorted it
    @Override
    public void run() {
        // Thread runs in a while loop until it is interrupted
        while (!Thread.currentThread().isInterrupted()) {
            // Obtain theLock
            synchronized (theLock) {
                try {
                    // loop while the integer list is not populated or is not sorted
                    while (theIntegerList.isEmpty() || !isSorted()) {
                        // Release the lock and wait to be notified by Sorter / Generator
                        theLock.wait();
                    }
                    // Drain / clear the list
                    theIntegerList.clear();
                    System.out.println("List drained by Drainer.");
                    // Execute the print runnable passed by the Simulation class
                    thePrintRunnable.run();
                    // Notify the other threads that the Drainers work is done.
                    theLock.notifyAll();
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Helper method to check if a list is orted.
    private boolean isSorted() {
        if (theIntegerList.size() < 2) {
            return true;
        }

        for (int i = 1; i < 10; i++) {
            if (theIntegerList.get(i - 1) > theIntegerList.get(i)) {
                return false;
            }
        }
        return true;
    }
}
