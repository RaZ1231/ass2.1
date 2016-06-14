package listeners;

import interfaces.Collidable;
import interfaces.HitListener;
import shapes.Ball;

/**
 * printing hit listener class.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public class PrintingHitListener implements HitListener {
    /**
     * according to the assignment, should print that a block has been hit.
     *
     * @param beingHit the block that got hit.
     * @param hitter   the hitting ball.
     */
    @Override
    public void hitEvent(Collidable beingHit, Ball hitter) {
        System.out.println("Invader hit");
    }
}
