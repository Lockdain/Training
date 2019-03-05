package com.lckdn.other;

public class Factorial {

    public static int recursiveFact(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return recursiveFact(n - 1) * n;
    }

    public static int fact(int n) {
        int result = 1;
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Recursive factorial: " + recursiveFact(10));
        System.out.println("Factorial: " + fact(5));
    }
}
