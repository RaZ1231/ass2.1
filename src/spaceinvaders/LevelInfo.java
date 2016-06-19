package spaceinvaders;

import blocks.BaseBlock;
import blocks.DeathRegion;
import interfaces.LevelInformation;
import interfaces.Sprite;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import motion.Velocity;
import shapes.Point;
import shapes.Rectangle;
import sprites.FillColor;
import sprites.FillImage;

/**
 * level 1.
 *
 * @author Elisheva Broyer.
 * @since 13/05/2016.
 */
public class LevelInfo implements LevelInformation {
    /**
     * returns number of balls played in level.
     *
     * @return number of balls played in level.
     */
    @Override
    public int numberOfBalls() {
        return 0;
    }

    /**
     * returns list of initial velocities of each ball in level.
     *
     * @return list of initial velocities of each ball in level.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        return new ArrayList<>();
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
        return "Level ";
    }

    /**
     * returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new FillImage("space_background.jpg");
    }

    public List<BaseBlock> getDeathRegion() {
        List<BaseBlock> deathRegions = new LinkedList<>();
        DeathRegion d1 = new DeathRegion(new Rectangle(new Point(30, 0), 800, 30),
                new FillColor(null), null);
        deathRegions.add(d1);

        DeathRegion d2 = new DeathRegion(new Rectangle(new Point(30, 570), 800, 30),
                new FillColor(null), null);
        deathRegions.add(d2);

        return deathRegions;
    }

    /**
     * returns a list of the Blocks that make up this level.
     *
     * @return a list of the Blocks that make up this level.
     */
    @Override
    public List<Invader> invaders() {
        List<Invader> invaders = new LinkedList<>();
        FillImage invaderImg = new FillImage("alien.jpg");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                invaders.add(new Invader(new Point(50 * i + 1, 40 * j + 30), invaderImg));
            }
        }

        return invaders;
    }

    /**
     * returns a list of the shield block of level.
     *
     * @return a list of the shield block of level.
     */
    @Override
    public List<ShieldBlock> shields() {
        List<ShieldBlock> shields = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                shields.add(new ShieldBlock(new Point(150 + i, 500 + j)));
                shields.add(new ShieldBlock(new Point(350 + i, 500 + j)));
                shields.add(new ShieldBlock(new Point(550 + i, 500 + j)));
            }
        }

        return shields;
    }

    /**
     * returns the number of invaders that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the number of invaders that should be removed
     * before the level is considered to be "cleared".
     */
    @Override
    public int numberOfBlocksToRemove() {
        return invaders().size();
    }
}
