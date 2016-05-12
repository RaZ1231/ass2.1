package collisions;

import interfaces.Collidable;
import shapes.Line;
import shapes.Point;

import java.util.LinkedList;
import java.util.List;

/**
 * game environment class.
 *
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

    public void removeCollidable(Collidable c) {
        collidables.remove(c);
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
        Point p;

        for (Collidable c : this.collidables) {
            p = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());

            if ((p != null) && (trajectory.start().distance(p) <= trajectory.start().distance(closestPoint))) {
                closestPoint = p;
                collidable = c;
            }
        }

        return new CollisionInfo(closestPoint, collidable);
    }

}
