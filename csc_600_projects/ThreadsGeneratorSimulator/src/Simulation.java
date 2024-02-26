import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulation {
    private List<Integer> theIntegerList;
    private final Object theLock;

    public Simulation(List<Integer> theIntegerList, Object theLock) {
        this.theIntegerList = new ArrayList<>();
        this.theLock = theLock = new Object();
    }

    public synchronized void print() {
        for (Integer num : theIntegerList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void runSim() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Generator theGenerator = new Generator(theIntegerList, theLock, )


    }

}
