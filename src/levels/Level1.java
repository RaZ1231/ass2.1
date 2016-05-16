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
        Square back = new Square(800, 600, Color.pink);
        back.addX(0);
        back.addY(0);
        background.addElement(back);

        Circle c1 = new Circle(Color.YELLOW, 250);
        c1.addX(400);
        c1.addY(300);
        background.addElement(c1);

        Circle c2 = new Circle(new Color(185, 122, 87), 140);
        c2.addX(400);
        c2.addY(360);
        background.addElement(c2);

        Square s1 = new Square(280, 140, Color.yellow);
        s1.addX(260);
        s1.addY(220);
        background.addElement(s1);

        Square s2 = new Square(100, 140, new Color(255, 128, 255));
        s1.addX(360);
        s1.addY(380);
        background.addElement(s2);

        Circle c3 = new Circle(new Color(255, 128, 255), 50);
        c3.addX(410);
        c3.addY(520);
        background.addElement(c3);

        Triangle t1a = new Triangle(new Color(185, 122, 87), 60, 20);
        t1a.addX(285);
        t1a.addY(200);
        background.addElement(t1a);
        Triangle t1b = new Triangle(Color.yellow, 50, 20);
        t1b.addX(260);
        t1b.addY(215);
        background.addElement(t1b);

        Triangle t2a = new Triangle(new Color(185, 122, 87), 60, 20);
        t2a.addX(515);
        t2a.addY(200);
        background.addElement(t2a);
        Triangle t2b = new Triangle(Color.yellow, 50, 20);
        t2b.addX(540);
        t2b.addY(215);
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
