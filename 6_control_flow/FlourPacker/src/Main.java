public class Main {
    public static void main(String[] args) {
        System.out.println(canPack(2, 2, 11));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount == 0 && smallCount > 0) {
            if (smallCount >= goal) {
                System.out.println("first if");

                return true;
            } else {
                return false;
            }
        }

        if (bigCount > 0 && smallCount == 0) {
            if (((bigCount * 5) % goal) == 0){
                System.out.println("second if");
                return true;
            } else {
                return false;
            }
        }

        int bigCounttotal = bigCount * 5;
        if (((bigCounttotal) % goal) != 0 && smallCount >= (goal - bigCounttotal)) {
            return true;
        }
        return false;

    }
}