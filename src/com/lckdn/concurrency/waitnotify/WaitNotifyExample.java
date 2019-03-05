package com.lckdn.concurrency.waitnotify;

import static com.lckdn.concurrency.ColorScheme.BLUE;
import static com.lckdn.concurrency.ColorScheme.RED;

public class WaitNotifyExample {

    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();
    }

    private static class Producer implements Runnable {

        private final Message message;

        public Producer(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void produce() throws InterruptedException {
            for (String t : text) {
                synchronized (message) {
                    System.out.println(BLUE + "Producing message: " + t);
                    message.setMessage(t);
                    message.notify();
                    if (!"DONE".equals(t)) {
                        message.wait();
                    }
                }
                Thread.sleep(400);
            }
        }

        String[] text = {"Whose woods these are I think I know.",
                "His house is in the village though;",
                "He will not see me stopping here",
                "To watch his woods fill up with snow.",
                "DONE"};
    }

    private static class Consumer implements Runnable {

        private final Message message;

        public Consumer(Message message) {
            this.message = message;
        }

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
                Thread.sleep(400);
                synchronized (message) {
                    System.out.println(RED + "Consuming message: " + message.getMessage());
                    if (!"DONE".equals(message.getMessage())) {
                        message.notify();
                        message.wait();
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
