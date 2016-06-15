package spaceinvaders;

import collisions.GameEnvironment;
import java.awt.Color;
import shapes.Ball;
import shapes.Point;

/**
 * @author Raziel Solomon
 * @since 14-Jun-16.
 */
public class SpaceShipShot extends Ball {
    /**
     * constructor.
     *
     * @param center          center point.
     * @param gameEnvironment game environment.
     */
    public SpaceShipShot(Point center, GameEnvironment gameEnvironment) {
        super(center, 5, Color.red, gameEnvironment);
    }
}
