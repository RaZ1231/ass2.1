package levels;

import blocks.Block;
import interfaces.BlockCreator;
import java.util.Map;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class BlocksFromSymbolsFactory {
    private Map<String, Integer> spacerWidths;
    private Map<String, BlockCreator> blockCreators;

    // returns true if 's' is a valid space symbol.
    public boolean isSpaceSymbol(String s) {
        return false;
    }

    // returns true if 's' is a valid block symbol.
    public boolean isBlockSymbol(String s) {
        return false;
    }

    // Return a block according to the definitions associated
    // with symbol s. The block will be located at position (xpos, ypos).
    public Block getBlock(String s, int xpos, int ypos) {
        return null;
    }

    // Returns the width in pixels associated with the given spacer-symbol.
    public int getSpaceWidth(String s) {
        return 0;
    }
}
