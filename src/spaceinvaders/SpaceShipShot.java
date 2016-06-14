package spaceinvaders;

import collisions.GameEnvironment;
import shapes.Ball;
import shapes.Point;

import java.awt.Color;

/**
 * @author Raziel Solomon
 * @since 14-Jun-16.
 */
public class SpaceShipShot extends Ball {
    /**
     * constructor.
     *
     * @param center          center point.
     * @param radius          ball size.
     * @param color           ball color.
     * @param gameEnvironment game environment.
     */
    public SpaceShipShot(Point center, int radius, Color color, GameEnvironment gameEnvironment) {
        super(center, radius, color, gameEnvironment);
    }
}
