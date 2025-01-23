package org.example;

import org.example.model.Circle;
import org.example.model.Rectangle;
import org.example.model.Triangle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Rectangle rect = new Rectangle();
        Triangle tri = new Triangle();
        Circle cir = new Circle();

        rect.area();
        tri.area();
        cir.area();

    }
}
