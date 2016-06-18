package spaceinvaders;

import interfaces.LevelInformation;
import interfaces.Sprite;
import motion.Velocity;
import shapes.Point;
import sprites.FillColor;
import sprites.FillImage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        return new FillColor(Color.gray);
    }

    /**
     * returns a list of the Blocks that make up this level.
     *
     * @return a list of the Blocks that make up this level.
     */
    @Override
    public List<Invader> invaders() {
        List<Invader> invaders = new LinkedList<>();
        FillImage invaderImg = new FillImage("enemy.png");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                invaders.add(new Invader(new Point(50 * i + 1, 40 * j + 30), invaderImg));
            }
        }

        return invaders;
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
