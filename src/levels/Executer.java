package levels;

import interfaces.LevelInformation;
import java.util.List;
import utils.Parser;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Executer {
    public LevelInformation createLevel(String s) {
        Level level = new Level(null, 0, 0, "", "", null, 0, 0, 0, 0);

        Parser parser = new Parser();
        List<String> commands = parser.parseString(s, "(\\w):+(\\w|\\s)*");

        for (String command : commands) {
            Command comm = new Command(command);
            comm.setLevel(level);
        }

        List<String> Blocks = parser.parseString(s, "START_BLOCKS()END_BLOCKS");


        return level;
        /*
        String leveName = parser.getExpression(s, 1);
        String backGroundPath = parser.getExpression(s, 3);
        int paddleSpeed = Integer.parseInt(parser.getExpression(s, 4));
        int paddleWidth = Integer.parseInt(parser.getExpression(s, 5));
        int numOfBlocks = Integer.parseInt(parser.getExpression(s, 10));
        int rowHeight = Integer.parseInt(parser.getExpression(s, 2));

        BlockFactory bFactory = new BlockFactory();
        List<GameBlock> blocks = bFactory.createBlocks(parser.getExpression(s, 6));

        VelocityFactory vFactory = new VelocityFactory();
        List<Velocity> velocities = vFactory.createVelocities(parser.getExpression(s, 2));


        Point blocksPos = new Point(Integer.parseInt(parser.getExpression(s, 7)),
                Integer.parseInt(parser.getExpression(s, 8)));

        return new Level(velocities, paddleSpeed, paddleWidth, backGroundPath, leveName, blocks, blocksPos,
                numOfBlocks, rowHeight);
         */
    }

}
