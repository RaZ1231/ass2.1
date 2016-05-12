package listeners;

import Animations.GameLevel;
import blocks.Block;
import interfaces.GameBlock;
import interfaces.HitListener;
import shapes.Ball;
import utils.Counter;

/**
 * a BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
 * of the number of blocks that were removed.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter removedBlocks;

    /**
     * constructor;
     *
     * @param gameLevel          a gameLevel.
     * @param removedBlocks number of blocks.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.removedBlocks = removedBlocks;
    }

    /**
     * Blocks that are hit and reach 0 hit-points should be removed
     * from the gameLevel. Remember to remove this listener from the block
     * that is being removed from the gameLevel.
     *
     * @param beingHit the block that got a hit.
     * @param hitter   the hitting ball.
     */
    @Override
    public void hitEvent(GameBlock beingHit, Ball hitter) {
        if (((Block) beingHit).getHitPoints() == 0) {
            beingHit.removeFromGame(this.gameLevel);
            beingHit.removeHitListener(this);
            removedBlocks.decrease(1);
        }
    }

}
