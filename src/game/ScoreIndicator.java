package game;

import biuoop.DrawSurface;
import interfaces.Sprite;
import java.awt.Color;
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
        String s = "Score: " + scores.getValue();
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 25);
        d.setColor(Color.red);
        d.drawText(370, 15, s, 18);
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
