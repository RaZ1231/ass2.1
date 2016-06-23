package graphics;

import animations.GameLevel;
import animations.GameOver;
import animations.HighScoresAnimation;
import animations.KeyPressStoppableAnimation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import java.io.File;
import java.io.IOException;
import scores.HighScoresTable;
import scores.NewHighScore;
import scores.ScoreInfo;
import utils.Counter;

/**
 * Class responsible for ordering animations.
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
     * @param levelInfo level information.
     */
    public void runLevels(LevelInformation levelInfo) {
        boolean hasLost = false;
        Counter score = new Counter(0);

        while (!hasLost) {
            //levels
            GameLevel level = new GameLevel(levelInfo, runner, gui, lives, score);

            level.initialize();

            while ((level.getInvadersCounter().getValue() > 0) && (level.getLives().getValue() > 0)) {
                level.playOneTurn();
            }

            if (level.getLives().getValue() == 0) {
                hasLost = true;
                break;
            }
        }

        //end game screen
        this.runner.run(new KeyPressStoppableAnimation(
                gui.getKeyboardSensor(), KeyboardSensor.SPACE_KEY, new GameOver(score)));


        //new high score
        if (highScores.checkScore(score.getValue())) {
            NewHighScore nhs = new NewHighScore(gui);
            nhs.showDialog();
            highScores.add(new ScoreInfo(nhs.getpName(), score.getValue()));
            try {
                highScores.save(new File("highscores"));
            } catch (IOException ignored) {
                System.out.println("Couldn't save high scores.");
            }
        }

        //high scores table
        this.runner.run(new KeyPressStoppableAnimation(
                gui.getKeyboardSensor(), KeyboardSensor.SPACE_KEY, new HighScoresAnimation(highScores)));
    }
}
