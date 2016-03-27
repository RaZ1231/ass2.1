package collections;

import motion.Velocity;
import shapes.Ball;
import shapes.Point;
import shapes.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * @author Raziel Solomon
 * @since 18-Mar-16.
 */

/**
 * Manages array of balls.
 */
public class ArrayOfBalls {
    private Ball[] balls;

    /**
     * constructor.
     *
     * @param size number of ball
     */
    public ArrayOfBalls(int size) {
        this.balls = new Ball[size];
    }

    /**
     * Gets balls array.
     *
     * @return balls array
     */
    public Ball[] getBalls() {
        return balls;
    }

    /**
     * Fills array with randomly placed and colored balls by sizes array and frame points.
     *
     * @param sizes array of sizes
     * @param start frame start
     * @param end   frame end
     */
    public void generateRandomBalls(int[] sizes, Point start, Point end) {
        for (int i = 0; i < getBalls().length; i++) {
            this.balls[i] = generateRandomBall(sizes[i], start, end);
        }
    }

    /**
     * Generate random balls by sizes array and rectangle.
     *
     * @param sizes array of sizes
     * @param rect  frame rectangle
     */
    public void generateRandomBalls(int[] sizes, Rectangle rect) {
        generateRandomBalls(sizes, rect.getStart(), rect.getEnd());
    }

    /**
     * Generates random ball by size and frame.
     *
     * @param size  size of ball
     * @param start starting point
     * @param end   ending point
     * @return random ball
     */
    public Ball generateRandomBall(int size, Point start, Point end) {
        Random rand = new Random();
        float hue = rand.nextFloat();
        float saturation = (rand.nextInt(2000) + 1000) / 10000f;
        float luminance = 0.9f;
        Color color = Color.getHSBColor(hue, saturation, luminance);

        double x = (double) rand.nextInt((int) (end.getX() - start.getX()) - 2 * size - 2) + start.getX() + size + 1;
        double y = (double) rand.nextInt((int) (end.getY() - start.getY()) - 2 * size - 2) + start.getY() + size + 1;

        return new Ball(x, y, size, color);
    }

    /**
     * Sets balls velocities: random direction, speed by size.
     */
    public void setVelocities() {
        Random rand = new Random();
        for (Ball ball : getBalls()) {
            ball.setVelocity(Velocity.fromAngleAndSpeed(rand.nextInt(360), Velocity.minimumSpeed(50 - ball.getSize())));
        }
    }

    /**
     * Draw balls on surface.
     *
     * @param d draw surface
     */
    public void drawOn(DrawSurface d) {
        for (Ball ball : getBalls()) {
            ball.drawOn(d);
        }
    }

    /**
     * Move all balls one step (frame).
     *
     * @param start starting point of border
     * @param end   ending point of border
     */
    public void moveBalls(Point start, Point end) {
        for (Ball ball : getBalls()) {
            ball.moveBoundedStep((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
        }
    }

    /**
     * Move all balls one step (frame).
     *
     * @param rect border
     */
    public void moveBalls(Rectangle rect) {
        moveBalls(new Point(rect.getStart().getX(), (int) rect.getStart().getY()),
                new Point(rect.getEnd().getX(), (int) rect.getEnd().getY()));
    }
}
