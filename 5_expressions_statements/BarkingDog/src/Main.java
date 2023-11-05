// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        if (shouldWakeUp(true, -1)) {
            System.out.println("Wake up");
        } else {
            System.out.println("Do not wake up");
        }



    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        boolean wakeUp = true;

        if (!barking || !isValidHour(hourOfDay) || (hourOfDay >= 8 && hourOfDay <=22)) {
            wakeUp = false;
        }

        return wakeUp;
    }

    public static boolean isValidHour(int hourOfDay) {
        return hourOfDay >= 0 && hourOfDay <= 23;
    }

}