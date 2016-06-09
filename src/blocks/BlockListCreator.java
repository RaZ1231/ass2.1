package blocks;

import interfaces.GameBlock;
import java.util.LinkedList;
import java.util.List;
import levels.Level;

/**
 * creator of a block list.
 *
 * @author Elisheva Broyer.
 * @since 08/06/2016.
 */
public class BlockListCreator {
    /**
     * returns a list of block.
     *
     * @param string a string.
     * @param level  a level.
     * @return a list of block.
     */
    public List<GameBlock> createBlocks(String string, Level level) {
        double x = level.getBlocksXPos();
        double y = level.getBlocksYPos();
        List<GameBlock> blocks = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {
            String symbol = "" + string.charAt(i);
            if (level.getbFSF().isSpaceSymbol(symbol)) {
                x += level.getbFSF().getSpaceWidth(symbol);
            } else if (level.getbFSF().isBlockSymbol(symbol)) {
                blocks.add(level.getbFSF().getBlock(symbol, (int) x, (int) y));
            } else if (symbol.equals("\n")) {
                x = level.getBlocksXPos();
                y += level.getRowHeight();
            }
        }
        return blocks;
    }
}
