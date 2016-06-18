package spaceinvaders;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Collidable;
import interfaces.Fill;
import interfaces.HitListener;
import interfaces.Sprite;
import motion.Velocity;
import shapes.Ball;
import shapes.Point;
import shapes.Rectangle;
import sprites.FillImage;
import utils.Counter;

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

    private Point initialUpperLeft;
    private Point upperLeft;
    private Fill img;
    private Acceleration a;
    private Formation formation;
    private List<HitListener> hitListeners;

    public Invader(Point upperLeft, FillImage img) {
        this.upperLeft = initialUpperLeft = upperLeft;
        this.img = img.create(new Rectangle(upperLeft, width, height));
        hitListeners = new LinkedList<>();
    }

    public void setAccel(Acceleration a) {
        this.a = a;
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
     * deals with different hit events.
     *
     * @param game    the game
     * @param counter a counter
     * @param hitter  the ball of hit.
     */
    @Override
    public void hitEvent(GameLevel game, Counter counter, Ball hitter) {
        if (!hitter.isInvaderShot()) {
            removeFromGame(game);
            counter.decrease(1);
        }
        hitter.removeFromGame(game);
    }

    /**
     * remove block from game.
     *
     * @param gameLevel a level.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
        formation.remove(this);
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
        Velocity relativeV = Velocity.fromAngleAndSpeed(
                a.getV().getAngle(), dt * a.getV().getSpeed());
        upperLeft = relativeV.applyToPoint(upperLeft);
        img.setPoint(upperLeft);
    }

    /**
     * add object to gameLevel.
     *
     * @param gameLevel a gameLevel to add the object to.
     */
    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
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

    public void shoot(GameLevel g) {
        InvaderShot s = new InvaderShot(
                new Point(getUpperLeft().getX() + getWidth() / 2,
                        getUpperLeft().getY() + getHeight() + 2), g.getEnvironment());
        s.addToGame(g);
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void reset() {
        upperLeft = initialUpperLeft;
    }

    public boolean isLowerThan(Invader invader) {
        return getUpperLeft().getY() <= invader.getUpperLeft().getY();
    }

    public boolean isRighterThan(Invader invader) {
        return getUpperLeft().getX() <= invader.getUpperLeft().getX();
    }

    public boolean isLefterThan(Invader invader) {
        return getUpperLeft().getX() >= invader.getUpperLeft().getX();
    }

    public double getX() {
        return getUpperLeft().getX();
    }

    public double getY() {
        return getUpperLeft().getY();
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public void stepDown() {
        upperLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
    }

    @Override
    public String toString() {
        return "Invader{" + upperLeft + ',' + a + '}';
    }
}
