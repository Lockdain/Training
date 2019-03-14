package com.lckdn.concurrency.concurrencyinpractice;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class Main {

    public static final int TIME = 1;
    public static final int QTY = 10;
    private volatile long value;

    public long getValue() {
        return value;
    }

    // Returns unique value
    public synchronized long getNext() {
        return value++;
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        ThreadA th1 = new ThreadA(main);
        ThreadB th2 = new ThreadB(main);
        ThreadC th3 = new ThreadC(main);
        th1.start();
        th2.start();
        th3.start();
    }
}

class ThreadA extends Thread {

    Main main;

    public ThreadA(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        for (int i = 0; i <= Main.QTY; i++) {
            System.out.println("A: " +  main.getNext());
            try {
                Thread.sleep(Main.TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == Main.QTY) {
                System.out.println("Last cycle of A");
            }
        }
    }
}

class ThreadB extends Thread {

    Main main;

    public ThreadB(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        for (int i = 0; i <= Main.QTY; i++) {
            System.out.println("B: " +  main.getNext());
            try {
                Thread.sleep(Main.TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == Main.QTY) {
                System.out.println("Last cycle of B");
            }
        }
    }
}

class ThreadC extends Thread {

    Main main;

    public ThreadC(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
        for (int i = 0; i <= Main.QTY; i++) {
            System.out.println("C: " + main.getNext());
            try {
                Thread.sleep(Main.TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == Main.QTY) {
                System.out.println("Last cycle of C");
            }
        }
    }
}