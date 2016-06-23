package animations;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import blocks.BaseBlock;
import collisions.GameEnvironment;
import graphics.AnimationRunner;
import graphics.SpriteCollection;
import indicators.LevelIndicator;
import indicators.LivesIndicator;
import indicators.RectIndicator;
import indicators.ScoreIndicator;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import listeners.BlockRemover;
import listeners.InvaderRemover;
import listeners.LifeRemover;
import listeners.ScoreTrackingListener;
import motion.Acceleration;
import motion.Velocity;
import shapes.Rectangle;
import spaceinvaders.Formation;
import spaceinvaders.ShieldBlock;
import spaceinvaders.Shot;
import spaceinvaders.SpaceShip;
import sprites.FillImage;
import utils.Counter;

/**
 * a game level class.
 *
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class GameLevel implements Animation {
    private static int levelNum = 0;
    private int width;
    private int height;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter invadersCounter;
    private Counter ballsCounter;
    private Counter score;
    private Counter lives;
    private SpaceShip spaceShip;
    private Formation formation;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation level;
    private List<Shot> shots;

    /**
     * constructor.
     *
     * @param gLevel a level.
     * @param runner an animation runner.
     * @param gui    a gui.
     * @param lives  lives counter.
     * @param score  scores counter.
     */
    public GameLevel(LevelInformation gLevel, AnimationRunner runner, GUI gui, Counter lives, Counter score) {
        level = gLevel;
        this.score = score;
        this.lives = lives;
        this.runner = runner;
        this.gui = gui;
        this.shots = new LinkedList<>();
    }

    /**
     * returns game environment.
     *
     * @return game environment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * returns level's number of invaders.
     *
     * @return level's number of invaders.
     */
    public Counter getInvadersCounter() {
        return invadersCounter;
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
     * add shot to shots' list.
     *
     * @param s a shot.
     */
    public void addShot(Shot s) {
        shots.add(s);
    }

    /**
     * Initialize a new level: create the Blocks, Ball and Paddle
     * and add them to the Game.
     * Also draws the level's background.
     */
    public void initialize() {
        levelNum++;
        width = gui.getDrawSurface().getWidth();
        height = gui.getDrawSurface().getHeight();

        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        spaceShip = new SpaceShip(new Rectangle(width / 2 - 50, height - 35,
                level.paddleWidth(), 20), gui.getKeyboardSensor(), 15, width - 15,
                300, new FillImage("spaceship.jpg"));
        formation = new Formation(level.invaders(),
                new Acceleration(new Velocity(levelNum * 50 + 20, 0)), 800, 600);
        invadersCounter = new Counter(formation.getInvaders().size());
        ballsCounter = new Counter(0);

        RectIndicator rectIndicator = new RectIndicator();
        LivesIndicator livesIndicator = new LivesIndicator(lives);
        ScoreIndicator scoreIndicator = new ScoreIndicator(score);
        LevelIndicator levelIndicator = new LevelIndicator(level.levelName() + levelNum);

        InvaderRemover invaderRemover = new InvaderRemover(this, invadersCounter);
        BlockRemover blockRemover = new BlockRemover(this);
        LifeRemover lifeRemover = new LifeRemover(this, lives);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this, score);

        formation.addHitListener(invaderRemover);
        formation.addHitListener(scoreTrackingListener);
        spaceShip.addHitListener(lifeRemover);

        level.getBackground().addToGame(this);
        spaceShip.addToGame(this);
        rectIndicator.addToGame(this);
        scoreIndicator.addToGame(this);
        livesIndicator.addToGame(this);
        levelIndicator.addToGame(this);
        formation.addToGame(this);

        for (ShieldBlock s : level.shields()) {
            s.addToGame(this);
            s.addHitListener(blockRemover);
        }

        for (BaseBlock b : level.getDeathRegion()) {
            b.addToGame(this);
            b.addHitListener(blockRemover);
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
        spaceShip.center(width);
        formation.reset();
        removeShots();
    }

    /**
     * erase all shots from game when initialized.
     */
    private void removeShots() {
        Iterator<Shot> iter = shots.iterator();

        while (iter.hasNext()) {
            Shot s = iter.next();
            s.removeFromGame(this);
            iter.remove();
        }
    }

    /**
     * draw one frame.
     *
     * @param d  a drawsurface.
     * @param dt seconds passed.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed(dt);
        this.formation.timePassed(dt);

        if (invadersCounter.getValue() == 0) {
            running = false;
        }
        if (formation.size() > 0 && formation.getLowest().getY() >= 450) {
            lives.decrease(1);
            running = false;
        }
        if (lives.getValue() == 0) {
            initLevelNumber();
        }

        if (gui.getKeyboardSensor().isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(
                    gui.getKeyboardSensor(), KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }

        //cheats
        if (gui.getKeyboardSensor().isPressed("z")) { // next level.
            invadersCounter = new Counter(0);
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

    /**
     * initialize level number.
     */
    public void initLevelNumber() {
        levelNum = 0;
    }

    /**
     * stop running.
     */
    public void stop() {
        running = false;
    }
}
