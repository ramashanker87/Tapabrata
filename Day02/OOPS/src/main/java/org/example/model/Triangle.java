package org.example.model;

public class Triangle extends Shape {

    @Override
    public void area() {
        int l = 10;
        int h = 10;
        System.out.println("Area of triangle is: " + 0.5 * l * h);
    }
}
