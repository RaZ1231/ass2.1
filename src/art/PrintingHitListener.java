package art;

import blocks.Block;
import interfaces.GameBlock;
import interfaces.HitListener;
import shapes.Ball;

/**
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public class PrintingHitListener implements HitListener {
    public void hitEvent(GameBlock beingHit, Ball hitter) {
        System.out.println("A Block with " + ((Block) beingHit).getHitPoints() + " points was hit.");
    }
}
