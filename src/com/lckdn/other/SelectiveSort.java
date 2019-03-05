package com.lckdn.other;

import java.util.Arrays;

public class SelectiveSort {

    public static void sort(int[] ints) {
        int max = 0;
        int[] sorted = new int[ints.length];
        int sortedIndex = 0;

        if (ints.length == 0)
            return;

        max = ints[0];

        while (sortedIndex < ints.length) {
           int maxIndex = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == -200)
                continue;
            if (ints[i] > max) {
                max = ints[i];
                maxIndex = i;
            }
        }
        ints[maxIndex] = -200;
        sorted[sortedIndex] = max;
        max = 0;
        sortedIndex++;
        }
        System.out.println(Arrays.toString(sorted));
    }

    public static void main(String[] args) {
        int[] n = {1, 12, 5, 16, 82, 15};
        sort(n);
    }
}
