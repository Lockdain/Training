package com.lckdn.other;

public class Habr {

    final static int N = 7;

    public static void main(String[] args) {
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                System.out.print(i);
                continue;
            }

            if (i % 2 == 0) {
                System.out.println();
                for (int b = i; b > 0; b--) {
                    if (b != 1) {
                        System.out.print(b + "-");
                    } else {
                        System.out.print(b);
                    }
                }
            } else {
                System.out.println();
                for (int n = 1; n <= i; n++) {
                    if (n == i) {
                        System.out.print(n);
                    } else {
                        System.out.print(n + "-");
                    }
                }
            }

        }
    }
}
