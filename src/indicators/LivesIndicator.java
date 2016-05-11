package indicators;

import biuoop.DrawSurface;
import game.Game;
import interfaces.Sprite;
import utils.Counter;

/**
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class LivesIndicator implements Sprite {
    private Counter lives;

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

    @Override
    public String toString() {
        return "Lives: " + lives.getValue();
    }
}