package graphics;

import Animations.GameLevel;
import Animations.GameOver;
import Animations.YouWin;
import biuoop.GUI;
import interfaces.LevelInformation;
import java.util.List;
import utils.Counter;

/**
 * game flow class.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class GameFlow {
    private AnimationRunner runner;
    private Counter score;
    private Counter lives;
    private GUI gui;

    /**
     * constructor.
     *
     * @param runner an animation runner.
     * @param gui    a gui.
     * @param lives  current lives counter.
     * @param score  current scores counter.
     */
    public GameFlow(AnimationRunner runner, GUI gui, Counter lives, Counter score) {
        this.runner = runner;
        this.score = score;
        this.lives = lives;
        this.gui = gui;
    }

    /**
     * running levels one by one according to initialized order.
     *
     * @param levels list f levels.
     */
    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, runner, gui, lives, score);

            level.initialize();

            while ((level.getBlocksCounter().getValue() > 0) && (level.getLives().getValue() > 0)) {
                level.playOneTurn();
            }

            if (level.getLives().getValue() == 0) {
                this.runner.run(new GameOver(gui.getKeyboardSensor(), score));
            }

        }

        this.runner.run(new YouWin(gui.getKeyboardSensor(), score));
    }
}
