package listeners;

import game.Game;
import interfaces.HitListener;
import interfaces.InterBlock;
import shapes.Ball;
import utils.Counter;

/**
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class BallRemover implements HitListener {
    private Game game;
    private Counter removedBalls;

    /**
     * constructor;
     *
     * @param game         a game.
     * @param removedBalls number of blocks.
     */
    public BallRemover(Game game, Counter removedBalls) {
        this.game = game;
        this.removedBalls = removedBalls;
    }

    @Override
    public void hitEvent(InterBlock beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        removedBalls.decrease(1);
    }
}
