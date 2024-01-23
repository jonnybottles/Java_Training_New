package dev.lpa;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ShoeWarehouse theShoeWarehouse = new ShoeWarehouse();



        Thread producerThread1 = new Thread(() -> {
            theShoeWarehouse.receiveOrder("Nike", 3);
        });

        Thread producerThread2 = new Thread(() -> {
            theShoeWarehouse.receiveOrder("Brookes", 5);
        });

        Thread producerThread3 = new Thread(() -> {
            theShoeWarehouse.receiveOrder("Asic", 7);
        });

        producerThread1.start();
        producerThread2.start();
        producerThread3.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread consumerThread1 = new Thread(theShoeWarehouse::fullFillOrder);
        Thread consumerThread2 = new Thread(theShoeWarehouse::fullFillOrder);
        Thread consumerThread3 = new Thread(theShoeWarehouse::fullFillOrder);

        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

    }
}
// chatgpt produced test code:
/*

package dev.lpa;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ShoeWarehouse theShoeWarehouse = new ShoeWarehouse();

        // Create multiple producer threads
        for (int i = 0; i < 10; i++) {
            String shoeType = theShoeWarehouse.productList.get(i % theShoeWarehouse.productList.size());
            int quantity = (i + 1) * 2;

            Thread producerThread = new Thread(() -> {
                System.out.println("Attempting to place order: " + shoeType + " x " + quantity);
                theShoeWarehouse.receiveOrder(shoeType, quantity);
            });

            producerThread.start();
        }

        // Allow some time for producers to add orders
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create multiple consumer threads
        for (int i = 0; i < 10; i++) {
            Thread consumerThread = new Thread(() -> {
                theShoeWarehouse.fullFillOrder();
            });

            consumerThread.start();
        }
    }
}
*/
