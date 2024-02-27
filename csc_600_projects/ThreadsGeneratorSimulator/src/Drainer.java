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
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (theLock) {
                try {
                    while (theIntegerList.isEmpty() || !isSorted()) {
                        theLock.wait();
                    }
                    theIntegerList.clear();
                    System.out.println("List drained by Drainer.");
                    thePrintRunnable.run();
                    theLock.notifyAll();
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Preserve interrupt status
                }
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
