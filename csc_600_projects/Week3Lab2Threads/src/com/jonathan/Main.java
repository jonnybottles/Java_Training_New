package com.jonathan;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

;

public class Main {
    public static void main(String[] args) {

        ArrayBlockingQueue<Double> threadOneQueue = new ArrayBlockingQueue<Double>(100);


        NumberGenerator taskOne = new NumberGenerator(5, 10, 1000, threadOneQueue);


        Thread threadOne = new Thread(taskOne);




    }
}