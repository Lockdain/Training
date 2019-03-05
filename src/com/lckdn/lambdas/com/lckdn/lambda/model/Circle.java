package com.lckdn.lambdas.com.lckdn.lambda.model;

public class Circle extends Ellipsis implements Shape, AnotherShape{
    public Circle() {
        System.out.println("Creating a circle");
    }

    @Override
    public double calcSquare() {
        return 1;
    }

    public double calcSomething() {
        return super.calcSomething();
    }
}
