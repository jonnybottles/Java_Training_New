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
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (theLock) {
                try {
                    while (theIntegerList.size() != 10) {
                        theLock.wait();
                    }
                    Collections.sort(theIntegerList);
                    System.out.println("List sorted by Sorter.");
                    thePrintRunnable.run();
                    theLock.notifyAll();
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Preserve interrupt status
                }
            }
        }
    }
}
