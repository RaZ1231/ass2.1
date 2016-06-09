package levels;

import interfaces.GameBlock;
import interfaces.LevelInformation;
import interfaces.Sprite;
import java.util.List;
import motion.Velocity;
import shapes.Point;
import sprites.AImage;
import sprites.Background;

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

    public void setPaddleSpeed(int paddleSpeed) {
        this.paddleSpeed = paddleSpeed;
    }

    public void setPaddleWidth(int paddleWidth) {
        this.paddleWidth = paddleWidth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BlocksFromSymbolsFactory getbFSF() {
        return bFSF;
    }

    public void setbFSF(BlocksFromSymbolsFactory bFSF) {
        this.bFSF = bFSF;
    }

    public double getBlocksXPos() {
        return blocksXPos;
    }

    public void setBlocksXPos(double blocksXPos) {
        this.blocksXPos = blocksXPos;
    }

    public double getBlocksYPos() {
        return blocksYPos;
    }

    public void setBlocksYPos(double blocksYPos) {
        this.blocksYPos = blocksYPos;
    }

    public int getNumOfBlocks() {
        return numOfBlocks;
    }

    public void setNumOfBlocks(int numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
    }

    public int getRowHeight() {
        return rowHeight;
    }

    public void setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
    }

    public List<GameBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<GameBlock> blocks) {
        this.blocks = blocks;
    }

    public List<Velocity> getBallVelocities() {
        return ballVelocities;
    }

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
    public Sprite getBackground() {
        Background background = new Background();
        background.addElement(new AImage(this.background, new Point(0, 0)));
        return background;
    }

    public void setBackground(String background) {
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
