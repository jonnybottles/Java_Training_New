package dev.lpa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {

    //TODO create prompt / auto coloring for error logs

    // Clears the screen based upon OS type
    public static void clearScreen() {
        // Attempt to clear the screen for terminal environments
        try {
            // Obtain OS name
            String operatingSystem = System.getProperty("os.name");

            // Checks for OS type and runs appropriate clear screen command.
            if (operatingSystem.contains("Windows")) {
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
            //TODO modify if else to look for nix. Also find a way to figure out if program is being ran in IDE
            //TODO as right now when i run this in the IDE, it detects windows and then doesn't catch the exception
            //TODO below.
        } catch (IOException | InterruptedException e) {
            // Fallback to printing new lines if the clear screen command fails
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}