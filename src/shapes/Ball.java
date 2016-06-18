package shapes;

import animations.GameLevel;
import biuoop.DrawSurface;
import collisions.CollisionInfo;
import collisions.GameEnvironment;
import interfaces.Sprite;
import motion.Velocity;

import java.awt.Color;

/**
 * ball class.
 *
 * @author Raziel Solomon
 * @since 16-Mar-16.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * constructor.
     *
     * @param x               x of center point
     * @param y               y of center point
     * @param radius          ball size
     * @param color           ball color
     * @param gameEnvironment game environment.
     */
    public Ball(double x, double y, int radius, Color color, GameEnvironment gameEnvironment) {
        this(new Point(x, y), radius, color, gameEnvironment);
    }

    /**
     * constructor.
     *
     * @param center          center point.
     * @param radius          ball size.
     * @param color           ball color.
     * @param gameEnvironment game environment.
     */
    public Ball(Point center, int radius, Color color,
                GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * returns center point.
     *
     * @return center point.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * String representation.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return String.format("Ball{center=%s, radius=%d, color=%s, velocity=%s}", center, radius, color, velocity);
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface draw surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.drawCircle(getX(), getY(), getSize());
        surface.setColor(getColor());
        surface.fillCircle(getX(), getY(), getSize());
    }

    /**
     * returns center x-axis value.
     *
     * @return center x-axis value.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * returns center y-axis value.
     *
     * @return center y-axis value.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * returns ball's radius.
     *
     * @return ball's radius
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * returns ball's color.
     *
     * @return ball's color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * move the ball one step according to possible collisions.
     *
     * @param dt seconds passed.
     */
    @Override
    public void timePassed(double dt) {
        Velocity relativeV = Velocity.fromAngleAndSpeed(
                getVelocity().getAngle(), dt * getVelocity().getSpeed());

        Point applyPoint = relativeV.applyToPoint(this.center); // next position.
        Line trajectory = new Line(this.center.round(), applyPoint.round()); // line to next position.
        CollisionInfo info = this.gameEnvironment.getClosestCollision(trajectory); // is there an object it
        if (info.getCollisionObject() != null) { // there is collision.
            info.getCollisionObject().hit(this, info.getCollisionPoint(), getVelocity());
        } else { // there isn't.
            this.center = relativeV.applyToPoint(this.center);
        }
    }

    /**
     * returns ball's velocity.
     *
     * @return ball's velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Sets ball's velocity.
     *
     * @param v new velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * add the ball to the gameLevel.
     *
     * @param gameLevel a gameLevel it add the ball to.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * Sets ball's velocity.
     *
     * @param dx delta x
     * @param dy delta y
     */
    public void setVelocity(double dx, double dy) {
        this.setVelocity(new Velocity(dx, dy));
    }

    /**
     * remove from game level.
     *
     * @param gameLevel game to remove from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }

    public boolean isInvaderShot() {
        return false;
    }
}
