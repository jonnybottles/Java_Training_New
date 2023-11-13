

public class Main {
    public static void main(String[] args) {

        int theSum = 0;
        int theCount = 0;
        for (int i = 1; i <= 1000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                theSum += i;
                theCount++;
                System.out.println(i);
                if (theCount == 5) {
                    break;
                }
            }
        }

        System.out.println("--------------");
        System.out.println("The Sum: " +  theSum);


    }
}