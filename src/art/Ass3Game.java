package art;

import Animations.GameLevel;

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
        GameLevel gameLevel = new GameLevel();
        gameLevel.initialize();
        gameLevel.run();
    }
}
