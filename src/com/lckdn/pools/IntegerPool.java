package com.lckdn.pools;

public class IntegerPool {

    public static void main(String[] args) {
        Integer a = 110;
        Integer b = 110;
        // Вернёт true
        System.out.println(a == b);

        Integer f = 200;
        Integer g = 200;
        // Вернёт false
        System.out.println(f == g);

        Integer d = new Integer(15);
        Integer e = 2;
        // Вернёт false
        System.out.println(d == e);
        String str1 = "abc";
        String str2 = "ab" + new String("c");

        System.out.println(str1 == str2);
    }
}
