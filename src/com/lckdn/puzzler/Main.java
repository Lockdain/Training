package com.lckdn.puzzler;

public class Main {
    public static void main(String[] args) {
        try {
            Test.run();
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println(e.getCause());
            Test.run();
        }
    }
}

class Test {
    static {
        if (true) throw new RuntimeException();
    }

    public static void run() {
        System.out.println("Hi!");
    }
}

// Что будет выведено на консоль?

//1. Hi!
//2. RuntimeException
//3. ExceptionInInitializer
//4. NoClassDefFoundError