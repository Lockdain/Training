package com.lckdn.concurrency.volatileEx;

import static com.lckdn.concurrency.ColorScheme.GREEN;
import static com.lckdn.concurrency.ColorScheme.RED;

public class VolatileMain {

    private static volatile int counter;
    private static int x;
    private static int y;

    public static void main(String[] args) {
        new SimpleWriter().start();
        new SimpleReader().start();
    }

    /**
     * X и Y - не помечены 'volatile'. Несмотря на это, т. к. они изменяются в одном методе с counter,
     * который помечен как volatile, фактически их поведение также будет volatile, т. е. будут видны для всех потоков.
     */
    private static void update() {
        counter++;
        x++;
        y++;
    }

    private static class SimpleWriter extends Thread {
        @Override
        public void run() {
            int localCounter = counter;
            for (int i = 0; i < 10; i++) {
                System.out.println(GREEN + "Writer increments counter " + (localCounter + 1));
                counter = ++localCounter;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class SimpleReader extends Thread {

        @Override
        public void run() {
            int localCounter = counter;
            while (localCounter < 10) {
                if (localCounter != counter) {
                    System.out.println(RED + "Reader reads counter " + counter);
                    localCounter = counter;
                }
            }
        }
    }
}
