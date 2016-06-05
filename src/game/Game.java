package game;

import animations.HighScoresAnimation;
import animations.KeyPressStoppableAnimation;
import animations.MenuAnimation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import graphics.AnimationRunner;
import graphics.GameFlow;
import interfaces.LevelInformation;
import interfaces.Menu;
import interfaces.Task;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import levels.LevelSpecificationReader;
import scores.HighScoresTable;
import utils.Counter;

/**
 * @author Raziel Solomon
 * @since 03-Jun-16.
 */
public class Game {
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

    public void run(String[] args) {
        //init game
        final GUI gui = new GUI("Arkanoid", 800, 600);
        final AnimationRunner runner = new AnimationRunner(gui, 60);
        Counter lives = new Counter(7);
        Menu<Task<Void>> menu = new MenuAnimation("- Arkanoid -", gui.getKeyboardSensor());
        LevelSpecificationReader lSR = new LevelSpecificationReader();
        List<LevelInformation> levelsList = null;
        try {
            levelsList = lSR.fromReader(new BufferedReader(new InputStreamReader(new
                    FileInputStream("definitions/level_definition.txt"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //final List<LevelInformation> levels = buildLevels(args);
        final HighScoresTable highScores = HighScoresTable.loadFromFile(new File("highscores.ser"));
        final GameFlow gF = new GameFlow(runner, gui, lives, highScores);
        final List<LevelInformation> levels = new LinkedList<>(levelsList);
        //menu items
        menu.addSelection("s", "Start", new Task<Void>() {
            @Override
            public Void run() {
                gF.runLevels(levels);
                return null;
            }
        });

        menu.addSelection("h", "High Scores", new Task<Void>() {
            @Override
            public Void run() {
                runner.run(new KeyPressStoppableAnimation(
                        gui.getKeyboardSensor(), KeyboardSensor.SPACE_KEY, new HighScoresAnimation(highScores)));
                return null;
            }
        });

        menu.addSelection("q", "Quit", new Task<Void>() {
            @Override
            public Void run() {
                gui.close();
                System.exit(0);
                return null;
            }
        });

        //run
        while (true) {
            runner.run(menu);
        }
    }
}
