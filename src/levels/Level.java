package levels;

import interfaces.Fill;
import interfaces.GameBlock;
import interfaces.LevelInformation;
import java.util.List;
import motion.Velocity;

/**
 * Level class.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Level implements LevelInformation {
    private List<Velocity> ballVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String name;
    private Fill background;
    private List<GameBlock> blocks;
    private double blocksXPos;
    private double blocksYPos;
    private int numOfBlocks;
    private int rowHeight;
    private BlocksFromSymbolsFactory bFSF;

    /**
     * Constructor.
     */
    public Level() {
        this.ballVelocities = null;
        this.paddleSpeed = 0;
        this.paddleWidth = 0;
        this.name = "";
        this.background = null;
        this.blocks = null;
        this.blocksXPos = 0;
        this.blocksYPos = 0;
        this.numOfBlocks = 0;
        this.rowHeight = 0;
        this.bFSF = null;
    }

    /**
     * paddle speed setter.
     *
     * @param paddleSpeed new speed
     */
    public void setPaddleSpeed(int paddleSpeed) {
        this.paddleSpeed = Math.abs(paddleSpeed);
    }

    /**
     * paddle width setter.
     *
     * @param paddleWidth new width
     */
    public void setPaddleWidth(int paddleWidth) {
        this.paddleWidth = Math.abs(paddleWidth);
    }

    /**
     * name setter.
     *
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * block factory getter.
     *
     * @return block factory
     */
    public BlocksFromSymbolsFactory getbFSF() {
        return bFSF;
    }

    /**
     * block factory setter.
     *
     * @param bFSF new block factory
     */
    public void setbFSF(BlocksFromSymbolsFactory bFSF) {
        this.bFSF = bFSF;
    }

    /**
     * blocks start x getter.
     *
     * @return start x
     */
    public double getBlocksXPos() {
        return blocksXPos;
    }

    /**
     * blocks start x setter.
     *
     * @param blocksXPos new x
     */
    public void setBlocksXPos(double blocksXPos) {
        this.blocksXPos = blocksXPos;
    }

    /**
     * blocks start y getter.
     *
     * @return start y
     */
    public double getBlocksYPos() {
        return blocksYPos;
    }

    /**
     * blocks start y setter.
     *
     * @param blocksYPos new y
     */
    public void setBlocksYPos(double blocksYPos) {
        this.blocksYPos = blocksYPos;
    }

    /**
     * number of blocks getter.
     *
     * @return number of blocks
     */
    public int getNumOfBlocks() {
        return numOfBlocks;
    }

    /**
     * number of blocks setter.
     *
     * @param numOfBlocks set number of blocks
     */
    public void setNumOfBlocks(int numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
    }

    /**
     * row height getter.
     *
     * @return row height
     */
    public int getRowHeight() {
        return rowHeight;
    }

    /**
     * row height setter.
     *
     * @param rowHeight new row height
     */
    public void setRowHeight(int rowHeight) {
        this.rowHeight = Math.abs(rowHeight);
    }

    /**
     * blocks getter.
     *
     * @return blocks
     */
    public List<GameBlock> getBlocks() {
        return blocks;
    }

    /**
     * blocks setter.
     *
     * @param blocks new blocks
     */
    public void setBlocks(List<GameBlock> blocks) {
        this.blocks = blocks;
    }

    /**
     * velocities getter.
     *
     * @return velocities
     */
    public List<Velocity> getBallVelocities() {
        return ballVelocities;
    }

    /**
     * velocities setter.
     *
     * @param ballVelocities new velocities.
     */
    public void setBallVelocities(List<Velocity> ballVelocities) {
        this.ballVelocities = ballVelocities;
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
    public Fill getBackground() {
        return background;
    }

    /**
     * background setter.
     *
     * @param background new background
     */
    public void setBackground(Fill background) {
        this.background = background;
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
