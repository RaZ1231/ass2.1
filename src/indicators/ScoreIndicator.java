package indicators;

import biuoop.DrawSurface;
import game.Game;
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
        return "Score: " + scores.getValue();
    }
}
