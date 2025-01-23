package org.example.model;

public class Rectangle extends Shape {

    @Override
    public void area() {
        int l = 10;
        int b = 10;
        System.out.println("Area of rectangle is: " + l * b);
    }
}
