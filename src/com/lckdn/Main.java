package com.lckdn;

public class Main {

    static volatile int b = 0;
    static String s = "";

    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadA thA = new SimpleThreadA();
        SimpleThreadB thB = new SimpleThreadB();
        thA.start();
        thB.start();
    }
}

class SimpleThreadA extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            String localB = Main.s;
            System.out.println("A reads b: " + localB);
            localB = localB.concat("B-");
            System.out.println("A increments b");

                Main.s = localB;

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class SimpleThreadB extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            String localB = Main.s;
            System.out.println("B reads b: " + localB);
            localB = localB.concat("A-");
            System.out.println("B decrements b");

                Main.s = localB;

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}