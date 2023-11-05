public class main {
    public static void main(String[] args) {
        if (hasTeen(23, 25, 42)) {
            System.out.println("Has Teen");
        } else {
            System.out.println("Does not have teen");
        }
    }


    public static boolean hasTeen(int num1, int num2, int num3) {
        return (num1 >= 13 && num1 <= 19) || (num2 >= 13 && num2 <= 19) || (num3 >= 13 && num3 <= 19);
    }


}
