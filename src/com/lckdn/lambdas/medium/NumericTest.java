package com.lckdn.lambdas.medium;

interface NumericTest {
    boolean computeTest(int n);
}

interface MyGreeting {
    String processName(String str);
}

class Test {
    public static void main(String[] args) {
        NumericTest isEven = (n) -> (n % 2) == 0;
        NumericTest isNegative = (n) -> (n < 0);

        System.out.println(isEven.computeTest(5));
        System.out.println(isNegative.computeTest(-5));

        MyGreeting morningGreeting = (str) -> "Good morning " + str + "!";
        MyGreeting eveningGreeting = (str) -> "Good evening " + str + "!";

        System.out.println(morningGreeting.processName("Alex"));
        System.out.println(eveningGreeting.processName("Alex"));
    }
}