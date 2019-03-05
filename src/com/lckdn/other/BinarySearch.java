package com.lckdn.other;

public class BinarySearch {

    public static int find(int[] a, int m) {
        int high = a.length - 1;
        int mid = 0;
        int low = 0;

        while (low <= high) {
            mid = (high + low) / 2;
            if (a[mid] == m)
                return mid;

            if (a[mid] > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        System.out.println(find(a, 10));
    }
}
