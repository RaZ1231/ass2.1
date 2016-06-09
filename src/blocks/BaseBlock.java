package blocks;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.GameBlock;
import interfaces.HitListener;
import interfaces.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import motion.Velocity;
import shapes.Ball;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import sprites.AImage;
import sprites.Square;
import utils.Mathematics;

/**
 * Base block class.
 *
 * @author Elisheva Broyer.
 * @since 11/05/2016.
 */
public abstract class BaseBlock {
    private Rectangle rect;
    private Sprite fill;
    private Color stroke;
    private List<HitListener> hitListeners;

    /**
     * constructor.
     *
     * @param rect  a rectangle.
     * @param color a color.
     */
    public BaseBlock(Rectangle rect, Color color, Color stroke) {
        this.rect = rect;
        this.fill = new Square(rect.getUpperLeft(), (int) rect.getWidth(), (int) rect.getHeight(), color);
        this.stroke = stroke;
        this.hitListeners = new ArrayList<>();
    }

    public BaseBlock(Rectangle rect, String image, Color stroke) {
        this.fill = new AImage(image, rect.getUpperLeft());
        this.stroke = stroke;
        this.rect = rect;
    }

    /**
     * Draws on surface.
     *
     * @param d draw surface.
     */
    public void drawOn(DrawSurface d) {
        fill.drawOn(d);
        d.setColor(getStroke());
        d.drawRectangle((int) getRect().getUpperLeft().getX(),
                (int) getRect().getUpperLeft().getY(),
                (int) getRect().getWidth(), (int) getRect().getHeight());
        double x = Mathematics.average(getRect().getUpperLeft().getX(),
                getRect().getUpperLeft().getX() + 0.9 * getRect().getWidth());
        double y = Mathematics.average(getRect().getUpperLeft().getY(),
                getRect().getUpperLeft().getY() + 1.75 * getRect().getHeight());
        drawSelf(d, x, y);
    }

    public Color getStroke() {
        return stroke;
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
     * block draws itself.
     *
     * @param d a drawsurface.
     * @param x x-axes coordinate.
     * @param y y-axes coordinate.
     */
    protected abstract void drawSelf(DrawSurface d, double x, double y);

    /**
     * do nothing.
     *
     * @param dt a delta.
     */
    public void timePassed(double dt) {
        // do nothing.
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

    /**
     * the effect of the hit on the block.
     */
    protected abstract void effect();

    /**
     * notifying all listeners that hit occurred.
     *
     * @param hitter the hitting block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.getHitListeners());
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent((GameBlock) this, hitter);
        }
    }

    /**
     * returns list of listeners.
     *
     * @return list of listeners.
     */
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

    /**
     * add listener to block's list.
     *
     * @param hl a hit listener.
     */
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    /**
     * remove listener from block's list.
     *
     * @param hl a hit listener.
     */
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
