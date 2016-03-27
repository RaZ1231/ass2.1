package tests;

import shapes.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Raziel Solomon
 * @since 15-Mar-16.
 */
public class PointTest {

    @Test
    public void testDistance() throws Exception {
        Point p1 = new Point(5, 8);
        Point p2 = new Point(2, 4);
        double expected = 5;
        double actual = p1.distance(p2);

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testEqualsTrue() throws Exception {
        Point p1 = new Point(5, 8);
        Point p2 = new Point(5, 8);
        boolean condition = p1.equals(p2);

        Assert.assertTrue(condition);
    }

    @Test
    public void testEqualsFalse() throws Exception {
        Point p1 = new Point(5, 8);
        Point p2 = new Point(6, 8);
        boolean condition = p1.equals(p2);

        Assert.assertFalse(condition);
    }

    @Test
    public void testEqualsFalseObj() throws Exception {
        Point p1 = new Point(5, 8);
        boolean condition = p1.equals(5);

        Assert.assertFalse(condition);
    }

    @Test
    public void testGetX() throws Exception {
        Point p1 = new Point(5, 8);
        double expected = 5;
        double actual = p1.getX();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testGetY() throws Exception {
        Point p1 = new Point(5, 8);
        double expected = 8;
        double actual = p1.getY();

        Assert.assertEquals(expected, actual, 0);
    }
}