package interfaces;

import blocks.Block;

/**
 * @author Elisheva Broyer.
 * @since 06/06/2016.
 */
public interface BlockCreator {
    // Create a block at the specified location.
    Block create(int xpos, int ypos);
}