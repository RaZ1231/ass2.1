package sprites;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.LinkedList;
import java.util.List;

/**
 * background class.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Background implements Sprite {
    private List<Sprite> sprites;

    /**
     * constructor.
     */
    public Background() {
        this.sprites = new LinkedList<>();
    }

    /**
     * adding element to background.
     *
     * @param s a sprite to add.
     */
    public void addElement(Sprite s) {
        sprites.add(s);
    }

    /**
     * adding list of elements to background.
     *
     * @param s a sprite to add.
     */
    public void addElements(List<Sprite> s) {
        sprites.addAll(s);
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
