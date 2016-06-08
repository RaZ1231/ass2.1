package levels;

import interfaces.GameBlock;
import interfaces.LevelInformation;
import java.util.LinkedList;
import java.util.List;
import utils.Parser;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Executor {
    public LevelInformation createLevel(String s) {
        Level level = new Level();

        Parser parser = new Parser();
        List<String> commands = parser.parseString(s, ".*:{1}.*");

        for (String command : commands) {
            Command comm = new Command(command);
            comm.setLevel(level);
        }

        String blockString = parser.getString(s, "START_BLOCKS(.|\\s)*?END_BLOCKS");
        String str = blockString.substring(14, blockString.length() - 12);

        double x = level.getBlocksXPos();
        double y = level.getBlocksYPos();
        List<GameBlock> blocks = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            String symbol = "" + str.charAt(i);
            if (level.getbFSF().isSpaceSymbol(symbol)) {
                x += level.getbFSF().getSpaceWidth(symbol);
            } else if (level.getbFSF().isBlockSymbol(symbol)) {
                blocks.add(level.getbFSF().getBlock(symbol, (int) x, (int) y));
            } else if (symbol.equals("\n")) {
                x = level.getBlocksXPos();
                y += level.getRowHeight();
            }
        }

        level.setBlocks(blocks);

        return level;
    }

}
