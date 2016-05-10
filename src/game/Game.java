package game;

import Listener.BlockRemover;
import Listener.ScoreTrackingListener;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import blocks.Block;
import collisions.GameEnvironment;
import graphics.SpriteCollection;
import interfaces.Collidable;
import interfaces.Sprite;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import shapes.Ball;
import shapes.Rectangle;
import utils.Counter;

/**
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */

/**
 * a game class.
 */
public class Game {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blocksCounter;
    private Counter score;
    private List<Block> borders;

    /**
     * constructor.
     */
    public Game() {
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        borders = new LinkedList<>();
        borders.addAll(Stages.getBorders(WIDTH, HEIGHT, 15));
        score = new Counter(0);
    }

    public List<Block> getBorders() {
        return borders;
    }

    /**
     * add a Collidable object to the game.
     *
     * @param c a Collidable object.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * remove a Collidable object from the game.
     *
     * @param c a Collidable object.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * add a Sprite object to the game.
     *
     * @param s a Sprite object.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * remove a Sprite object from the game.
     *
     * @param s a Sprite object.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        Ball ball1 = new Ball(330, 350, 5, Color.MAGENTA, environment);
        Ball ball2 = new Ball(350, 350, 5, Color.ORANGE, environment);
        Paddle paddle = new Paddle(new Rectangle(WIDTH / 2 - 50, HEIGHT - 35, 100, 20),
                gui.getKeyboardSensor(), 15, WIDTH - 15);
        List<Block> blocks = Stages.getStageOne(30, 100, 60, 20);
        blocksCounter = new Counter(blocks.size());
        BlockRemover blockRemover = new BlockRemover(this, blocksCounter);
        ScoreTrackingListener sTL = new ScoreTrackingListener(this, score);
        ScoreIndicator sI = new ScoreIndicator(score);

        ball1.setVelocity(3, 5);
        ball2.setVelocity(2, 4);

        //PrintingHitListener phl = new PrintingHitListener();

        ball1.addToGame(this);
        ball2.addToGame(this);
        paddle.addToGame(this);
        sI.addToGame(this);

        for (Block block : blocks) {
            block.addHitListener(blockRemover);
            block.addHitListener(sTL);
            //block.addHitListener(phl);
        }
        blocks.addAll(borders);
        for (Block block : blocks) {
            block.addToGame(this);
        }
    }

    /**
     * Run the game - start the animation loop.
     */
    public void run() {
        Sleeper sleeper = new Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;

        while (true) {
            long startTime = System.currentTimeMillis(); // timing

            DrawSurface d = gui.getDrawSurface();
            this.sprites.drawAllOn(d);

            gui.show(d);
            this.sprites.notifyAllTimePassed();

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }

            if (blocksCounter.getValue() == 0) {
                score.increase(100);
                gui.close();
            }
        }
    }
}
