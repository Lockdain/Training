package com.lckdn.concurrency.concurrencyinpractice;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class Main {

    // Количество миллисекунд задержки при вызове в цикде
    public static final int TIME = 1000;

    // Количество выполнений цикла в каждом потоке
    public static final int QTY = 10;

    private volatile long value;

    public long getValue() {
        return value;
    }

    // Возвращает инкрементированное значение
    public synchronized long getNext() {
        return value++;
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        // Создаём общий экземпляр Main для всех потоков
        Main main = new Main();

        // Создаём потоки
        TestThread th1 = new TestThread(main, "A");
        TestThread th2 = new TestThread(main, "B");
        TestThread th3 = new TestThread(main, "C");

        // Запускаем потоки
        th1.start();
        th2.start();
        th3.start();
    }
}

class TestThread extends Thread {
    Main main;
    String threadName;

    public TestThread(Main main, String threadName) {
        this.main = main;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= Main.QTY; i++) {
            System.out.println(i + ". " + threadName + ": " + main.getNext());
            sleep(Main.TIME);
            if (i == Main.QTY) {
                System.out.println("Last cycle of " + threadName);
            }
        }
    }

    private void sleep(int timeMs) {
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
