import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulation {
    private List<Integer> theIntegerList;
    private final Object theLock;

    public Simulation() {
        this.theIntegerList = new ArrayList<>();
        this.theLock = new Object();
    }

    public synchronized void print() {
        for (Integer num : theIntegerList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void runSim() {
        ExecutorService theExecutor = Executors.newFixedThreadPool(3);

        Generator theGenerator = new Generator(theIntegerList, theLock, this::print);
        Sorter theSorter = new Sorter(theIntegerList, theLock, this::print);
        Drainer theDrainer = new Drainer(theIntegerList, theLock, this::print);

        for (int i =0; i < 10; i++) {
            theExecutor.execute(theGenerator);
            theExecutor.execute(theSorter);
            theExecutor.execute(theDrainer);
        }

        theExecutor.shutdown();

    }

}
