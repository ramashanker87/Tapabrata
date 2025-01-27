package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

public class AppTest{

    @Test
    public void testSquare(){
        Calculator calc = new Calculator();
        double result = calc.square(4);
        assert result== 16;
    }
    @Test
    public void testDivision(){
        Calculator calc = new Calculator();
        double result = calc.division(10,2);
        assert result== 5;
    }
}
