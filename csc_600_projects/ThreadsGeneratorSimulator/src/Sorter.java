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

    @Override
    public void run() {
        synchronized (theLock) {
            try {
                while (theIntegerList.isEmpty()) { // Wait until the list is filled
                    theLock.wait();
                }
                Collections.sort(theIntegerList);
                theLock.notifyAll(); // Notify the next process, which could be draining or refilling.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
