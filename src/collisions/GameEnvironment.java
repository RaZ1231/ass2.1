package collisions;

import interfaces.Collidable;
import shapes.Line;
import shapes.Point;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor.
     */
    public GameEnvironment() {
        collidables = new LinkedList<Collidable>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c a Collidable object.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory a line to the ball's next step.
     * @return collision info.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closestPoint = trajectory.end();
        Collidable collidable = null;
        for (Collidable c:this.collidables) {
            Point p = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (trajectory.isCloserToStart(p, closestPoint)) {
                closestPoint = p;
                collidable = c;
            }
        }
        return new CollisionInfo(closestPoint, collidable);
    }

}
