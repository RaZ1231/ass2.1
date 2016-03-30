package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import collisions.GameEnvironment;
import graphics.SpriteCollection;
import interfaces.Collidable;
import interfaces.Sprite;
import shapes.Ball;

/**
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class Game {
    private SpriteCollection sprites;
    private GameEnvironment environment;

    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.
    public void initialize() {
        Ball ball = new Ball(...)
        ball.addToGame(this);
        for (...){
            Block block = new Block(...)
            block.addToGame(this);
        }
    }

    // Run the game -- start the animation loop.
    public void run() {
        GUI gui = new GUI("Arkanoid", 200, 200);
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
