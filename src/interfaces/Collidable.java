package interfaces;

import motion.Velocity;
import shapes.Ball;
import shapes.Point;
import shapes.Rectangle;

/**
 * Object that can be collided with.
 *
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public interface Collidable {
    /**
     * return the "collision shape" of the object.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

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
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
