package blocks;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.GameBlock;
import interfaces.HitListener;
import motion.Velocity;
import shapes.Ball;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import utils.Mathematics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elisheva Broyer.
 * @since 11/05/2016.
 */
public abstract class BaseBlock {
    private Rectangle rect;
    private Color color;
    private List<HitListener> hitListeners;

    public BaseBlock(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Draws on surface.
     *
     * @param d draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.fillRectangle((int) getRect().getUpperLeft().getX(),
                (int) getRect().getUpperLeft().getY(),
                (int) getRect().getWidth(), (int) getRect().getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) getRect().getUpperLeft().getX(),
                (int) getRect().getUpperLeft().getY(),
                (int) getRect().getWidth(), (int) getRect().getHeight());
        double x = Mathematics.average(getRect().getUpperLeft().getX(),
                getRect().getUpperLeft().getX() + 0.9 * getRect().getWidth());
        double y = Mathematics.average(getRect().getUpperLeft().getY(),
                getRect().getUpperLeft().getY() + 1.75 * getRect().getHeight());
        drawSelf(d, x, y);
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
     * returns rectangle.
     *
     * @return block's rectangle.
     */
    public Rectangle getRect() {
        return rect;
    }

    protected abstract void drawSelf(DrawSurface d, double x, double y);

    /**
     * currently we do nothing.
     */
    public void timePassed() {
        // currently we do nothing.
    }

    /**
     * returns the block's rectangle.
     *
     * @return the block's rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return getRect();
    }

    /**
     * returns the new velocity expected after the hit.
     *
     * @param hitter          the hitting ball.
     * @param collisionPoint  point of collision.
     * @param currentVelocity current velocity.
     * @return the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line lNorth = new Line(getRect().getUpperLeft(), getRect().getUpperRight());
        Line lSouth = new Line(getRect().getLowerLeft(), getRect().getLowerRight());
        Line lWest = new Line(getRect().getUpperLeft(), getRect().getLowerLeft());
        Line lEast = new Line(getRect().getUpperRight(), getRect().getLowerRight());

        effect();

        this.notifyHit(hitter);

        if (lNorth.isInline(collisionPoint) || lSouth.isInline(collisionPoint)) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        } else if (lWest.isInline(collisionPoint) || lEast.isInline(collisionPoint)) {
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        } else {
            return currentVelocity;
        }
    }

    protected abstract void effect();

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.getHitListeners());
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent((GameBlock) this, hitter);
        }
    }

    public List<HitListener> getHitListeners() {
        return hitListeners;
    }

    /**
     * add the block to the gameLevel.
     *
     * @param gameLevel a gameLevel it add the block to.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable((GameBlock) this);
        gameLevel.addSprite((GameBlock) this);
    }

    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
