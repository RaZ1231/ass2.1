package listeners;

import animations.GameLevel;
import blocks.Block;
import interfaces.Collidable;
import interfaces.HitListener;
import shapes.Ball;
import spaceinvaders.Invader;
import spaceinvaders.SpaceShipShot;
import utils.Counter;

/**
 * a CollidableRemover is in charge of removing blocks from the gameLevel, as well as keeping count
 * of the number of blocks that were removed.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public class CollidableRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter removedInvaders;

    /**
     * constructor.
     *
     * @param gameLevel       a gameLevel.
     * @param removedInvaders number of blocks.
     */
    public CollidableRemover(GameLevel gameLevel, Counter removedInvaders) {
        this.gameLevel = gameLevel;
        this.removedInvaders = removedInvaders;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that got hit.
     * @param hitter   the hitting ball.
     */
    public void hitEvent(Collidable beingHit, Ball hitter) {
        if (beingHit instanceof Block) {
            ((Block) beingHit).removeFromGame(this.gameLevel);
            ((Block) beingHit).removeHitListener(this);
        } else if (beingHit instanceof Invader && hitter instanceof SpaceShipShot) {
            ((Invader) beingHit).removeFromGame(this.gameLevel);
            ((Invader) beingHit).removeHitListener(this);
            removedInvaders.decrease(1);
        }
    }

}
