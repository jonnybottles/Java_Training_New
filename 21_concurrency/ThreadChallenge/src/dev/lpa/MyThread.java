package dev.lpa;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Custom thread interrupted");
                return;
            }
        }

    }
}
