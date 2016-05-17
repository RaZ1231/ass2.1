package sprites;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Background implements Sprite {
    private List<Sprite> sprites;

    public Background() {
        this.sprites = new LinkedList<>();
    }

    public void addElement(Sprite s) {
        sprites.add(s);
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        // do nothing.
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
}
