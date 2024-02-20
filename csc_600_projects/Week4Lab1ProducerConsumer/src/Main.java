import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {





    }


    public static List<Thread> createProducerThreads(Buffer buffer, int numProducers) {
        List<Thread> producerThreadsList = new ArrayList<>();
        for (int i = 0; i < numProducers; i++) {
            Producer producer = new Producer(buffer);
            Thread thread = new Thread(producer, "Producer-" + i);
            producerThreadsList.add(thread);
        }

        return producerThreadsList;
    }

}