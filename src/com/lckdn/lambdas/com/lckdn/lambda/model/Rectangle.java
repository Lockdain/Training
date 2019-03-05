package com.lckdn.lambdas.com.lckdn.lambda.model;

public class Rectangle implements Shape {
    public Rectangle() {
        System.out.println("Creating a rectangle");
    }

    @Override
    public double calcSquare() {
        return 3;
    }
}
