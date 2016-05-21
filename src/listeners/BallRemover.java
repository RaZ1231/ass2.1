package listeners;

import animations.GameLevel;
import interfaces.GameBlock;
import interfaces.HitListener;
import shapes.Ball;
import utils.Counter;

/**
 * removing balls listener.
 *
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter removedBalls;

    /**
     * constructor.
     *
     * @param gameLevel         a gameLevel.
     * @param removedBalls number of blocks.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.removedBalls = removedBalls;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that got hit.
     * @param hitter   the hitting ball.
     */
    @Override
    public void hitEvent(GameBlock beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        removedBalls.decrease(1);
    }
}
