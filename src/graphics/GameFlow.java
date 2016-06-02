package graphics;

import animations.*;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import scores.HighScoresTable;
import scores.NewHighScore;
import scores.ScoreInfo;
import utils.Counter;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * game flow class.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class GameFlow {
    private AnimationRunner runner;
    private Counter lives;
    private GUI gui;
    private HighScoresTable highScores;

    /**
     * constructor.
     *
     * @param runner     an animation runner.
     * @param gui        a gui.
     * @param lives      current lives counter.
     * @param highScores a high scores table.
     */
    public GameFlow(AnimationRunner runner, GUI gui, Counter lives, HighScoresTable highScores) {
        this.runner = runner;
        this.lives = lives;
        this.gui = gui;
        this.highScores = highScores;
    }

    /**
     * running levels one by one according to initialized order.
     *
     * @param levels list f levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean hasLost = false;
        Counter score = new Counter(0);

        for (LevelInformation levelInfo : levels) {

            //levels
            GameLevel level = new GameLevel(levelInfo, runner, gui, lives, score);

            level.initialize();

            while ((level.getBlocksCounter().getValue() > 0) && (level.getLives().getValue() > 0)) {
                level.playOneTurn();
            }

            if (level.getLives().getValue() == 0) {
                hasLost = true;
                break;
            }
        }

        //end game screen
        if (hasLost) {
            this.runner.run(new KeyPressStoppableAnimation(
                    gui.getKeyboardSensor(), KeyboardSensor.SPACE_KEY, new GameOver(score)));
        } else {
            this.runner.run(new KeyPressStoppableAnimation(
                    gui.getKeyboardSensor(), KeyboardSensor.SPACE_KEY, new YouWin(score)));
        }

        //new high score
        if (highScores.checkScore(score.getValue())) {
            NewHighScore nhs = new NewHighScore(gui);
            nhs.showDialog();
            highScores.add(new ScoreInfo(nhs.getpName(), score.getValue()));
            try {
                highScores.save(new File("highscores.ser"));
            } catch (IOException ignored) {
                System.out.println("Couldn't save high scores.");
            }
        }

        //high scores table
        this.runner.run(new KeyPressStoppableAnimation(
                gui.getKeyboardSensor(), KeyboardSensor.SPACE_KEY, new HighScoresAnimation(highScores)));
    }
}
