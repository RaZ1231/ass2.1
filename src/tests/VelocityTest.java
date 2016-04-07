package tests;

import motion.Velocity;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Elisheva
 * @since 05/04/2016.
 */
public class VelocityTest {

    @Test
    public void getSpeed() throws Exception {
        double expected = 5;
        Velocity v = Velocity.fromAngleAndSpeed(90, expected);
        double actual = v.getSpeed();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getAngle() throws Exception {
        double expected = 34;
        Velocity v = Velocity.fromAngleAndSpeed(expected, 3);
        double actual = v.getAngle();

        Assert.assertEquals(expected, actual, 0);

    }
}