package Animations;

import biuoop.DrawSurface;
import biuoop.GUI;
import collisions.GameEnvironment;
import game.Paddle;
import game.Stages;
import graphics.AnimationRunner;
import graphics.SpriteCollection;
import indicators.LevelIndicator;
import indicators.LivesIndicator;
import indicators.RectIndicator;
import indicators.ScoreIndicator;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.GameBlock;
import interfaces.LevelInformation;
import interfaces.Sprite;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import motion.Velocity;
import shapes.Ball;
import shapes.Rectangle;
import utils.Counter;

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
    private LevelInformation level;

    /**
     * constructor.
     */
    public GameLevel(LevelInformation gLevel) {

        level = gLevel;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        borders = new LinkedList<>();
        borders.addAll(Stages.getBorders(WIDTH, HEIGHT, 15));
        score = new Counter(0);
        lives = new Counter(4);
    }

    public Counter getBlocksCounter() {
        return blocksCounter;
    }

    public Counter getLives() {
        return lives;
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
        paddle = new Paddle(new Rectangle(WIDTH / 2 - 50, HEIGHT - 35, level.paddleWidth(), 20),
                gui.getKeyboardSensor(), 15, WIDTH - 15, level.paddleSpeed());
        List<GameBlock> blocks = level.blocks();
        blocksCounter = new Counter(level.numberOfBlocksToRemove());
        ballsCounter = new Counter(level.numberOfBalls());

        BlockRemover blockRemover = new BlockRemover(this, blocksCounter);
        BallRemover ballRemover = new BallRemover(this, ballsCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this, score);
        RectIndicator rectIndicator = new RectIndicator();
        ScoreIndicator scoreIndicator = new ScoreIndicator(score);
        LivesIndicator livesIndicator = new LivesIndicator(lives);
        LevelIndicator levelIndicator = new LevelIndicator(level);

        //PrintingHitListener phl = new PrintingHitListener();
        level.getBackground().addToGame(this);
        paddle.addToGame(this);
        rectIndicator.addToGame(this);
        scoreIndicator.addToGame(this);
        livesIndicator.addToGame(this);
        levelIndicator.addToGame(this);

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

        for (int i = 0; i < level.numberOfBalls(); i++) {
            balls.add(new Ball(400 + i * 6, HEIGHT - 36, 5, Color.WHITE, environment));
        }

        for (int i = 0; i < level.numberOfBalls(); i++) {
            Velocity v = level.initialBallVelocities().get(i);
            balls.get(i).setVelocity(v);
            balls.get(i).addToGame(this);
        }

        ballsCounter.increase(level.numberOfBalls());
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
