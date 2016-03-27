package tests;

import graphics.MultipleBouncingBallsAnimation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Raziel Solomon
 * @since 23-Mar-16.
 */
public class MultipleBouncingBallsAnimationTest {

    @Test
    public void mainTest() throws Exception {
        String[] args = {"test","56","23","42","10","34","5","23","6"};
        MultipleBouncingBallsAnimation.main(args);
    }
}