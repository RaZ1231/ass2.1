package game;

/**
 * Created by Elisheva on 31/03/2016.
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Collidable;
import interfaces.Sprite;
import motion.Velocity;
import shapes.Line;
import shapes.Rectangle;

import java.awt.Color;

/**
 * Paddle representation.
 */
public class Paddle implements Sprite, Collidable {
    private shapes.Rectangle rect;
    private biuoop.KeyboardSensor keyboard;

    public Paddle(Rectangle rect, biuoop.KeyboardSensor keyboard) {
        this.rect = rect;
        this.keyboard = keyboard;
    }

    /**
     * move the paddle left 5 pixels.
     */
    public void moveLeft() {
        rect.setUpperLeft(new shapes.Point(rect.getUpperLeft().getX() - 5, rect.getUpperLeft().getY()));
    }

    /**
     * move the paddle right 5 pixels.
     */
    public void moveRight() {
        rect.setUpperLeft(new shapes.Point(rect.getUpperLeft().getX() + 5, rect.getUpperLeft().getY()));
    }

    /**
     * check if the "left" or "right" keys are pressed, and if so move it accordingly.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
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
     * @param collisionPoint  the collision point.
     * @param currentVelocity the current velocity.
     * @return the new velocity expected after the hit.
     */
    public Velocity hit(shapes.Point collisionPoint, Velocity currentVelocity) {
        Line lNorth = new Line(rect.getUpperLeft(), rect.getUpperRight());
        if (lNorth.isInline(collisionPoint)) {
            shapes.Point[] points = fiveRegions();
            int[] angles = {-60, -30, 0, 30, 60};
            int i = 0;
            while (i < 5) {
                if (collisionPoint.getX() >= points[i + 1].getX()) {
                    i++;
                } else {
                    double speed = Math.pow(currentVelocity.getDx(), 2)
                            + Math.pow(currentVelocity.getDy(), 2);
                    return Velocity.fromAngleAndSpeed(angles[i], speed);
                }
            }
        } else {
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        return currentVelocity;
    }

    /**
     * returns an array of the five regions of the paddle.
     *
     * @return an array of the five regions of the paddle.
     */
    public shapes.Point[] fiveRegions() {
        shapes.Point[] points = new shapes.Point[5];
        for (int i = 0; i < 5; i++) {
            points[i] = new shapes.Point(rect.getUpperLeft().getX() + i * (rect.getWidth() / 5)
                    , rect.getUpperLeft().getY());
        }
        return points;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g a game.
     */
    public void addToGame(Game g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}
