package org.example;

/**
 * Hello world!
 *
 */
public class Calculator
{
    public double square(double value){
        return value*value;
    }

    public double division(double first, double second){
        if(second == 0){
            throw new ArithmeticException("Cant divide by 0");
        }
        return first/second;
    }
}
