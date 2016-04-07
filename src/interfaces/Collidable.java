package interfaces;

import motion.Velocity;
import shapes.Point;
import shapes.Rectangle;

/**
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
     * @param collisionPoint  point of collision.
     * @param currentVelocity current velocity.
     * @return the new velocity expected after the hit
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity);
}
