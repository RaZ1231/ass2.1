package collisions;

import interfaces.Collidable;
import shapes.Line;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    public GameEnvironment() {
        collidables = new LinkedList<Collidable>();
    }

    // add the given collidable to the environment.
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory) {

    }

}
