package Animations;

import biuoop.DrawSurface;
import biuoop.GUI;
import collisions.GameEnvironment;
import game.Paddle;
import game.Stages;
import graphics.AnimationRunner;
import graphics.SpriteCollection;
import indicators.LivesIndicator;
import indicators.RectIndicator;
import indicators.ScoreIndicator;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.GameBlock;
import interfaces.Sprite;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import shapes.Ball;
import shapes.Rectangle;
import utils.Counter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * a game class.
 *
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class GameLevel implements Animation {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter score;
    private Counter lives;
    private Paddle paddle;
    private List<Ball> balls;
    private List<GameBlock> borders;

    private AnimationRunner runner;
    private boolean running;

    /**
     * constructor.
     */
    public GameLevel() {
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        borders = new LinkedList<>();
        borders.addAll(Stages.getBorders(WIDTH, HEIGHT, 15));
        score = new Counter(0);
        lives = new Counter(4);
    }

    public List<GameBlock> getBorders() {
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
        runner = new AnimationRunner(gui, 60);
        paddle = new Paddle(new Rectangle(WIDTH / 2 - 50, HEIGHT - 35, 100, 20),
                gui.getKeyboardSensor(), 15, WIDTH - 15);
        List<GameBlock> blocks = new ArrayList<>(Stages.getStageOne(30, 100, 60, 20));
        blocksCounter = new Counter(blocks.size());
        ballsCounter = new Counter(0);

        BlockRemover blockRemover = new BlockRemover(this, blocksCounter);
        BallRemover ballRemover = new BallRemover(this, ballsCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this, score);
        RectIndicator rectIndicator = new RectIndicator();
        ScoreIndicator scoreIndicator = new ScoreIndicator(score);
        LivesIndicator livesIndicator = new LivesIndicator(lives);

        //PrintingHitListener phl = new PrintingHitListener();

        paddle.addToGame(this);
        rectIndicator.addToGame(this);
        scoreIndicator.addToGame(this);
        livesIndicator.addToGame(this);

        for (GameBlock block : blocks) {
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            //block.addHitListener(phl);
        }

        borders.get(3).addHitListener(ballRemover);
        blocks.addAll(borders);

        for (GameBlock block : blocks) {
            block.addToGame(this);
        }
    }

    public void run() {
        while ((lives.getValue() > 0) && blocksCounter.getValue() > 0) {
            playOneTurn();
        }

        gui.close();
    }

    public void playOneTurn() {
        this.respawn();
        this.runner.run(new CountdownAnimation(2, 3, sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        this.runner.run(this);
    }

    private void respawn() {
        paddle.center(WIDTH);
        initBalls();
    }

    private void initBalls() {
        balls = new LinkedList<Ball>();

        balls.add(new Ball(330, 350, 5, Color.MAGENTA, environment));
        balls.add(new Ball(350, 350, 5, Color.ORANGE, environment));

        for (Ball ball : balls) {
            ball.setVelocity(4, 4);
            ball.addToGame(this);
        }

        ballsCounter.increase(2);
    }

    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (blocksCounter.getValue() == 0) {
            score.increase(100);
            running = false;
        }
        if (ballsCounter.getValue() == 0) {
            lives.decrease(1);
            running = false;
        }
        if (gui.getKeyboardSensor().isPressed("p")) {
            this.runner.run(new PauseScreen(gui.getKeyboardSensor()));
        }
    }

    public boolean shouldStop() {
        return !this.running;
    }
}
