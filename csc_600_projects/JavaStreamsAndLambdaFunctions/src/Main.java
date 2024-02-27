import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Sizes array for the experiment
        int[] sizes = {100, 1000, 100000, 1000000};

        calculateAndDisplayIntegerStats(100);
        calculateAndDisplayIntegerStats(1000);
        calculateAndDisplayIntegerStats(100000);
        calculateAndDisplayIntegerStats(11000000);

    }

    public static void calculateAndDisplayIntegerStats(int theSize) {
        System.out.println("The size is: " + theSize);
        Random random = new Random();

        Map<Integer, Long> frequencyMap =
                // Generates generates a stream of ints from 1-10
                Stream.generate(() -> random.nextInt(1, 11))
                        // Limits the stream to the current size
                        .limit(theSize)
                        // Creates a Map collection of Random Integers as the keys
                        // and the count <Long> of those random integers as the values in the map
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the number (1-10) and associated count of each number in the Map
        for (Map.Entry<Integer, Long> theEntry : frequencyMap.entrySet()) {
            System.out.println("Number: " + "'" + theEntry.getKey() + "'" + " Count: " + theEntry.getValue());
        }
        System.out.println();
    }

}