package Animations;

import biuoop.GUI;
import graphics.AnimationRunner;
import graphics.GameFlow;
import interfaces.LevelInformation;
import org.junit.Test;
import utils.Counter;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 19-May-16.
 */
public class YouWinTest {
    @Test
    public void drawBackGround() throws Exception {
        //init game
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        Counter lives = new Counter(7);
        Counter score = new Counter(0);
        List<LevelInformation> levels = new LinkedList<>();

        //run
        GameFlow gF = new GameFlow(runner, gui, lives, score);
        gF.runLevels(levels);

        gui.close();
    }

}