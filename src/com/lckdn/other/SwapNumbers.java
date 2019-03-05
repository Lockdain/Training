package com.lckdn.other;

public class SwapNumbers {

    public static void swap(int a, int b) {
        System.out.println("Before: a= " + a + " b=" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After: a= " + a + " b=" + b);
    }

    public static void main(String[] args) {
        swap(1, 2);
    }
}
