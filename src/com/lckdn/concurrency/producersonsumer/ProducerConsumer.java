package com.lckdn.concurrency.producersonsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

import static com.lckdn.concurrency.ColorScheme.GREEN;
import static com.lckdn.concurrency.ColorScheme.RED;
import static java.sql.Types.TIME;

public class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    private static class Producer implements Runnable {
        String[] messages = {"Whose woods these are I think I know.",
                "His house is in the village though;",
                "He will not see me stopping here",
                "To watch his woods fill up with snow.",
                "DONE"};
        private int TIME;


        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void produce() throws InterruptedException {
            Random r = new Random();
            for (int i = 0; i < messages.length; i++) {
                queue.put(messages[i]);
                System.out.println(GREEN + "Producing " + messages[i] + ". " + "Queue size is: " + queue.size());
                TIME = 3000;
                Thread.sleep(r.nextInt(TIME));
            }
        }
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            while (true) {
                String message = queue.take();
                System.out.println(RED + "Consuming " + message + " Queue size is " + queue.size());
                long millis = new Random().nextInt(2000);
                if (!"DONE".equals(message)) {
                    Thread.sleep(millis);
                } else {
                    return;
                }
            }
        }
    }
}
