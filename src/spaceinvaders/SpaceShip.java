package spaceinvaders;

import animations.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Collidable;
import interfaces.Fill;
import interfaces.HitListener;
import interfaces.Sprite;
import java.util.ArrayList;
import java.util.List;
import motion.Velocity;
import shapes.Ball;
import shapes.Point;
import shapes.Rectangle;
import utils.Counter;

/**
 * SpaceShip representation.
 *
 * @author Elisheva Broyer.
 * @since 31/03/2016.
 */
public class SpaceShip implements Sprite, Collidable {
    private Rectangle rect;
    private KeyboardSensor keyboard;
    private double leftBorder;
    private double rightBorder;
    private int step;
    private Fill fill;
    private GameLevel gameLevel;
    private Timer time;
    private List<HitListener> hitListeners;

    /**
     * constructor.
     *
     * @param rect        a rectangle.
     * @param keyboard    a sensor of keyboard.
     * @param leftBorder  game environment's left border.
     * @param rightBorder game environment's right border.
     * @param step        speed.
     * @param fill        a fill object.
     */
    public SpaceShip(Rectangle rect, KeyboardSensor keyboard, double leftBorder, double rightBorder,
                     int step, Fill fill) {
        this.rect = rect;
        this.keyboard = keyboard;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.step = step;
        this.fill = fill.create(rect);
        this.time = new Timer(0);
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Draws on surface.
     *
     * @param d draw surface.
     */
    public void drawOn(DrawSurface d) {
        fill.drawOn(d);
    }

    /**
     * check if the "left" or "right" keys are pressed, and if so move it accordingly.
     * "space" means shoot.
     *
     * @param dt seconds passed.
     */
    public void timePassed(double dt) {
        time.timePassed(dt);

        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft(dt);
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight(dt);
        } else if (keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.shoot();
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
     * shoot a single shot on invader.
     */
    public void shoot() {
        if (time.hasPassed()) {
            SpaceShipShot s = new SpaceShipShot(getCenter(), gameLevel.getEnvironment());
            gameLevel.addShot(s);
            s.addToGame(gameLevel);
            time = new Timer(0.35);
        }
    }

    /**
     * returns the upper center point of spaceship.
     *
     * @return the upper center point of spaceship.
     */
    public Point getCenter() {
        return new Point(rect.getUpperLeft().getX() + rect.getWidth() / 2 - 10,
                rect.getUpperLeft().getY() - 3);
    }

    /**
     * Add this paddle to the game.
     *
     * @param g a game.
     */
    public void addToGame(GameLevel g) {
        this.gameLevel = g;
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
     * returns the new velocity expected after hit.
     *
     * @param hitter          ball of collision.
     * @param collisionPoint  the collision point.
     * @param currentVelocity the current velocity.
     * @return the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        return null; // meaningless.
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
        hitter.removeFromGame(gameLevel);
        counter.decrease(1);
        gameLevel.stop();
    }

    @Override
    public boolean isInvader() {
        return false;
    }

    /**
     * notify all listeners of hit event.
     *
     * @param hitter an hitting object.
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
     * returns a list of all spaceship's listeners.
     *
     * @return a list of all spaceship's listeners.
     */
    public List<HitListener> getHitListeners() {
        return hitListeners;
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
     * to center the paddle.
     *
     * @param width paddle width.
     */
    public void center(int width) {
        rect.setUpperLeft(new Point(width / 2 - rect.getWidth() / 2, rect.getUpperLeft().getY()));
    }
}
