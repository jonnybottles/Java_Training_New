package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String test = args[0];
            String test2 = args[1];
            String test3 = args[2];
            System.out.println("args " + test + " " + test2 + " " + test3);

            if (args[2].equals("-p")) {
                System.out.println("-p hit");
            }



        }
    }

    List<String> test = new ArrayList<String>();





}