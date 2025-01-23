package org.example.model;

public class Circle extends Shape {

    @Override
    public void area() {
        int r = 10;
        System.out.println("Area of Circle is: " + 2 * 3.14 * r);
    }
}
