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

    // Prints of all integers in the IntegerList using synchronized keyword to prevent multiple outputs
    // to the console at the same time
    public synchronized void print() {
        for (Integer num : theIntegerList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Creates executor service, generates the Runnable implemented classes (Generator, Sorter, Drainer)
    // and executes all threads appropriately.
    public void runSim() {
        // Creates thread pool of three threads to execute all tasks concurrently
        ExecutorService theExecutor = Executors.newFixedThreadPool(3);

        // Create all Runnable Implemented classes
        Generator theGenerator = new Generator(theIntegerList, theLock, this::print);
        Sorter theSorter = new Sorter(theIntegerList, theLock, this::print);
        Drainer theDrainer = new Drainer(theIntegerList, theLock, this::print);

        // Queues up 30 tasks to be ran across the 3 threads
        for (int i =0; i < 10; i++) {
            theExecutor.execute(theGenerator);
            theExecutor.execute(theSorter);
            theExecutor.execute(theDrainer);
        }

        //Shutdown the executor service, stopping all threads.
        theExecutor.shutdown();

    }

}
