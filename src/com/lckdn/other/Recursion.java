package com.lckdn.other;

import java.util.Arrays;

public class Recursion {

    /**
     * Рекурсивно печатает числа от top до buttom с шагом 1.
     *
     * @param top
     * @param bottom
     */
    public static void descPrint(int top, int bottom) {

        if (top == bottom) {
            System.out.println(top);
            return;
        }
        System.out.println(top);
        descPrint(top - 1, bottom);
    }

    /**
     * Рекурсивно печатает числа от bottom до top с шагом 1.
     *
     * @param top
     * @param bottom
     */
    public static void ascPrint(int top, int bottom) {
        System.out.println(top);
        if (top == bottom) {
            System.out.println(bottom);
            return;
        }
        descPrint(top - 1, bottom);
    }

    public static void printStringDesc(int index, String s) {
        if (s == null || index >= s.length()) {
            return;
        }

        printStringDesc(index + 1, s);
        System.out.println(s.charAt(index));
    }

    public static void reverseChar(char[] s) {
        int start = 0;
        char n = s[start];
        s[start] = s[s.length - 1];
        s[s.length - 1] = n;

        reverseChar(s);
    }

    public static char[] reverseString(char[] s) {
        if (s.length == 1) {
            return s;
        }

        if (s.length == 0) {
            return s;
        }

        int counter = 0;
        int begin = 0;
        int end = 0;
        while (counter < s.length / 2) {
            counter++;
            char temp = s[begin];
            s[begin] = s[s.length - counter];
            s[s.length - counter] = temp;
            begin++;
        }
        return s;
    }
}

//    public static void reverseCharRec(String s) {
//        int n = 0;
//        if (n == s.length()) {
//            return;
//        }
//        System.out.println(s.substring(n));
//        reverseCharRec(s.substring(n + 1), 0);
//    }
//
//    public static void main(String[] args) {
////        descPrint(10, 5);
////        ascPrint(20, -10);
////        printStringDesc(0, "abcd");
////        reverseChar(new char[] {'m', 'i', 'k', 'e'});
////        System.out.println(Arrays.toString(reverseString(new char[] {'m', 'i', 'k', 'e', 's'})));
//        reverseCharRec("abcd", 0);
//    }
//}
