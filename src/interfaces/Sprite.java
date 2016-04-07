package interfaces;

import biuoop.DrawSurface;
import game.Game;

/**
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public interface Sprite {
    // draw the sprite to the screen.
    void drawOn(DrawSurface d);

    // notify the sprite that time has passed.
    void timePassed();

    // add object to game.
    void addToGame(Game game);
}
