package collisions;

import interfaces.Collidable;
import shapes.Point;

/**
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class CollisionInfo {
    private Point collisionPoint; //the point at which the collision occurs.
    private Collidable collisionObject; //the collidable object involved in the collision.

    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    public Point getCollisionPoint() {
        return collisionPoint;
    }

    public Collidable getCollisionObject() {
        return collisionObject;
    }
}

