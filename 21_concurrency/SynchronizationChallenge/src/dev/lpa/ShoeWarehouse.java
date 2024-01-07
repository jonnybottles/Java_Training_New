package dev.lpa;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

public class ShoeWarehouse {
    public static List<String> productList = List.of("Nike", "Brookes", "Asic", "Adidas", "New Balance");
    private static int MAX_CAPACITY = 2;

    private BlockingQueue<Order> orders;
    private static int lastOrderID = 0;
    private static int currentOrderID = 0;


    public ShoeWarehouse() {
        this.orders = new ArrayBlockingQueue<>(MAX_CAPACITY);
    }

//    Both methods should invoke the wait and notifyAll methods appropriately.

/*    The receiveOrder gets called by a Producer thread.  It should poll or loop indefinitely, checking
    the size of the list, but it should call wait if the list has reached some maximum capacity.*/
    public synchronized void receiveOrder(String shoeType, int qty)  {

        if (!isValidProduct(shoeType)) {
            System.out.println("Invalid shoe type: " + shoeType);
            return;
        }

        while(orders.size() == MAX_CAPACITY) {
            try {
                System.out.println("Order Capacity Reached.");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        Order newOrder = new Order(lastOrderID++, shoeType, qty);
        orders.add(newOrder);
        System.out.println("Received Order:" + newOrder);
    }

/*    The fulfillOrder gets called by a Consumer thread.  It should also poll the list, but it needs to
    check if the list is empty, and wait in the loop, until an order is added.*/

    public synchronized void fullFillOrder() {
        while (orders.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        notifyAll();
        Order theOrder = orders.poll();
        System.out.println("Fullfilled Order" + theOrder);
    }

    private boolean isValidProduct(String shoeType) {
        return productList.contains(shoeType);
    }

}
