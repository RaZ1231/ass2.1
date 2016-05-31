package indicators;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;
import utils.Counter;

/**
 * lives indicator class.
 *
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class LivesIndicator implements Sprite {
    private Counter lives;

    /**
     * constructor.
     *
     * @param lives current lives counter.
     */
    public LivesIndicator(Counter lives) {
        this.lives = lives;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(120, 15, toString(), 18);
    }

    /**
     * notify the sprite that time has passed.
     * @param dt
     */
    @Override
    public void timePassed(double dt) {
        //do nothing.
    }

    /**
     * add object to gameLevel.
     *
     * @param gameLevel a gameLevel to add the object to.
     */
    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * returns current lives as a string.
     *
     * @return current lives as a string.
     */
    @Override
    public String toString() {
        return "Lives: " + lives.getValue();
    }
}