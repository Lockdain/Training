package com.lckdn.concurrency.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> test = new ConcurrentHashMap<>(200, 0.75F, 32);
        for (int i = 0; i < 200; i++) {
            test.put(String.valueOf(i), i + 5);
        }
    }
}
