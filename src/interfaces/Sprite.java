package interfaces;

import Animations.GameLevel;
import biuoop.DrawSurface;

/**
 * Object that can be drawn to the screen
 *
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * add object to gameLevel.
     *
     * @param gameLevel a gameLevel to add the object to.
     */
    void addToGame(GameLevel gameLevel);
}
