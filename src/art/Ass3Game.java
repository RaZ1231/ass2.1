package art;

import Animations.GameLevel;
import levels.Level2;

/**
 * ass3 class.
 *
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class Ass3Game {
    /**
     * the main method of game.
     *
     * @param args data from user
     */
    public static void main(String[] args) {
        Level2 level = new Level2();

        GameLevel gameLevel = new GameLevel(level);
        gameLevel.initialize();
        gameLevel.run();
    }
}
