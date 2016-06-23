package listeners;

import animations.GameLevel;
import interfaces.Collidable;
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

    /**
     * constructor.
     *
     * @param gameLevel    a level.
     * @param scoreCounter a score counter.
     */
    public ScoreTrackingListener(GameLevel gameLevel, Counter scoreCounter) {
        this.gameLevel = gameLevel;
        this.currentScore = scoreCounter;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that got hit.
     * @param hitter   the hitting ball.
     */
    public void hitEvent(Collidable beingHit, Ball hitter) {
        if (beingHit.isInvader() && hitter.isSpaceshipShot()) {
            currentScore.increase(100);
        }
    }
}
