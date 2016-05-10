package Listener;

import blocks.Block;
import game.Game;
import interfaces.HitListener;
import interfaces.InterBlock;
import shapes.Ball;
import utils.Counter;

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that were removed.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public class BlockRemover implements HitListener {
    private Game game;
    private Counter removedBlocks;

    /**
     * constructor;
     *
     * @param game          a game.
     * @param removedBlocks number of blocks.
     */
    public BlockRemover(Game game, Counter removedBlocks) {
        this.game = game;
        this.removedBlocks = removedBlocks;
    }

    /**
     * Blocks that are hit and reach 0 hit-points should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit the hitted block.
     * @param hitter   the hitting ball.
     */
    @Override
    public void hitEvent(InterBlock beingHit, Ball hitter) {
        if (((Block) beingHit).getHitPoints() == 0) {
            beingHit.removeFromGame(this.game);
            beingHit.removeHitListener(this);
            removedBlocks.decrease(1);
        }
    }

}
