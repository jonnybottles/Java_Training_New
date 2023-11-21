public class Main {
    public static void main(String[] args) {
        printInformation("Hello World");
        printInformation("");
        printInformation("\t    \n");

        String helloWorld = "Hello World";
        System.out.printf("Index of r = %d %n", helloWorld.indexOf('r'));
        System.out.printf("Index of World = %d %n", helloWorld.indexOf("World"));
        System.out.printf("Index of l = %d %n", helloWorld.indexOf('l'));
        System.out.printf("Index of l = %d %n", helloWorld.lastIndexOf('l'));

        System.out.printf("Index of l = %d %n", helloWorld.indexOf('l', 3));
        System.out.printf("Index of l = %d %n", helloWorld.lastIndexOf('l', 8));

        String hellowWorldLower = helloWorld.toLowerCase();
        if (helloWorld.equals(hellowWorldLower)) {
            System.out.println("Values match exactly");
        }

        if (helloWorld.equalsIgnoreCase(hellowWorldLower)) {
            System.out.println("Values match ignoring case");
        }

        if (helloWorld.startsWith("Hello")) {
            System.out.println("String starts with hello");
        }

        if (helloWorld.endsWith("World")) {
            System.out.println("String end with World");
        }

        if (helloWorld.contains("World")) {
            System.out.println("String contains World");
        }

        if (helloWorld.contentEquals("Hello World")) {
            System.out.println("Values match exactly");
        }


    }

    public static void printInformation(String string) {
        int length = string.length();
        System.out.printf("Length = %d %n", length);

        if (string.isEmpty()) {
            System.out.println("String is empty");
            return;
        }

        if (string.isBlank()) {
            System.out.println("String is Blank");
            return;
        }
        System.out.printf("First char = %c %n", string.charAt(0));

        System.out.printf("Last char = %c %n", string.charAt(length -1));

    }
}