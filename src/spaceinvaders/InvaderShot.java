package spaceinvaders;

import collisions.GameEnvironment;
import java.awt.Color;
import motion.Velocity;
import shapes.Point;

/**
 * an invader shot class.
 *
 * @author Raziel Solomon
 * @since 14-Jun-16.
 */
public class InvaderShot extends Shot {
    /**
     * constructor.
     *
     * @param center          center point.
     * @param gameEnvironment game environment.
     */
    public InvaderShot(Point center, GameEnvironment gameEnvironment) {
        super(center, 3, Color.green, gameEnvironment);
        setVelocity(Velocity.vDown(100));
    }
}
