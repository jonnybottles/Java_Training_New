package dev.lpa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {

    public static void clearScreen() {
        // Attempt to clear the screen for terminal environments
        try {
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            // Fallback to printing new lines if the clear screen command fails
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}