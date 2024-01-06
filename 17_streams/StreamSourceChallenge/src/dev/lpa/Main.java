package dev.lpa;

/*
  B1 -  B15
  I16 - I30
  N31 - N45
  G45 - G60
  O61 - O75

 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        List<String> bingoLettersBravo = createBingoLetterList("B");
//        bingoLettersBravo.forEach(System.out::println);
//        var bingoLetterBravoStream = bingoLettersBravo.stream();

        var bStream = Stream.of("B-1", "B-2", "B-3", "B-4", "B-5", "B-6", "B-7", "B-8", "B-9", "B-10", "B-11", "B-12",
                "B-13", "B-14", "B-15");

//        bStream.forEach(System.out::println);

        var iStream = Stream.iterate(1, i-> i + 1 )
                .limit(15)
                .map(e -> "I-" + e);

//        iStream.forEach(System.out::println);

        var nStream = Stream.iterate(1, i -> i <= 15, i -> i +1)
                .map(e -> "N-" + e);

//        nStream.forEach(System.out::println);
        Random random = new Random();
        var gStream = Stream.generate(() -> random.nextInt(1, 16))
                .limit(300)
                .takeWhile(i -> i >= 1 && i <= 15)
                .distinct()
                .sorted()
                .map(i -> "G-" + i);

//        gStream.forEach(System.out::println);

        var oStream = IntStream.range(1, 16)
                .boxed()
                .map(i -> "O-" + i);

//        oStream.forEach(System.out::println);

        var biStream = Stream.concat(bStream, iStream);
        var binStream = Stream.concat(biStream, nStream);
        var bingStream = Stream.concat(binStream, gStream);
        var bingoStream = Stream.concat(bingStream,oStream);

        bingoStream.forEach(System.out::println);







        
    }

//    public static List<String> createBingoLetterList(String theChar) {
//        List<String> theBingoLetterList = new ArrayList<>();
//        for (int i = 1; i < 16; i++) {
//            theBingoLetterList.add(theChar + i);
//        }
//
//        return theBingoLetterList;
//    }

}