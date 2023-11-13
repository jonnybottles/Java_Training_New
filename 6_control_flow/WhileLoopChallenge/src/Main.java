public class Main {
    public static void main(String[] args) {

        int start = 5;
        int stop = 21;
        int evenCount = 0;
        int oddCount = 0;
        while (start < stop) {
            if (isEvenNumber(start)) {
                System.out.println("Even Number Found: " + start);
                evenCount++;
            } else {
                System.out.println("Odd Number Found: " + start);
                oddCount++;
            }
            start++;
        }

        System.out.println("Even Count: "  + evenCount);
        System.out.println("Odd Count: " + oddCount);


    }



    public static boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }

}