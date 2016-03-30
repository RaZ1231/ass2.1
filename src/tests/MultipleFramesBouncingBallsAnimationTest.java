package tests;

import art.MultipleFramesBouncingBallsAnimation;
import org.junit.Test;

/**
 * @author Raziel Solomon
 * @since 27-Mar-16.
 */
public class MultipleFramesBouncingBallsAnimationTest {

    @Test
    public void main() throws Exception {
        String[] input = {"test", "12", "32", "34", "54", "11", "19", "20", "30"};
        MultipleFramesBouncingBallsAnimation.main(input);

    }
}