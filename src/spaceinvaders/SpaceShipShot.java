package spaceinvaders;

import collisions.GameEnvironment;
import motion.Velocity;
import shapes.Point;

import java.awt.Color;

/**
 * @author Raziel Solomon
 * @since 14-Jun-16.
 */
public class SpaceShipShot extends Shot {
    /**
     * constructor.
     *
     * @param center          center point.
     * @param gameEnvironment game environment.
     */
    public SpaceShipShot(Point center, GameEnvironment gameEnvironment) {
        super(center, 5, Color.red, gameEnvironment);
        setVelocity(Velocity.vUp(250));
    }
}
