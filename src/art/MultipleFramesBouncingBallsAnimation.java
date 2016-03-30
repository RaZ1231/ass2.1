package art;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import collections.ListOfFrames;
import shapes.Point;
import shapes.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Mathematics.stringsToInts;

/**
 * @author Raziel Solomon
 * @since 17-Mar-16.
 */

/**
 * Draws two frames of bouncing balls on screen.
 */
public class MultipleFramesBouncingBallsAnimation {
    public static final int WIDTH = 650;
    public static final int HEIGHT = 650;

    /**
     * Accessing point.
     *
     * @param args sizes of balls
     */
    public static void main(String[] args) {
        int[] intArgs = stringsToInts(Arrays.copyOfRange(args, 1, args.length));
        List<int[]> sizes = new ArrayList<int[]>();
        List<Rectangle> rects = new ArrayList<Rectangle>();
        MultipleFramesBouncingBallsAnimation mbba = new MultipleFramesBouncingBallsAnimation();

        sizes.add(Arrays.copyOfRange(intArgs, 0, intArgs.length / 2));
        sizes.add(Arrays.copyOfRange(intArgs, intArgs.length / 2, intArgs.length));

        rects.add(new Rectangle(new Point(50, 50), new Point(500, 500), Color.GRAY));
        rects.add(new Rectangle(new Point(450, 450), new Point(600, 600), Color.YELLOW));

        mbba.drawRandomFramesBalls(WIDTH, HEIGHT, sizes, rects);

    }

    /**
     * Draws two frames of bouncing balls on screen.
     *
     * @param width  windows width
     * @param height window height
     * @param sizes  list of arrays of sizes
     * @param rects  rectangles
     */
    public void drawRandomFramesBalls(int width, int height, List<int[]> sizes, List<Rectangle> rects) {
        GUI gui = new GUI("Multiple Frames Bouncing Balls Animation", width, height);
        Sleeper sleeper = new Sleeper();
        ListOfFrames frames = new ListOfFrames();

        frames.createFrames(rects, sizes);
        frames.generateBalls(sizes);

        while (true) {
            frames.moveOneStep();

            DrawSurface d = gui.getDrawSurface();
            frames.drawOn(d);

            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
