package levels;

import biuoop.GUI;
import graphics.AnimationRunner;
import graphics.GameFlow;
import interfaces.LevelInformation;
import org.junit.Test;
import scores.HighScoresTable;
import spaceinvaders.LevelInfo;
import utils.Counter;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 20-May-16.
 */
public class LevelsTest {
    @Test
    public void drawBackGround() throws Exception {
        //init game
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        Counter lives = new Counter(7);
        Counter score = new Counter(0);
        List<LevelInformation> levels = new LinkedList<>();
        HighScoresTable hst = HighScoresTable.loadFromFile(new File("highscores.ser"));

        levels.add(new LevelInfo());

        //run
        GameFlow gF = new GameFlow(runner, gui, lives, hst);
        //gF.runLevels(levels);

        gui.close();
    }
}