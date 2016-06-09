package levels;

import blocks.BlockListCreator;
import interfaces.LevelInformation;
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

        //set all members of level.
        for (String command : commands) {
            Command comm = new Command(command);
            comm.setLevel(level);
        }

        //create all blocks of level.
        String blockString = parser.getString(s, "START_BLOCKS(.|\\s)*?END_BLOCKS");
        BlockListCreator blockListCreator = new BlockListCreator();
        level.setBlocks(blockListCreator.createBlocks(blockString.substring(14, blockString.length() - 12), level));

        return level;
    }

}
