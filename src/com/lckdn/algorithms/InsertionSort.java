package com.lckdn.algorithms;

import java.util.Arrays;

public class InsertionSort {
    private static int[] sort(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
            i++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 34, 8, 12, 0})));
    }
}
