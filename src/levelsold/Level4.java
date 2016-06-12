package levelsold;

import interfaces.GameBlock;
import interfaces.LevelInformation;
import interfaces.Sprite;
import motion.Velocity;
import shapes.Point;
import sprites.Background;
import sprites.Chess;
import sprites.Text;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * Level 4.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Level4 implements LevelInformation {
    /**
     * returns number of balls played in level.
     *
     * @return number of balls played in level.
     */
    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    /**
     * returns list of initial velocities of each ball in level.
     *
     * @return list of initial velocities of each ball in level.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new LinkedList<>();
        for (int i = 0; i < 1; i++) {
            velocities.add(new Velocity(0, -4 * 60));
        }
        return velocities;
    }

    /**
     * returns paddle's speed in level.
     *
     * @return paddle's speed in level.
     */
    @Override
    public int paddleSpeed() {
        return 300;
    }

    /**
     * returns paddle's width in level.
     *
     * @return paddle's width in level.
     */
    @Override
    public double paddleWidth() {
        return 100;
    }

    /**
     * returns the level name to be displayed at the top of the screen.
     *
     * @return the level name to be displayed at the top of the screen.
     */
    @Override
    public String levelName() {
        return "Final Four";
    }

    /**
     * returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    @Override
    public Sprite getBackground() {
        int width = 80;
        int height = 30;

        Background background = new Background();
        Chess back = new Chess(Color.white, new Point(0, 0), 800 / width, 600 / height, width, height, 4);
        background.addElement(back);

        int x = 100;
        int y = 150;

        Text t1 = new Text(Color.black, new Point(x - 5, y - 5), "Almost done...", 80);
        background.addElement(t1);
        Text t2 = new Text(Color.black, new Point(x + 5, y + 5), "Almost done...", 80);
        background.addElement(t2);
        Text t3 = new Text(Color.white, new Point(x, y), "Almost done...", 80);
        background.addElement(t3);

        return background;
    }

    /**
     * returns a list of the Blocks that make up this level.
     *
     * @return a list of the Blocks that make up this level.
     */
    @Override
    public List<GameBlock> blocks() {
        return new Chess(Color.black, new Point(80, 60), 720 / 80, 210 / 30, 80, 30, 4).getBlocks();
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
        return blocks().size();
    }
}
