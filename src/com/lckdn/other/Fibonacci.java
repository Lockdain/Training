package com.lckdn.other;

public class Fibonacci {

    public static int getF(int n) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for (int i = 0; i <= n; i++) {
            p1 = i;
            p2 = i - 1;
            p3 = p1 + p2;
        }

        return p3;
    }

    public static int recursive(int n) {
        if (n == 0)
            return 0;

        else if (n == 1)
            return 1;

        else
            return recursive(n - 1) + recursive(n - 2);
    }

    public static void main(String[] args) {
//        System.out.println(getF(5));
        System.out.println(recursive(10));
    }
}
