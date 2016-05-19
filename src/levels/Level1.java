package levels;

import blocks.Block;
import interfaces.GameBlock;
import interfaces.LevelInformation;
import interfaces.Sprite;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import motion.Velocity;
import shapes.Point;
import shapes.Rectangle;
import sprites.Background;
import sprites.Circle;
import sprites.Square;
import sprites.Triangle;

/**
 * level 1.
 *
 * @author Elisheva Broyer.
 * @since 13/05/2016.
 */
public class Level1 implements LevelInformation {
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

        velocities.add(new Velocity(0, 4));

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
        return "Direct Hit";
    }

    /**
     * returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    @Override
    public Sprite getBackground() {
        Background background = new Background();
        Square back = new Square(new Point(0, 0), 800, 600, Color.pink);
        background.addElement(back);

        Circle c1 = new Circle(Color.YELLOW, new Point(400, 300), 250);
        background.addElement(c1);

        Circle c2 = new Circle(new Color(185, 122, 87), new Point(400, 360), 140);
        background.addElement(c2);

        Square s1 = new Square(new Point(260, 220), 280, 140, Color.yellow);
        background.addElement(s1);

        Square s2 = new Square(new Point(360, 380), 100, 140, new Color(255, 128, 255));
        background.addElement(s2);

        Circle c3 = new Circle(new Color(255, 128, 255), new Point(410, 520), 50);
        background.addElement(c3);

        Triangle t1a = new Triangle(new Color(185, 122, 87), new Point(285, 200), 60);
        background.addElement(t1a);

        Triangle t1b = new Triangle(Color.yellow, new Point(260, 215), 50);
        background.addElement(t1b);

        Triangle t2a = new Triangle(new Color(185, 122, 87), new Point(515, 200), 60);
        background.addElement(t2a);

        Triangle t2b = new Triangle(Color.yellow, new Point(540, 215), 50);
        background.addElement(t2b);

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
        Block b = new Block(new Rectangle(350, 100, 100, 50), Color.RED, 1);

        blocks.add(b);

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
