import java.util.List;

public class Main {
    public static void main(String[] args) {

        String sentence = "Hello, World!";

        boolean matches = sentence.matches("Hello, World!");

        System.out.println(matches);

        String challengeTwo = "^[A-Z].*[.]$";

//        for (String s : List.of("The bike is red.",
//                "I am a new student.",
//                "hello world.",
//                "How are you?")) {
//            boolean matched = s.matches(challengeTwo);
//            System.out.println(matched + ": " + s);
//        }

        String challengeThree = "^[A-Z].*[.!?]$";

        for (String s : List.of("The bike is red, and has flat tires.",
                "I love being a new L.P.A student!",
                "Hello, friends and family: Welcome!",
                "How are you, Mary?")) {
            boolean matched = s.matches(challengeThree);
            System.out.println(matched + ": " + s);
        }

    }
}