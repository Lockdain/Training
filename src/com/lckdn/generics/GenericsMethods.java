package com.lckdn.generics;

public class GenericsMethods {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 0, 8, 5, 6};
        Double[] doubleArray = {0.234, 6.45, 9.034, 1.345, 4.675};
        String[] stringArray = {"abc", "vfr", "rtw", "ert"};

        printArray(intArray);
        printArray(doubleArray);
        printArray(stringArray);

        Integer max = findMax(intArray);

        System.out.println("Max for array of Integers " + max);

        Double max1 = findMax(doubleArray);
        System.out.println("Max for array of Doubles " + max1);
//        System.out.println("Max for array of Strings " + findMax(stringArray));

    }

    private static <T> void printArray(T[] intArray) {
        System.out.println("Generic method called...");
        for (T element : intArray) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    private static <T extends Number & Comparable> T findMax(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
          if (array[i].compareTo(max) > 0)
              max = array[i];
        }
        return max;
    }
}
