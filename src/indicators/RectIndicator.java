package indicators;

import biuoop.DrawSurface;
import game.Game;
import interfaces.Sprite;

import java.awt.Color;

/**
 * Rectangle sprite that contains the indicators
 *
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class RectIndicator implements Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 25);
        d.setColor(Color.red);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * add object to game.
     *
     * @param game a game to add the object to.
     */
    @Override
    public void addToGame(Game game) {
        game.addSprite(this);
    }
}
