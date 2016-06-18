package interfaces;

import motion.Velocity;
import spaceinvaders.Invader;

import java.util.List;

/**
 * Specifies the information required to fully describe a level.
 *
 * @author Raziel Solomon
 * @since 12-May-16.
 */
public interface LevelInformation {
    /**
     * returns number of balls played in level.
     *
     * @return number of balls played in level.
     */
    int numberOfBalls();

    /**
     * returns list of initial velocities of each ball in level.
     *
     * @return list of initial velocities of each ball in level.
     */
    List<Velocity> initialBallVelocities();

    /**
     * returns paddle's speed in level.
     *
     * @return paddle's speed in level.
     */
    int paddleSpeed();

    /**
     * returns paddle's width in level.
     *
     * @return paddle's width in level.
     */
    double paddleWidth();

    /**
     * returns the level name to be displayed at the top of the screen.
     *
     * @return the level name to be displayed at the top of the screen.
     */
    String levelName();

    /**
     * returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * returns a list of the Blocks that make up this level.
     *
     * @return a list of the Blocks that make up this level.
     */
    List<Invader> invaders();

    /**
     * returns the number of invaders that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the number of invaders that should be removed
     * before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}
