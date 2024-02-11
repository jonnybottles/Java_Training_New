package com.jonathan.namemaintenance.datamodel;

public class Utilities {


    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        // Split the string into words
        String[] words = str.split("\\s+");
        StringBuilder capitalizedString = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                // Capitalize the first letter and append the rest of the word
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                capitalizedString.append(capitalizedWord).append(" ");
            }
        }

        // Return the string, trimming trailing space
        return capitalizedString.toString().trim();
    }


}