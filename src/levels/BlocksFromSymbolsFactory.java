package levels;

import blocks.Block;
import interfaces.BlockCreator;

import java.util.Map;

/**
 * Blocks from symbols factory class.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class BlocksFromSymbolsFactory {
    private Map<String, Integer> spacerWidths;
    private Map<String, BlockCreator> blockCreators;

    /**
     * spacers setter.
     *
     * @param spacerWidths new spacers
     */
    public void setSpacerWidths(Map<String, Integer> spacerWidths) {
        this.spacerWidths = spacerWidths;
    }

    /**
     * creators setter.
     *
     * @param blockCreators new creators
     */
    public void setBlockCreators(Map<String, BlockCreator> blockCreators) {
        this.blockCreators = blockCreators;
    }

    /**
     * returns true if 's' is a valid space symbol.
     *
     * @param s a symbol.
     * @return true if 's' is a valid space symbol.
     */
    public boolean isSpaceSymbol(String s) {
        for (String key : spacerWidths.keySet()) {
            if (key.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * returns true if 's' is a valid block symbol.
     *
     * @param s a symbol.
     * @return true if 's' is a valid block symbol.
     */
    public boolean isBlockSymbol(String s) {
        for (String key : blockCreators.keySet()) {
            if (key.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a block according to the definitions associated
     * with symbol s. The block will be located at position (xpos, ypos).
     *
     * @param s symbol
     * @param x x pos
     * @param y y pos
     * @return block
     */
    public Block getBlock(String s, int x, int y) {
        return this.blockCreators.get(s).create(x, y);
    }

    /**
     * Returns the width in pixels associated with the given spacer-symbol.
     *
     * @param s space symbol
     * @return width
     */
    public int getSpaceWidth(String s) {
        return this.spacerWidths.get(s);
    }


}
