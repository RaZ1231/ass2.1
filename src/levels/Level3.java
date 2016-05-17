package levels;

import blocks.Block;
import interfaces.GameBlock;
import interfaces.LevelInformation;
import interfaces.Sprite;
import motion.Velocity;
import shapes.Rectangle;
import sprites.*;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

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
        velocities.add(new Velocity(0, -5));
        velocities.add(new Velocity(3, -4));
        velocities.add(new Velocity(-3, -4));
        return velocities;
    }

    /**
     * returns paddle's speed in level.
     *
     * @return paddle's speed in level.
     */
    @Override
    public int paddleSpeed() {
        return 8;
    }

    /**
     * returns paddle's width in level.
     *
     * @return paddle's width in level.
     */
    @Override
    public double paddleWidth() {
        return 200;
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

        Square back1 = new Square(800, 600, new Color(179, 248, 255));
        back1.addX(0);
        back1.addY(0);
        background.addElement(back1);

        Square back2 = new Square(800, 600, new Color(3, 113, 233));
        back2.addX(0);
        back2.addY(300);
        background.addElement(back2);

        Square back3 = new Square(800, 600, new Color(211, 205, 78));
        back3.addX(0);
        back3.addY(450);
        background.addElement(back3);

        Text t = new Text(new Color(255, 0, 255), "SUMMER!", 70);
        t.addX(30);
        t.addY(150);
        background.addElement(t);

        for (int i = 0; i < 40; i++) {
            Circle c1 = new Circle(new Color(3, 113, 233), 10);
            c1.addX(10 * 4 * i);
            c1.addY(450);
            Circle c2 = new Circle(new Color(211, 205, 78), 10);
            c2.addX(10 * 4 * i + 20);
            c2.addY(450);
            background.addElement(c1);
            background.addElement(c2);
        }

        Circle c3 = new Circle(Color.YELLOW, 60);
        c3.addX(700);
        c3.addY(100);
        background.addElement(c3);

        ALine l1 = new ALine(Color.yellow, 8);
        l1.addX(630);
        l1.addY(80);
        l1.addX(510);
        l1.addY(80);
        background.addElement(l1);

        ALine l2 = new ALine(Color.yellow, 8);
        l2.addX(630);
        l2.addY(120);
        l2.addX(520);
        l2.addY(140);
        background.addElement(l2);

        ALine l3 = new ALine(Color.yellow, 8);
        l3.addX(640);
        l3.addY(160);
        l3.addX(550);
        l3.addY(200);
        background.addElement(l3);

        ALine l4 = new ALine(Color.yellow, 8);
        l4.addX(670);
        l4.addY(180);
        l4.addX(630);
        l4.addY(260);
        background.addElement(l4);

        ALine l5 = new ALine(Color.yellow, 10);
        l5.addX(710);
        l5.addY(180);
        l5.addX(730);
        l5.addY(260);
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
        Color[] c = new Color[4];
        c[0] = Color.green;
        c[1] = new Color(255, 128, 64);
        c[2] = Color.gray;
        c[3] = new Color(0, 255, 255);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                Block b = new Block(new Rectangle(30 + 50 * i, 80 + 30 * j, 50, 30), c[j], 4 - j);
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
