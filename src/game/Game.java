package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import collisions.GameEnvironment;
import graphics.SpriteCollection;
import interfaces.Collidable;
import interfaces.Sprite;
import shapes.Ball;
import shapes.Rectangle;

import java.awt.Color;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class Game {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;

    public Game() {
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
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
     * add a Sprite object to the game.
     *
     * @param s a Sprite object.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        Ball ball = new Ball(50, 500, 10, Color.MAGENTA, environment);
        ball.setVelocity(0, 5);
        Paddle paddle = new Paddle(new Rectangle(WIDTH / 2 - 50, 500, 100, 20), gui.getKeyboardSensor());
        double startX = 30;
        double startY = 100;
        double width = 60;
        double height = 20;
        List<Block> blocks = Stages.getStageOne(startX, startY, width, height);

        blocks.addAll(Stages.getBorders(WIDTH, HEIGHT));

        ball.addToGame(this);
        paddle.addToGame(this);
        for (Block block : blocks) {
            block.addToGame(this);
        }

    }

    /**
     * Run the game -- start the animation loop.
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
        }
    }

}
