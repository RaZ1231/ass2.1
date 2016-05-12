package Animations;

import biuoop.DrawSurface;
import graphics.SpriteCollection;
import interfaces.Animation;
import utils.Counter;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) secods, before
 * it is replaced with the next one.
 *
 * @author Raziel Solomon
 * @since 12-May-16.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean running;
    private Counter count;
    private Counter framesPassed;

    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.running = true;
        this.count = new Counter(countFrom);
        this.framesPassed = new Counter(0);
    }

    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);

        framesPassed.increase(1);

        if (framesPassed.getValue() % ((numOfSeconds / countFrom) * 60) == 0) {
            count.decrease(1);
        }

        if (count.getValue() == 0) {
            running = false;
        } else {
            d.setColor(Color.BLACK);
            d.drawText(d.getWidth() / 2 - 16, d.getHeight() / 2, "" + count.getValue(), 32);
        }
    }

    public boolean shouldStop() {
        return !this.running;
    }
}
