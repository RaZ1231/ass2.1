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
import sprites.ALine;
import sprites.Background;
import sprites.Circle;
import sprites.Square;
import sprites.Text;

/**
 * Level 3.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Level3 implements LevelInformation {
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
        velocities.add(new Velocity(0, -4 * 60));
        velocities.add(new Velocity(0, -5 * 60));
        velocities.add(new Velocity(0, -6 * 60));
        velocities.add(new Velocity(0, -7 * 60));
        velocities.add(new Velocity(0, -6 * 60));
        velocities.add(new Velocity(0, -5 * 60));
        velocities.add(new Velocity(0, -4 * 60));
        return velocities;
    }

    /**
     * returns paddle's speed in level.
     *
     * @return paddle's speed in level.
     */
    @Override
    public int paddleSpeed() {
        return 480;
    }

    /**
     * returns paddle's width in level.
     *
     * @return paddle's width in level.
     */
    @Override
    public double paddleWidth() {
        return 300;
    }

    /**
     * returns the level name to be displayed at the top of the screen.
     *
     * @return the level name to be displayed at the top of the screen.
     */
    @Override
    public String levelName() {
        return "Green 3";
    }

    /**
     * returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    @Override
    public Sprite getBackground() {
        Background background = new Background();

        Square back1 = new Square(new Point(0, 0), 800, 600, new Color(179, 248, 255));
        background.addElement(back1);

        Square back2 = new Square(new Point(0, 300), 800, 600, new Color(3, 113, 233));
        background.addElement(back2);

        Square back3 = new Square(new Point(0, 450), 800, 600, new Color(211, 205, 78));
        background.addElement(back3);

        Text t = new Text(new Color(255, 0, 255), new Point(30, 150), "SUMMER!", 70);
        background.addElement(t);

        for (int i = 0; i < 40; i++) {
            Circle c1 = new Circle(new Color(3, 113, 233), new Point(10 * 4 * i, 450), 10);
            Circle c2 = new Circle(new Color(211, 205, 78), new Point(10 * 4 * i + 20, 450), 10);
            background.addElement(c1);
            background.addElement(c2);
        }

        Circle c3 = new Circle(Color.YELLOW, new Point(700, 100), 60);
        background.addElement(c3);

        ALine l1 = new ALine(Color.yellow, new Point(630, 80), new Point(510, 80), 8);
        background.addElement(l1);

        ALine l2 = new ALine(Color.yellow, new Point(630, 120), new Point(520, 140), 8);
        background.addElement(l2);

        ALine l3 = new ALine(Color.yellow, new Point(640, 160), new Point(550, 200), 8);
        background.addElement(l3);

        ALine l4 = new ALine(Color.yellow, new Point(670, 180), new Point(630, 260), 8);
        background.addElement(l4);

        ALine l5 = new ALine(Color.yellow, new Point(710, 180), new Point(730, 260), 10);
        background.addElement(l5);

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
        Color[] c = {Color.green, new Color(255, 128, 64), Color.gray, new Color(0, 255, 255)};

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                Block b = new Block(new Rectangle(30 + 50 * i, 80 + 30 * j, 50, 30), c[j], Color.black, 4 - j);
                blocks.add(b);
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
