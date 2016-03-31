package shapes;

import biuoop.DrawSurface;
import game.Game;
import interfaces.Sprite;
import motion.Velocity;

import java.awt.*;

/**
 * @author Raziel Solomon
 * @since 16-Mar-16.
 */

/**
 * Representation of ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int radios;
    private Color color;
    private Velocity velocity;

    /**
     * constructor.
     *
     * @param center center point
     * @param radios ball size
     * @param color  ball color
     */
    public Ball(Point center, int radios, Color color) {
        this.center = center;
        this.radios = radios;
        this.color = color;
    }

    /**
     * constructor.
     *
     * @param x      x of center point
     * @param y      y of center point
     * @param radios ball size
     * @param color  ball color
     */
    public Ball(double x, double y, int radios, Color color) {
        this(new Point(x, y), radios, color);
    }

    // accessors

    /**
     * Gets center x.
     *
     * @return center x
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets center y.
     *
     * @return center y
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets radios.
     *
     * @return ball radios
     */
    public int getSize() {
        return this.radios;
    }

    /**
     * Gets color.
     *
     * @return color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * String representation.
     *
     * @return String representation
     */
    @Override
    public String toString() {
        return String.format("Ball{center=%s, radios=%d, color=%s, velocity=%s}", center, radios, color, velocity);
    }

    // draw the ball on the given DrawSurface

    /**
     * Draws on surface.
     *
     * @param surface draw surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle(getX(), getY(), getSize());
    }

    @Override
    public void timePassed() {

    }

    /**
     * Sets ball velocity.
     *
     * @param dx delta x
     * @param dy delta y
     */
    public void setVelocity(double dx, double dy) {
        this.setVelocity(new Velocity(dx, dy));
    }

    /**
     * Gets velocity.
     *
     * @return ball velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Sets ball velocity.
     *
     * @param v new velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Move the ball one step of velocity.
     */
    public void moveOneStep() {
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * Move the ball one step in bounded step.
     *
     * @param left   right margin
     * @param top    top margin
     * @param right  left margin
     * @param bottom bottom margin
     */
    public void moveBoundedStep(int left, int top, int right, int bottom) {
        //checking if ball reached bound.
        //sides
        if (getX() - getSize() <= left || getX() + getSize() >= right) {
            setVelocity((-1) * getVelocity().getDx(), getVelocity().getDy());
        }
        //top and bottom
        if (getY() - getSize() <= top || getY() + getSize() >= bottom) {
            setVelocity(getVelocity().getDx(), (-1) * getVelocity().getDy());
        }

        moveOneStep(); //move ball

        //checking if ball missed bound
        //sides
        if (getX() - getSize() < left) {
            center.setX(left + getSize());
        }
        if (getX() + getSize() > right) {
            center.setX(right - getSize());
        }
        //top and bottom
        if (getY() - getSize() < top) {
            center.setY(top + getSize());
        }
        if (getY() + getSize() > bottom) {
            center.setY(bottom - getSize());
        }
    }

    public void addToGame(Game game) {
        game.addSprite(this);
    }
}
