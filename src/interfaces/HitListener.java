package interfaces;

import shapes.Ball;

/**
 * indicate that objects that implement it, want to be notified of hit events.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that got hit.
     * @param hitter   the hitting ball.
     */
    void hitEvent(GameBlock beingHit, Ball hitter);
}
