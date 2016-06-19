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
import java.io.File;
import scores.HighScoresTable;
import spaceinvaders.LevelInfo;
import utils.Counter;

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
        final GUI gui = new GUI("Space Invaders", 800, 600);
        final AnimationRunner runner = new AnimationRunner(gui, 60);
        Menu<Task<Void>> menu = new MenuAnimation("Space Invaders", gui.getKeyboardSensor());

        /*
        List<LevelSet> levelSets;
        String path = args.length > 0 ? args[0] : "level_sets.txt"; //check args

        levelSets = LevelSetsReader.fromReader(new BufferedReader(
                new InputStreamReader(ClassLoader.getSystemClassLoader()
                        .getResourceAsStream(path))));

        final List<LevelSet> lSets = levelSets;
        */
        final HighScoresTable highScores = HighScoresTable.loadFromFile(new File("highscores"));

        //menu items
        menu.addSelection("s", "Start", new Task<Void>() {
            @Override
            public Void run() {
                GameFlow gF = new GameFlow(runner, gui, new Counter(3), highScores);
                gF.runLevels(new LevelInfo());
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
            menu.restart();
            runner.run(menu);
            menu.getStatus().run();
        }
    }
}
