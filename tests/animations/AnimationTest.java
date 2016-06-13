package animations;

import biuoop.GUI;
import graphics.AnimationRunner;
import graphics.GameFlow;
import interfaces.LevelInformation;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import scores.HighScoresTable;
import utils.Counter;

/**
 * @author Raziel Solomon
 * @since 19-May-16.
 */
public class AnimationTest {
    @Test
    public void youWin() throws Exception {
        //init game
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        Counter lives = new Counter(7);
        Counter score = new Counter(0);
        List<LevelInformation> levels = new LinkedList<>();
        HighScoresTable hst = HighScoresTable.loadFromFile(new File("highscores.ser"));

        //run
        GameFlow gF = new GameFlow(runner, gui, lives, hst);
        gF.runLevels(levels);

        gui.close();
    }

    @Test
    public void HighScores() throws Exception {
        //init game
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        Counter lives = new Counter(7);
        Counter score = new Counter(0);
        List<LevelInformation> levels = new LinkedList<>();
        HighScoresTable hst = HighScoresTable.loadFromFile(new File("highscores"));

        System.out.println(hst);

        HighScoresAnimation hsa = new HighScoresAnimation(hst);

        runner.run(hsa);

        //run


        gui.close();
    }

    @Test
    public void menu() throws Exception {
        //init game
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        MenuAnimation menu = new MenuAnimation("- Arkanoid -", gui.getKeyboardSensor());

        menu.addSelection("s", "Start", null);
        menu.addSelection("h", "High Scores", null);
        menu.addSelection("q", "Quit", null);

        //run
        runner.run(menu);

        gui.close();
    }
}