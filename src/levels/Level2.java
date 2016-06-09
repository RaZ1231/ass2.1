package levels;

import blocks.Block;
import interfaces.GameBlock;
import interfaces.LevelInformation;
import interfaces.Sprite;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import motion.Velocity;
import shapes.Point;
import shapes.Rectangle;
import sprites.Background;
import sprites.Circle;
import sprites.Square;
import sprites.Star;

/**
 * Level 2.
 *
 * @author Elisheva Broyer.
 * @since 13/05/2016.
 */
public class Level2 implements LevelInformation {
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
        for (int i = 0; i < 5; i++) {
            velocities.add(new Velocity(0, (-3 - i) * 60));

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
        return 240;
    }

    /**
     * returns paddle's width in level.
     *
     * @return paddle's width in level.
     */
    @Override
    public double paddleWidth() {
        return 500;
    }

    /**
     * returns the level name to be displayed at the top of the screen.
     *
     * @return the level name to be displayed at the top of the screen.
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    @Override
    public Sprite getBackground() {
        Background background = new Background();
        Square back = new Square(new Point(0, 0), 800, 600, new Color(0, 0, 128));
        background.addElement(back);

        Circle c1 = new Circle(Color.yellow, new Point(250, 250), 50);
        background.addElement(c1);
        Circle c2 = new Circle(new Color(0, 0, 128), new Point(270, 230), 50);
        background.addElement(c2);

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            Star st = new Star(Color.WHITE,
                    new Point(rand.nextInt(760) + 40, rand.nextInt(560) + 40), 20, 10);
            background.addElement(st);
        }

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

        for (int i = 0; i < 15; i++) {
            Block b = new Block(new Rectangle(15 + i * 50, 100, 50, 30), Color.gray, Color.black, 2);

            blocks.add(b);
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
