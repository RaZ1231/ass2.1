package spaceinvaders;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.Sprite;
import motion.Velocity;
import shapes.Ball;
import shapes.Point;
import shapes.Rectangle;
import sprites.FillImage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 14-Jun-16.
 */
public class Invader implements Sprite, Collidable {
    private final int width = 40;
    private final int height = 30;

    private Point upperLeft;
    private FillImage img;
    private Acceleration a;
    private List<HitListener> hitListeners;

    public Invader(Point upperLeft, FillImage img, Acceleration a) {
        this.upperLeft = upperLeft;
        this.img = img;
        this.a = a;
        hitListeners = new LinkedList<>();
    }

    /**
     * return the "collision shape" of the object.
     *
     * @return the "collision shape" of the object.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return new Rectangle(upperLeft, width, height);
    }

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param hitter          the hitting ball.
     * @param collisionPoint  point of collision.
     * @param currentVelocity current velocity.
     * @return the new velocity expected after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        notifyHit(hitter);
        return null;
    }

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
            hl.hitEvent(this, hitter);
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
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        img.drawOn(d);
    }

    /**
     * notify the sprite that time has passed.
     *
     * @param dt seconds passed.
     */
    @Override
    public void timePassed(double dt) {
        Velocity relativeV = Velocity.fromAngleAndSpeed(a.getV().getAngle(), dt * a.getV().getSpeed());
        upperLeft = relativeV.applyToPoint(upperLeft);
    }

    /**
     * add object to gameLevel.
     *
     * @param gameLevel a gameLevel to add the object to.
     */
    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
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

    /**
     * remove block from game.
     *
     * @param gameLevel a level.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    public boolean isLowerThan(Invader invader) {
        return getUpperLeft().getY() >= invader.getUpperLeft().getY();
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public boolean isRighterThan(Invader invader) {
        return getUpperLeft().getX() >= invader.getUpperLeft().getX();
    }

    public boolean isLefterThan(Invader invader) {
        return getUpperLeft().getX() <= invader.getUpperLeft().getX();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void stepDown() {
        upperLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
    }
}
