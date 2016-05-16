package art;

import Animations.GameLevel;
import levels.Level4;

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
       /* GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        List<LevelInformation> levels = new LinkedList<>();
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());

        GameFlow gF = new GameFlow(runner, gui.getKeyboardSensor());
        gF.runLevels(levels);*/

        GameLevel gameLevel = new GameLevel(new Level4());
        gameLevel.initialize();
        gameLevel.run();

    }
}
