package levels;

import interfaces.LevelInformation;
import java.util.List;
import utils.Parser;

/**
 * Level factory class.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class LevelFactory {
    /**
     * create method.
     *
     * @param s string to create from
     * @return new level
     */
    public LevelInformation create(String s) {
        Level level = new Level();
        Parser parser = new Parser();
        String[] split;
        List<String> lines = parser.parseString(s, ".*:.*");
        TextEnumHelper helper = new TextEnumHelper();

        //set all members of level.
        for (String line : lines) {
            split = parser.getString(line, "\\w*:.*").split(":");
            LevelSpec spec = (LevelSpec) helper.valueOfText(LevelSpec.values(), split[0]);
            spec.setLevel(level, split[1]);
        }

        //create all blocks of level.
        String blockString = parser.getString(s, "START_BLOCKS(.|\\s)*?END_BLOCKS");
        blockString = blockString.substring("START_BLOCK".length() + 2,
                blockString.length() - ("END_BLOCK".length() + 2));

        BlockListCreator blockListCreator = new BlockListCreator();
        level.setBlocks(blockListCreator.createBlocks(blockString, level));

        return level;
    }

}
