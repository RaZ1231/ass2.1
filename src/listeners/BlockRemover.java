package listeners;

import animations.GameLevel;
import interfaces.Collidable;
import interfaces.HitListener;
import shapes.Ball;

/**
 * @author Elisheva Broyer.
 * @since 19/06/2016.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;

    public BlockRemover(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
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
        beingHit.hitEvent(gameLevel, null, hitter);
    }
}
