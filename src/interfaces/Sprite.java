package interfaces;

import biuoop.DrawSurface;
import game.Game;

/**
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
     * add object to game.
     *
     * @param game a game to add the object to.
     */
    void addToGame(Game game);
}
