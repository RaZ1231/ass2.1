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
import sprites.Circle;
import sprites.Square;
import sprites.Star;

/**
 * level 1 class.
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

        velocities.add(new Velocity(3, 0));

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
        Square s1 = new Square(0, 0, 800, 600, Color.BLUE);
        background.addElement(s1);
        Circle c1 = new Circle(Color.yellow, 50);
        c1.addX(250);
        c1.addY(250);
        Circle c2 = new Circle(Color.BLUE, 50);
        c2.addX(270);
        c2.addY(230);
        background.addElement(c1);
        background.addElement(c2);
        Star st1 = new Star(Color.WHITE, 100, 100, 20, 10);
        background.addElement(st1);
        Star st2 = new Star(Color.WHITE, 190, 160, 20, 10);
        background.addElement(st2);
        Star st3 = new Star(Color.WHITE, 200, 420, 20, 10);
        background.addElement(st3);
        Star st4 = new Star(Color.WHITE, 530, 200, 20, 10);
        background.addElement(st4);
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
        Block b = new Block(new Rectangle(400, 100, 50, 50), Color.RED, 1);

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
