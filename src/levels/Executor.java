package levels;

import interfaces.LevelInformation;
import java.util.List;
import utils.Parser;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Executor {
    public LevelInformation createLevel(String s) {
        Level level = new Level(null, 0, 0, "", "", null, 0, 0, 0, 0);

        Parser parser = new Parser();
        List<String> commands = parser.parseString(s, ".*:{1}.*");

        for (String command : commands) {
            Command comm = new Command(command);
            comm.setLevel(level);
        }

        List<String> Blocks = parser.parseString(s, "START_BLOCKS(.|\\s)*?END_BLOCKS");


        return level;
    }

}
