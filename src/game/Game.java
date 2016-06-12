package game;

import animations.HighScoresAnimation;
import animations.KeyPressStoppableAnimation;
import animations.MenuAnimation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import graphics.AnimationRunner;
import graphics.GameFlow;
import interfaces.Menu;
import interfaces.Task;
import levels.LevelSet;
import levels.LevelSetsReader;
import scores.HighScoresTable;
import utils.Counter;
import utils.SubMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Game class.
 *
 * @author Raziel Solomon
 * @since 03-Jun-16.
 */
public class Game {
    /**
     * run the game.
     *
     * @param args main's arguments
     */
    public void run(String[] args) {
        //init game
        final GUI gui = new GUI("Arkanoid", 800, 600);
        final AnimationRunner runner = new AnimationRunner(gui, 60);
        Menu<Task<Void>> menu = new MenuAnimation("- Arkanoid -", gui.getKeyboardSensor());
        List<LevelSet> levelSets;
        String path = args.length > 0 ? args[0] : "level_sets.txt"; //check args

        try {
            levelSets = LevelSetsReader.fromReader(new BufferedReader(new InputStreamReader(new
                    FileInputStream(path))));
        } catch (FileNotFoundException e) {
            levelSets = new LinkedList<>();
        }

        final List<LevelSet> lSets = levelSets;
        final HighScoresTable highScores = HighScoresTable.loadFromFile(new File("highscores.ser"));

        //menu items
        SubMenu sets = new SubMenu("Sets :", gui.getKeyboardSensor());

        for (final LevelSet set : lSets) {
            sets.addSelection(set.getKey(), set.getName(), new Task<Void>() {
                @Override
                public Void run() {
                    GameFlow gF = new GameFlow(runner, gui, new Counter(7), highScores);
                    gF.runLevels(set.getLevels());
                    return null;
                }
            });
        }

        menu.addSubMenu("s", "Start", sets);

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
            menu.restart();
            runner.run(menu);
            menu.getStatus().run();
        }
    }
}
