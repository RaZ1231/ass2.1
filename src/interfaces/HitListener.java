package interfaces;

import shapes.Ball;

/**
 * indicate that objects that implement it, want to be notified of hit events.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public interface HitListener {
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.
    void hitEvent(InterBlock beingHit, Ball hitter);
}
