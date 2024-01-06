package dev.lpa;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        Runnable myRunnable = () -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread runnableThread = new Thread(myRunnable);
        runnableThread.start();

        try {
            TimeUnit.SECONDS.sleep(4);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}