package com.lckdn.concurrency;

import static com.lckdn.concurrency.ColorScheme.*;

public class ConcurrentMain {

    public static void main(String[] args) {
        SimpleThread th1 = new SimpleThread();
        th1.start();


        // th2.run() - будет выводиться в потоке main()
        SimpleThread th2 = new SimpleThread();
        th2.start();


        Thread th3 = new Thread(new SimpleRunner());
        th3.start();

        th2.interrupt();

        new Thread(() -> {
            System.out.println("Hello from Lambda Runnable");
        }).start();

        System.out.println("Hello from Main()");
    }


}

class SimpleThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(YELLOW + "WARNING - " + currentThread().getName() + " was interrupted - " + i);
                e.printStackTrace();
                return;
            }
            System.out.println(GREEN + "INFO - " + currentThread().getName() + " - " + i);
        }

        if (Thread.interrupted()) {
            return;
        }
    }
}

class SimpleRunner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(YELLOW + "WARNING - " + Thread.currentThread().getName() + " was interrupted - " + i);
                e.printStackTrace();
            }
            System.out.println(GREEN + "INFO - RUNNABLE " + Thread.currentThread().getName() + " - " + i);
        }
    }
}
