package spaceinvaders;

import collisions.GameEnvironment;
import java.awt.Color;
import motion.Velocity;
import shapes.Point;

/**
 * a spaceship shot class.
 *
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

    @Override
    public boolean isSpaceshipShot() {
        return true;
    }
}
