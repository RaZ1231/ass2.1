package indicators;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.LevelInformation;
import interfaces.Sprite;

/**
 * level indicator class.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class LevelIndicator implements Sprite {
    private LevelInformation level;

    /**
     * constructor.
     *
     * @param level current level.
     */
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

    /**
     * returns level's name.
     *
     * @return level's name.
     */
    @Override
    public String toString() {
        return "Level Name: " + level.levelName();
    }
}
