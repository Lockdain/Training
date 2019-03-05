package com.lckdn.other;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main {
    public static void main(String[] args) {
        A p = new B();
        p.getA();
        System.out.println(p.a);
        p.print();
    }
}

class A {
    String a = "A";

    String getA() {
        return this.a;
    }

    protected void print(){
        System.out.println(a);
    }
}

class B extends A{
    String a = "B";

    @Override
    public  void print(){
        System.out.println(a);
    }
}
