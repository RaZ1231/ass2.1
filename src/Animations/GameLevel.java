package Animations;

import biuoop.DrawSurface;
import biuoop.GUI;
import collisions.GameEnvironment;
import game.Borders;
import game.Paddle;
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
 * a game level class.
 *
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class GameLevel implements Animation {
    private int width;
    private int height;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter score;
    private Counter lives;
    private Paddle paddle;
    private List<GameBlock> borders;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation level;

    /**
     * constructor.
     *
     * @param gLevel a level.
     * @param runner an animation runner.
     * @param gui    a gui.
     * @param lives  lives counter.
     * @param score  scores counter.
     */
    public GameLevel(LevelInformation gLevel, AnimationRunner runner, GUI gui, Counter lives,
                     Counter score) {
        level = gLevel;
        this.score = score;
        this.lives = lives;
        this.runner = runner;
        this.gui = gui;
    }

    /**
     * returns level's number of blocks.
     *
     * @return level's number of blocks.
     */
    public Counter getBlocksCounter() {
        return blocksCounter;
    }

    /**
     * returns current number of lives.
     *
     * @return current number of lives.
     */
    public Counter getLives() {
        return lives;
    }

    /**
     * returns game's borders.
     *
     * @return game's borders.
     */
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
     * Initialize a new level: create the Blocks, Ball and Paddle
     * and add them to the game.
     * Also draws the level's background.
     */
    public void initialize() {
        width = gui.getDrawSurface().getWidth();
        height = gui.getDrawSurface().getHeight();

        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        borders = new LinkedList<>();
        borders.addAll(Borders.getBorders(width, height, 15));

        paddle = new Paddle(new Rectangle(width / 2 - 50, height - 35, level.paddleWidth(), 20),
                gui.getKeyboardSensor(), 15, width - 15, level.paddleSpeed());
        List<GameBlock> blocks = level.blocks();
        blocksCounter = new Counter(level.numberOfBlocksToRemove());
        ballsCounter = new Counter(0);

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

    /**
     * run one turn of the game.
     */
    public void playOneTurn() {
        this.respawn();
        this.runner.run(new CountdownAnimation(2, 3, sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        this.runner.run(this);
    }

    /**
     * initial paddle and balls.
     */
    private void respawn() {
        paddle.center(width);
        initBalls();
    }

    /**
     * initial balls according to level's information.
     */
    private void initBalls() {
        List<Ball> balls = new LinkedList<Ball>();

        for (int i = 0; i < level.numberOfBalls(); i++) {
            balls.add(new Ball(400 + i * 6, height - 36, 5, Color.WHITE, environment));
        }

        for (int i = 0; i < level.numberOfBalls(); i++) {
            Velocity v = level.initialBallVelocities().get(i);
            balls.get(i).setVelocity(v);
            balls.get(i).addToGame(this);
        }

        ballsCounter.increase(level.numberOfBalls());
    }

    /**
     * draw one frame.
     *
     * @param d a drawsurface.
     */
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

        //cheats
        if (gui.getKeyboardSensor().isPressed("z")) {
            blocksCounter = new Counter(0);
        }
        if (gui.getKeyboardSensor().isPressed("a")) {
            ballsCounter = new Counter(0);
        }
    }

    /**
     * returns whether turn should stop.
     *
     * @return whether turn should stop.
     */
    public boolean shouldStop() {
        return !this.running;
    }
}
