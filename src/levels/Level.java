package levels;

import interfaces.GameBlock;
import interfaces.LevelInformation;
import interfaces.Sprite;
import java.util.List;
import motion.Velocity;
import shapes.Point;

/**
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Level implements LevelInformation {
    private List<Velocity> ballVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String name;
    private String background;
    private List<GameBlock> blocks;
    private Point blocksPos;
    private int numOfBlocks;
    private int rowHeight;

    /**
     * Constructor.
     *
     * @param ballVelocities a list of balls.
     * @param paddleSpeed    level's paddle's speed.
     * @param paddleWidth    level's paddle's width.
     * @param name           level's name.
     * @param background     level's background.
     * @param blocks         a list of blocks.
     */
    public Level(List<Velocity> ballVelocities, int paddleSpeed, int paddleWidth, String name,
                 String background, List<GameBlock> blocks, Point blocksPos, int numOfBlocks, int rowHeight) {
        this.ballVelocities = ballVelocities;
        this.paddleSpeed = paddleSpeed;
        this.paddleWidth = paddleWidth;
        this.name = name;
        this.background = background;
        this.blocks = blocks;
        this.blocksPos = blocksPos;
        this.numOfBlocks = numOfBlocks;
        this.rowHeight = rowHeight;
    }

    /**
     * returns number of balls played in level.
     *
     * @return number of balls played in level.
     */
    @Override
    public int numberOfBalls() {
        return ballVelocities.size();
    }

    /**
     * returns list of initial velocities of each ball in level.
     *
     * @return list of initial velocities of each ball in level.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        return ballVelocities;
    }

    /**
     * returns paddle's speed in level.
     *
     * @return paddle's speed in level.
     */
    @Override
    public int paddleSpeed() {
        return paddleSpeed;
    }

    /**
     * returns paddle's width in level.
     *
     * @return paddle's width in level.
     */
    @Override
    public double paddleWidth() {
        return paddleWidth;
    }

    /**
     * returns the level name to be displayed at the top of the screen.
     *
     * @return the level name to be displayed at the top of the screen.
     */
    @Override
    public String levelName() {
        return name;
    }

    /**
     * returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return null;
    }

    /**
     * returns a list of the Blocks that make up this level.
     *
     * @return a list of the Blocks that make up this level.
     */
    @Override
    public List<GameBlock> blocks() {
        return blocks;
    }

    /**
     * returns the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the number of blocks that should be removed
     * before the level is considered to be "cleared".
     */
    @Override
    public int numberOfBlocksToRemove() {
        return blocks.size();
    }
}
