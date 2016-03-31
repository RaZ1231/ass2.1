package shapes;

import biuoop.DrawSurface;
import interfaces.Collidable;
import interfaces.Sprite;
import motion.Velocity;
import utils.Mathematics;

import java.awt.*;

/**
 * Created by Elisheva on 30/03/2016.
 */

/**
 * Block representation.
 */
public class Block implements Collidable, Sprite {
    private Rectangle rect;
    private Color color;
    private int hitCounter;


    /**
     * constructor.
     *
     * @param rect       a rectangle.
     * @param color      a color.
     * @param hitCounter hits counter. 'null' if none.
     */
    public Block(Rectangle rect, Color color, int hitCounter) {
        this.rect = rect;
        this.color = color;
        this.hitCounter = hitCounter;
    }

    /**
     * returns rectangle.
     *
     * @return block's rectangle.
     */
    public Rectangle getRect() {
        return rect;
    }

    /**
     * returns color.
     *
     * @return color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * returns hits counter.
     *
     * @return hits counter. 'null' in none.
     */
    public Integer getHitCounter() {
        return hitCounter;
    }

    /**
     * Draws on surface.
     *
     * @param d draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
        d.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
        double x = Mathematics.average(rect.getUpperLeft().getX(), rect.getUpperLeft().getX() + rect.getWidth());
        double y = Mathematics.average(rect.getUpperLeft().getY(), rect.getUpperLeft().getY() + rect.getHeight());
        String s = hitsAsString();
        d.drawText((int) x, (int) y, s, 11);
    }

    /**
     * returns hits counter as a String.
     *
     * @return hits counter as a String
     */
    public String hitsAsString() {
        if (this.hitCounter == 0) {
            return "X";
        } else {
            return String.valueOf(hitCounter);
        }
    }

    /**
     * currently we do nothing.
     */
    @Override
    public void timePassed() {
        // currently we do nothing.
    }

    /**
     * returns the block's rectangle.
     *
     * @return the block's rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return getRect();
    }

    /**
     * returns the new velocity expected after the hit.
     *
     * @param collisionPoint  the collision point.
     * @param currentVelocity the current velocity.
     * @return the new velocity expected after the hit.
     */
    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        Line lNorth = new Line(rect.getUpperLeft(), rect.getUpperRight());
        Line lSouth = new Line(rect.getLowerLeft(), rect.getLowerRight());
        if (lNorth.isInline(collisionPoint) || lSouth.isInline(collisionPoint)) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        } else {
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
    }


}
