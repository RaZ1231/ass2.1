package listeners;

import blocks.Block;
import game.Game;
import interfaces.HitListener;
import interfaces.InterBlock;
import shapes.Ball;
import utils.Counter;

/**
 * Keeping track of scores.
 *
 * @author Elisheva Broyer.
 * @since 11/05/2016.
 */
public class ScoreTrackingListener implements HitListener {
    private Game game;
    private Counter currentScore;

    public ScoreTrackingListener(Game game, Counter scoreCounter) {
        this.game = game;
        this.currentScore = scoreCounter;
    }

    public void hitEvent(InterBlock beingHit, Ball hitter) {
        if (((Block) beingHit).getHitPoints() == 0) {
            currentScore.increase(10);
        } else {
            currentScore.increase(5);
        }
    }
}
