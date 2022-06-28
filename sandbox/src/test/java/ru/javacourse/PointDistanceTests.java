package ru.javacourse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointDistanceTests {
    // y difference
    @Test
    public void testDistance1() {
        Point p1 = new Point(2, -3);
        Point p2 = new Point(2, 0);
        Assert.assertEquals(p1.distance(p2), 3);

    }

    //x difference
    @Test
    public void testDistance2() {
        Point p1 = new Point(4, 0);
        Point p2 = new Point(2, 0);
        Assert.assertEquals(p1.distance(p2), 2);
    }

    //2 diff
    @Test
    public void testDistance3() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(3, 4);
        Assert.assertEquals(p1.distance(p2), 1.4142135623730951);
    }

    //no diff
    @Test
    public void testDistance4() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 2);
        Assert.assertEquals(p1.distance(p2), 0);
    }
}
