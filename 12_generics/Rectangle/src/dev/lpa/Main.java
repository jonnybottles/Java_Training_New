package dev.lpa;

import dev.lpa.Rectangle;
import dev.lpa.Cube;

public class Main {
    public static void main(String[] args) {
        Rectangle theRectangle = new Rectangle(5, 2);
        // Note: I Know that I do not need to explicitly call "toString" here, I could just
        // print the object, which in turn called toString. However, the instructions explcitily said to called
        // toString, so I did so here. The end result of the code execution is the same
        System.out.println(theRectangle.toString());

        // Again explicitly calling toString here bc instructions said to
        Cube theCube = new Cube(5, 2, 10);
        System.out.println(theCube.toString());

    }
}