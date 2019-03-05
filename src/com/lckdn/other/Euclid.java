package com.lckdn.other;

public class Euclid {

    /**
     * Рекурсивная реализация алгоритма Евклида дл поиска НОД двух целых чисел.
     * @param a
     * @param b
     * @return
     */
    public static int maxPrime(int a, int b) {
        if (a == b) {
            return a;
        }

        int max = 0;
        int min = 0;

        if (a > b) {
            max = a;
            min = b;
        } else {
            min = a;
            max = b;
        }
        return maxPrime(min, max - min);
    }

    public static void main(String[] args) {
        System.out.println(maxPrime(1071, 462));
    }
}
