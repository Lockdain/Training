package com.lckdn.lambdas.medium;

interface NumericTest {
    boolean computeTest(int n);
}

interface MyGreeting {
    String processName(String str);
}

interface MyString {
    String myStringFunction(String str);
}

interface MyGeneric<T> {
    T compute(T t);
}


class Test {
    public static void main(String[] args) {
        NumericTest isEven = (n) -> (n % 2) == 0;
        NumericTest isNegative = (n) -> (n < 0);

        System.out.println(isEven.computeTest(5));
        System.out.println(isNegative.computeTest(-5));

        MyGreeting morningGreeting = (str) -> "Good morning " + str + "!";
        MyGreeting eveningGreeting = (str) -> "Good evening " + str + "!";

        System.out.println(morningGreeting.processName("Alex"));
        System.out.println(eveningGreeting.processName("Alex"));

        // Block lambda to reverse string
        MyString reverseStr = (str) -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };

        // Output: omeD adbmaL
        System.out.println(reverseStr.myStringFunction("Lambda Demo"));

        main1();
    }

    public static void main1() {
        // String version of MyGenericInteface
        MyGeneric<String> reverse = (str) -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };

        // Integer version of MyGeneric
        MyGeneric<Integer> factorial = (Integer n) -> {
            int result = 1;

            for (int i = 1; i <= n; i++)
                result = i * result;

            return result;
        };

        // Output: omeD adbmaL
        System.out.println(reverse.compute("Lambda Demo"));

        // Output: 120
        System.out.println(factorial.compute(5));
    }
}