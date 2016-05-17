package graphics;

import Animations.GameLevel;
import Animations.GameOver;
import Animations.YouWin;
import biuoop.GUI;
import interfaces.LevelInformation;
import utils.Counter;

import java.util.List;

/**
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class GameFlow {
    private AnimationRunner runner;
    private Counter score;
    private Counter lives;
    private GUI gui;

    public GameFlow(AnimationRunner runner, GUI gui, Counter lives, Counter score) {
        this.runner = runner;
        this.score = score;
        this.lives = lives;
        this.gui = gui;
    }

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
