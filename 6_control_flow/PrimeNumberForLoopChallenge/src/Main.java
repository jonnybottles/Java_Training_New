public class Main {
    public static void main(String[] args) {
        System.out.println(primeCounter(12));
    }


    public static int primeCounter(int num) {
        int primeCount = 0;
        for (int i = 0; i < num; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        return primeCount;
    }



    public static boolean isPrime(int num) {
        if (num <= 2) {
            return (num == 2);
        }

        for (int divisor = 2; divisor <= num / 2; divisor++) {
            if (num % divisor == 0) {
                return false;
            }
        }
        return true;
    }

}