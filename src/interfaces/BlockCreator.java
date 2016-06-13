package interfaces;

import blocks.Block;

/**
 * block creator interface.
 *
 * @author Elisheva Broyer.
 * @since 06/06/2016.
 */
public interface BlockCreator {
    /**
     * Create a block at the specified location.
     *
     * @param xpos position on x-axes.
     * @param ypos position on y-axes.
     * @return a block.
     */
    Block create(int xpos, int ypos);
}