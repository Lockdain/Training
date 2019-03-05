package com.lckdn.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static com.lckdn.concurrency.ColorScheme.RED;

public class Launcher {
    private static final int POOL_SIZE = 2;

    public static void main(String[] args) {
        boolean isDaemon = true;

        System.out.println(RED + "Starting main thread");
        GCDRunnable r = new GCDRunnable(isDaemon);
//        runInOneThread(r, isDaemon);
        try {
            runWithExecutors(r, isDaemon);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(RED + "Leaving the main thread");
    }

//    private static void runInOneThread(GCDRunnable r, boolean isDaemon) {
//        Thread th = new Thread(r);
//        th.setDaemon(isDaemon);
//        th.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        th.interrupt();
//    }

    private static void runWithExecutors(GCDRunnable r, boolean isDaemon) throws InterruptedException {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                if (isDaemon) {
                    thread.setDaemon(true);
                }
                return thread;
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE, factory);
        for (int i = 0; i < 5; i++) {
            executorService.execute(r);
        }
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
    }
}
