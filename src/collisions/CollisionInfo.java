package collisions;

import interfaces.Collidable;
import shapes.Point;

/**
 * collision info class.
 *
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class CollisionInfo {
    private Point collisionPoint; //the point at which the collision occurs.
    private Collidable collisionObject; //the collidable object involved in the collision.

    /**
     * constructor.
     *
     * @param collisionPoint  the collision point.
     * @param collisionObject the collision object.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * returns the collision point.
     *
     * @return the collision point.
     */
    public Point getCollisionPoint() {
        return collisionPoint;
    }

    /**
     * returns the collision object.
     *
     * @return the collision object.
     */
    public Collidable getCollisionObject() {
        return collisionObject;
    }
}

