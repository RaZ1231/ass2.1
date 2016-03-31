package tests;

import org.junit.Assert;
import org.junit.Test;
import shapes.Line;
import shapes.Point;

/**
 * @author Raziel Solomon
 * @since 16-Mar-16.
 */
public class LineTest {

    @Test
    public void testLength() throws Exception {
        Line line = new Line(5, 8, 2, 4);
        double expected = 5;
        double actual = line.length();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testMiddle() throws Exception {
        Line line = new Line(1, 2, 3, 4);
        Point expected = new Point(2, 3);
        Point actual = line.middle();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testStart() throws Exception {
        Line line = new Line(1, 2, 3, 4);
        Point expected = new Point(1, 2);
        Point actual = line.start();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEnd() throws Exception {
        Line line = new Line(1, 2, 3, 4);
        Point expected = new Point(3, 4);
        Point actual = line.end();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsIntersectingTrue() throws Exception {
        Line line1 = new Line(12, 2, 9, -2);
        Line line2 = new Line(0, 0, 20, 0);
        boolean condition = line1.isIntersecting(line2);

        Assert.assertTrue(condition);
    }

    @Test
    public void testIsIntersectingFalse() throws Exception {
        Line line1 = new Line(12, 2, 9, -2);
        Line line2 = new Line(0, 0, 1, 1);
        boolean condition = line1.isIntersecting(line2);

        Assert.assertFalse(condition);
    }

    @Test
    public void testIntersectionWith() throws Exception {
        Line line1 = new Line(1, 2, 3, 2);
        Line line2 = new Line(2, 2, 3, 4);
        Point expected = new Point(2, 2);
        Point actual = line1.intersectionWith(line2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIntersectionWithNull() throws Exception {
        Line line1 = new Line(1, 2, 3, 2);
        Line line2 = new Line(2, 3, 3, 4);
        Point actual = line1.intersectionWith(line2);

        Assert.assertNull(actual);
    }

    @Test
    public void testIsInlineTrue() throws Exception {
        Line line = new Line(5, 8, 7, 8);
        Point p = new Point(6, 8);
        boolean condition = line.isInline(p);

        Assert.assertTrue(condition);
    }

    @Test
    public void testIsInlineFalse() throws Exception {
        Line line = new Line(2, 3, 3, 4);
        Point p = new Point(1, 2);
        boolean condition = line.isInline(p);

        Assert.assertFalse(condition);
    }

    @Test
    public void testCalcYAxis() throws Exception {
        Line line = new Line(-1, 5, 2, 5);
        double expected = 5;
        double actual = line.calcYAxis();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testCalcSlope() throws Exception {
        Line line = new Line(0, 0, 2, 2);
        double expected = 1;
        double actual = line.calcSlope();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testEqualsTrue() throws Exception {
        Line line1 = new Line(5, 9, 7, 8);
        Line line2 = new Line(5, 9, 7, 8);
        boolean condition = line1.equals(line2);

        Assert.assertTrue(condition);
    }

    @Test
    public void testEqualsFalseStart() throws Exception {
        Line line1 = new Line(5, 9, 7, 8);
        Line line2 = new Line(3, 9, 7, 8);
        boolean condition = line1.equals(line2);

        Assert.assertFalse(condition);
    }

    @Test
    public void testEqualsFalseEnd() throws Exception {
        Line line1 = new Line(5, 9, 7, 8);
        Line line2 = new Line(5, 9, 7, 9);
        boolean condition = line1.equals(line2);

        Assert.assertFalse(condition);
    }
}