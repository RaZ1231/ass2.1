package indicators;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;
import utils.Counter;

/**
 * @author Elisheva Broyer.
 * @since 11/05/2016.
 */
public class ScoreIndicator implements Sprite {
    private Counter scores;

    public ScoreIndicator(Counter scores) {
        this.scores = scores;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(370, 15, toString(), 18);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

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

    @Override
    public String toString() {
        return "Score: " + scores.getValue();
    }
}
