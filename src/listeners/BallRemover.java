package listeners;

import Animations.GameLevel;
import interfaces.GameBlock;
import interfaces.HitListener;
import shapes.Ball;
import utils.Counter;

/**
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter removedBalls;

    /**
     * constructor;
     *
     * @param gameLevel         a gameLevel.
     * @param removedBalls number of blocks.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.removedBalls = removedBalls;
    }

    @Override
    public void hitEvent(GameBlock beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        removedBalls.decrease(1);
    }
}
