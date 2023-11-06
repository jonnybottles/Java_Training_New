public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            System.out.println(i + ": " + dayOfWeek(i));
        }
    }


    public static String dayOfWeek(int day) {
        return switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> {
                yield "Invalid Day";
            }
        };
    }
}