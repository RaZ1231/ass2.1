package listeners;

import animations.GameLevel;
import interfaces.Collidable;
import interfaces.HitListener;
import shapes.Ball;
import utils.Counter;

/**
 * removing balls listener.
 *
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class LifeRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter lifeCounter;

    /**
     * constructor.
     *
     * @param gameLevel   a gameLevel.
     * @param lifeCounter number of invaders.
     */
    public LifeRemover(GameLevel gameLevel, Counter lifeCounter) {
        this.gameLevel = gameLevel;
        this.lifeCounter = lifeCounter;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that got hit.
     * @param hitter   the hitting ball.
     */
    @Override
    public void hitEvent(Collidable beingHit, Ball hitter) {
        beingHit.hitEvent(gameLevel, lifeCounter, hitter);
    }
}
