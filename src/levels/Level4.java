package levels;

import Animations.Background;
import blocks.Block;
import interfaces.GameBlock;
import interfaces.LevelInformation;
import interfaces.Sprite;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import motion.Velocity;
import shapes.Rectangle;
import sprites.Square;
import sprites.Text;

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
            velocities.add(new Velocity(0, 4));
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
        return 5;
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
        Background background = new Background();
        Square back = new Square(800, 600, new Color(149, 43, 255));
        back.addX(0);
        back.addY(0);
        background.addElement(back);

        Text t = new Text(Color.yellow, "Almost done...", 80);
        t.addX(100);
        t.addY(500);
        background.addElement(t);

        return background;
    }

    /**
     * returns a list of the Blocks that make up this level.
     *
     * @return a list of the Blocks that make up this level.
     */
    @Override
    public List<GameBlock> blocks() {
        List<GameBlock> blocks = new LinkedList<>();

        Color[] c = new Color[2];
        c[0] = Color.GRAY;
        c[1] = Color.WHITE;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                Block b1 = new Block(new Rectangle(30 + 100 * j, 80 + 30 * 2 * i, 50, 30), c[1], 4);
                blocks.add(b1);
                Block b2 = new Block(new Rectangle(80 + 100 * j, 110 + 30 * 2 * i, 50, 30), c[0], 4);
                blocks.add(b2);
            }
        }

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
        return blocks().size();
    }
}
