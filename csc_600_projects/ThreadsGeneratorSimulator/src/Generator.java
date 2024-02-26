import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generator implements Runnable{

    private List<Integer> theIntegerList;
    private final Object theLock;
    private final Runnable thePrintRunnable;

    public Generator(List<Integer> theIntegerList, Object theLock, Runnable thePrintRunnable) {
        this.theIntegerList = theIntegerList;
        this.theLock = theLock;
        this.thePrintRunnable = thePrintRunnable;
    }


    private int generateRandomInteger() {
        return ThreadLocalRandom.current().nextInt(1, 100);
    }

    private void fillList() {
        for (int i = 0; i < 10; i++) {
            theIntegerList.add(generateRandomInteger());
        }
    }

    @Override
    public void run() {
        synchronized (theLock) {
            // Assuming the Generator runs first, it doesn't need to wait.
            fillList();
            theLock.notifyAll(); // Notify the next process, which is sorting.
        }
    }

}
