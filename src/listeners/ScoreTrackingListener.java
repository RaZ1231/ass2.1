package listeners;

import Animations.GameLevel;
import blocks.Block;
import interfaces.GameBlock;
import interfaces.HitListener;
import shapes.Ball;
import utils.Counter;

/**
 * Keeping track of scores.
 *
 * @author Elisheva Broyer.
 * @since 11/05/2016.
 */
public class ScoreTrackingListener implements HitListener {
    private GameLevel gameLevel;
    private Counter currentScore;

    public ScoreTrackingListener(GameLevel gameLevel, Counter scoreCounter) {
        this.gameLevel = gameLevel;
        this.currentScore = scoreCounter;
    }

    public void hitEvent(GameBlock beingHit, Ball hitter) {
        if (((Block) beingHit).getHitPoints() == 0) {
            currentScore.increase(10);
        } else {
            currentScore.increase(5);
        }
    }
}
