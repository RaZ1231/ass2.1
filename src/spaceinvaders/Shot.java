package spaceinvaders;

import collisions.GameEnvironment;
import java.awt.Color;
import shapes.Ball;
import shapes.Point;

/**
 * an  abstract shot class.
 *
 * @author Raziel Solomon
 * @since 18-Jun-16.
 */
public abstract class Shot extends Ball {
    /**
     * constructor.
     *
     * @param center          center point.
     * @param radius          ball size.
     * @param color           ball color.
     * @param gameEnvironment game environment.
     */
    public Shot(Point center, int radius, Color color, GameEnvironment gameEnvironment) {
        super(center, radius, color, gameEnvironment);
    }
}
