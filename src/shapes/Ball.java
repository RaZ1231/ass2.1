package shapes;

import biuoop.DrawSurface;
import collisions.CollisionInfo;
import collisions.GameEnvironment;
import game.Game;
import interfaces.Sprite;
import motion.Velocity;

import java.awt.*;

/**
 * @author Raziel Solomon
 * @since 16-Mar-16.
 */

/**
 * ball class.
 */
public class Ball implements Sprite {
    private Point center;
    private int radios;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * constructor.
     *
     * @param center center point.
     * @param radios ball size.
     * @param color  ball color.
     * @param gameEnvironment game environment.
     */
    public Ball(Point center, int radios, Color color,
                GameEnvironment gameEnvironment) {
        this.center = center;
        this.radios = radios;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * constructor.
     *
     * @param x      x of center point
     * @param y      y of center point
     * @param radios ball size
     * @param color  ball color
     * @param gameEnvironment game environment.
     */
    public Ball(double x, double y, int radios, Color color, GameEnvironment gameEnvironment) {
        this(new Point(x, y), radios, color, gameEnvironment);
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
     * returns center point.
     *
     * @return center point.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * returns ball's radius.
     *
     * @return ball's radius
     */
    public int getSize() {
        return this.radios;
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
     * String representation.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return String.format("Ball{center=%s, radios=%d, color=%s, velocity=%s}", center, radios, color, velocity);
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface draw surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle(getX(), getY(), getSize());
    }

    /**
     * move the ball one step according to possible collisions.
     */
    @Override
    public void timePassed() {
        Point applyPoint = getVelocity().applyToPoint(this.center); // next position.
        Line trajectory = new Line(this.center, applyPoint); // line to next position.
        CollisionInfo info = this.gameEnvironment.
                getClosestCollision(trajectory); // is there an object it
        if (info.getCollisionObject() != null) { // there is collision.
            this.setVelocity(info.getCollisionObject().hit(info.getCollisionPoint(), this.velocity));
        } else { // there isn't.
            this.moveOneStep();
        }
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
     * Move the ball one step according to current velocity.
     */
    public void moveOneStep() {
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * add the ball to the game.
     *
     * @param game a game it add the ball to.
     */
    public void addToGame(Game game) {
        game.addSprite(this);
    }
}
