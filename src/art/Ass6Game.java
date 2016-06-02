package art;

import biuoop.GUI;
import graphics.AnimationRunner;
import graphics.GameFlow;
import interfaces.LevelInformation;
import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import scores.HighScoresTable;
import utils.Counter;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * ass3 class.
 *
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class Ass5Game {
    /**
     * the main method of game.
     *
     * @param args data from user
     */
    public static void main(String[] args) {
        //init game
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        Counter lives = new Counter(7);
        List<LevelInformation> levels = buildLevels(args);

        //high scores
        HighScoresTable highScores = HighScoresTable.loadFromFile(new File("highscores.ser"));

        //run
        GameFlow gF = new GameFlow(runner, gui, lives, highScores);
        gF.runLevels(levels);

        gui.close();
    }

    /**
     * returns list of levels.
     *
     * @param args data from user.
     * @return list of levels.
     */
    private static List<LevelInformation> buildLevels(String[] args) {
        List<LevelInformation> levels = new LinkedList<>();

        for (String arg : args) {
            switch (arg) {
                case "1":
                    levels.add((new Level1()));
                    break;
                case "2":
                    levels.add((new Level2()));
                    break;
                case "3":
                    levels.add((new Level3()));
                    break;
                case "4":
                    levels.add((new Level4()));
                    break;
                default:
            }
        }

        if (levels.size() == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        }

        return levels;
    }
}
