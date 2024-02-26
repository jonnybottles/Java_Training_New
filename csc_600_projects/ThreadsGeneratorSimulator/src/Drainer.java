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

    @Override
    public void run() {
        synchronized (theLock) {
            try {
                // Wait until the list is sorted and not empty.
                // Assuming the list is sorted by Sorter before Drainer is called,
                // this could wait indefinitely without a proper signaling mechanism.
                // This example assumes the Sorter notifies after sorting.
                while (theIntegerList.isEmpty() || !isSorted()) {
                    theLock.wait();
                }
                // Clear the list after confirming it's sorted
                theIntegerList.clear();
                System.out.println("List cleared by Drainer.");
                theLock.notifyAll(); // Notify the Generator to fill the list again.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

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
