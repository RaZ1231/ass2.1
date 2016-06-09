package levels;

import blocks.BlockListCreator;
import interfaces.LevelInformation;
import utils.Parser;

import java.util.List;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Executor {
    public LevelInformation createLevel(String s) {
        Level level = new Level();
        Parser parser = new Parser();
        List<String> lines = parser.parseString(s, ".*:{1}.*");

        //set all members of level.
        for (String line : lines) {
            Spec spec = Spec.valueOfText(line.split(":")[0]);
            String value = line.split(":")[1];
            spec.setLevel(level, value);
        }

        //create all blocks of level.
        String blockString = parser.getString(s, "START_BLOCKS(.|\\s)*?END_BLOCKS");
        BlockListCreator blockListCreator = new BlockListCreator();
        level.setBlocks(blockListCreator.createBlocks(blockString.substring(14, blockString.length() - 12), level));

        return level;
    }

}
