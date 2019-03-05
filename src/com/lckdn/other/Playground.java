package com.lckdn.other;

import javax.swing.*;

public class Playground {

    /**
     * Рекурсивная функция для вывода на печать чисел от n до 0.
     */
    public static int countdown(int n) {
        if (n == 0) {
            return 0;
        }

        System.out.println(n);
        return countdown(n-1);
    }

    /**
     * Рекурсивная функция для вывода чисел от 0 до n.
     * @return
     */
    public static int count(int n, int counter) {
        if (n < 0)
            throw new IllegalArgumentException();
        int i = 0;
        if (n == counter)
            return n;

        System.out.println(n);

        return count(i+1, counter);
    }

    public static void main(String[] args) {
//        System.out.println(countdown(50));
        System.out.println(count(20, 0));
    }
}
