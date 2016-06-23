package listeners;

import animations.GameLevel;
import interfaces.Collidable;
import interfaces.HitListener;
import shapes.Ball;
import utils.Counter;

/**
 * a InvaderRemover is in charge of removing invaders from the gameLevel, as well as keeping count
 * of the number of invaders that were removed.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public class InvaderRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingInvaders;

    /**
     * constructor.
     *
     * @param gameLevel         a gameLevel.
     * @param remainingInvaders number of invaders.
     */
    public InvaderRemover(GameLevel gameLevel, Counter remainingInvaders) {
        this.gameLevel = gameLevel;
        this.remainingInvaders = remainingInvaders;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that got hit.
     * @param hitter   the hitting ball.
     */
    public void hitEvent(Collidable beingHit, Ball hitter) {
        beingHit.hitEvent(gameLevel, remainingInvaders, hitter);
    }
}
