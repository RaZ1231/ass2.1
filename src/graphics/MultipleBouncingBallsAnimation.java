package graphics;

import collections.ArrayOfBalls;
import shapes.Point;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import static utils.Mathematics.stringsToInts;
import static java.util.Arrays.copyOfRange;

/**
 * @author Raziel Solomon
 * @since 17-Mar-16.
 */

/**
 * Class draws bouncing balls on screen.
 */
public class MultipleBouncingBallsAnimation {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    /**
     * Accessing point.
     *
     * @param args balls sizes
     */
    public static void main(String[] args) {
        MultipleBouncingBallsAnimation drawing = new MultipleBouncingBallsAnimation();
        drawing.drawRandomBalls(copyOfRange(args, 1, args.length), WIDTH, HEIGHT);
    }

    /**
     * Draws bouncing balls on screen.
     *
     * @param sizes  balls sizes
     * @param width  frame width
     * @param height frame height
     */
    public void drawRandomBalls(String[] sizes, int width, int height) {
        GUI gui = new GUI("Multiple Bouncing Balls Animation", width, height);
        Sleeper sleeper = new Sleeper();
        ArrayOfBalls balls = new ArrayOfBalls(sizes.length);

        balls.generateRandomBalls(stringsToInts(sizes), new Point(0, 0), new Point(width, height));
        balls.setVelocities();
        while (true) {
            balls.moveBalls(new Point(0, 0), new Point(width, height));
            DrawSurface d = gui.getDrawSurface();
            balls.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
