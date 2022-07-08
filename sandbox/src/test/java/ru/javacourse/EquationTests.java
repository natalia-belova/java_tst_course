package ru.javacourse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

    @Test
    public void testD1() {
        Equation e = new Equation(1, 1, 1);
        Assert.assertEquals(e.rootQuantity(), 0);
    }

    @Test
    public void testD2() {
        Equation e = new Equation(1, 5, 6);
        Assert.assertEquals(e.rootQuantity(), 2);
    }

    @Test
    public void testD3() {
        Equation e = new Equation(1, 2, 1);
        Assert.assertEquals(e.rootQuantity(), 1);
    }


}
