package art;

import game.Game;

/**
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */

/**
 * ass3 class.
 */
public class Ass3Game {
    /**
     * the main method of game.
     *
     * @param args data from user
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.initialize();
        game.run();
    }
}
