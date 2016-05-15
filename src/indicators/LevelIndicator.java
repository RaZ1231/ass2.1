package indicators;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.LevelInformation;
import interfaces.Sprite;

/**
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class LevelIndicator implements Sprite {
    private LevelInformation level;

    public LevelIndicator(LevelInformation level) {
        this.level = level;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(500, 15, toString(), 18);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
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

    @Override
    public String toString() {
        return "Level Name: " + level.levelName();
    }
}
