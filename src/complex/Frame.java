package complex;

import biuoop.DrawSurface;
import collections.ArrayOfBalls;
import shapes.Point;
import shapes.Rectangle;

import java.awt.*;

/**
 * @author Raziel Solomon
 * @since 18-Mar-16.
 */

/**
 * Frame is a rectangle with bouncing balls inside.
 */
public class Frame {
    private Rectangle rectangle;
    private ArrayOfBalls balls;

    /**
     * constructor.
     *
     * @param rectangle  frame rectangle
     * @param numOfBalls number of balls
     */
    public Frame(Rectangle rectangle, int numOfBalls) {
        this.rectangle = rectangle;
        this.balls = new ArrayOfBalls(numOfBalls);
    }

    /**
     * constructor.
     *
     * @param start      starting point
     * @param end        ending point
     * @param color      color of frame
     * @param numOfBalls number of balls
     */
    public Frame(Point start, Point end, Color color, int numOfBalls) {
        this(new Rectangle(start, end, color), numOfBalls);
    }

    /**
     * Returns rectangle.
     *
     * @return rectangle
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * Returns balls.
     *
     * @return balls
     */
    public ArrayOfBalls getBalls() {
        return balls;
    }

    /**
     * Generates balls by sizes.
     *
     * @param sizes array of sizes
     */
    public void generateBalls(int[] sizes) {
        this.balls.generateRandomBalls(sizes, getRectangle());
        this.balls.setVelocities();
    }

    /**
     * Moves frame on step.
     */
    public void moveOneStep() {
        this.balls.moveBalls(getRectangle());
    }

    /**
     * Draws frame on surface.
     *
     * @param d draw surface
     */
    public void drawOn(DrawSurface d) {
        this.rectangle.drawOn(d);
        this.balls.drawOn(d);
    }
}
