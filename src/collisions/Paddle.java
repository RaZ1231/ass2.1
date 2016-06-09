package collisions;

import animations.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Collidable;
import interfaces.Sprite;
import java.awt.Color;
import motion.Velocity;
import shapes.Ball;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import utils.Mathematics;

/**
 * Paddle representation.
 *
 * @author Elisheva Broyer.
 * @since 31/03/2016.
 */
public class Paddle implements Sprite, Collidable {
    public static final int[] ANGLES = {-60, -30, 0, 30, 60};

    private Rectangle rect;
    private KeyboardSensor keyboard;
    private double leftBorder;
    private double rightBorder;
    private int step;

    /**
     * constructor.
     *
     * @param rect        a rectangle.
     * @param keyboard    a sensor of keyboard.
     * @param leftBorder  game environment's left border.
     * @param rightBorder game environment's right border.
     * @param step        speed.
     */
    public Paddle(Rectangle rect, KeyboardSensor keyboard,
                  double leftBorder, double rightBorder, int step) {
        this.rect = rect;
        this.keyboard = keyboard;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.step = step;
    }

    /**
     * Draws on surface.
     *
     * @param d draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.YELLOW);
        d.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
    }

    /**
     * check if the "left" or "right" keys are pressed, and if so move it accordingly.
     *
     * @param dt seconds passed.
     */
    public void timePassed(double dt) {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft(dt);
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight(dt);
        }
    }

    /**
     * move the paddle 'step' pixels to the left.
     *
     * @param dt seconds passed.
     */
    public void moveLeft(double dt) {
        if (rect.getUpperLeft().getX() <= leftBorder) {
            rect.setUpperLeft(new Point(leftBorder, rect.getUpperLeft().getY()));
        } else {
            rect.setUpperLeft(new Point(rect.getUpperLeft().getX() - dt * step, rect.getUpperLeft().getY()));
        }
    }

    /**
     * move the paddle 'step' pixels to the right.
     *
     * @param dt seconds passed.
     */
    public void moveRight(double dt) {
        if (rect.getUpperRight().getX() >= rightBorder) {
            rect.setUpperLeft(new Point(rightBorder - rect.getWidth(), rect.getUpperLeft().getY()));
        } else {
            rect.setUpperLeft(new Point(rect.getUpperLeft().getX() + dt * step, rect.getUpperLeft().getY()));
        }
    }

    /**
     * Add this paddle to the game.
     *
     * @param g a game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * returns the paddle's rectangle.
     *
     * @return the paddle's rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * returns the new velocity expected after hit the paddle.
     *
     * @param hitter          ball of collision.
     * @param collisionPoint  the collision point.
     * @param currentVelocity the current velocity.
     * @return the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line lNorth = new Line(rect.getUpperLeft(), rect.getUpperRight());
        if (lNorth.isInline(collisionPoint)) { //hit upper bound
            double[] regions = getFiveRegions();
            double speed = Mathematics.pythagoras(currentVelocity.getDx(), currentVelocity.getDy());

            return Velocity.fromAngleAndSpeed(ANGLES[getRegion(collisionPoint.getX(), regions)], speed);
        }
        return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy()); //hit sides
    }

    /**
     * returns an array of the five regions of the paddle.
     *
     * @return an array of the five regions of the paddle.
     */
    public double[] getFiveRegions() {
        double[] regions = new double[5];

        for (int i = 0; i < 5; i++) {
            regions[i] = rect.getUpperLeft().getX() + i * rect.getWidth() / 5;
        }
        return regions;
    }

    /**
     * returns the region in line in which x is.
     *
     * @param x       an x-axis value.
     * @param regions an array of 5 regions of line.
     * @return the region in line in which x is.
     */
    public int getRegion(double x, double[] regions) {
        for (int i = 0; i < 4; i++) {
            if (Mathematics.isBetween(regions[i], x, regions[i + 1])) {
                return i;
            }
        }
        return 4;
    }

    /**
     * to center the paddle.
     *
     * @param width paddle width.
     */
    public void center(int width) {
        rect.setUpperLeft(new Point(width / 2 - rect.getWidth() / 2, rect.getUpperLeft().getY()));
    }
}