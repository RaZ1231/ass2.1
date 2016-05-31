package graphics;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.LinkedList;
import java.util.List;

/**
 * sprite collection class.
 *
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * constructor.
     */
    public SpriteCollection() {
        sprites = new LinkedList<Sprite>();
    }

    /**
     * add sprite.
     *
     * @param s a sprite.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * remove sprite.
     *
     * @param s a sprite.
     */
    public void removeSprite(Sprite s) {
        List<Sprite> tempSprites = new LinkedList<>(sprites);
        tempSprites.remove(s);
        sprites = tempSprites;
    }

    /**
     * call timePassed() on all sprites.
     *
     * @param dt seconds passed.
     */
    public void notifyAllTimePassed(double dt) {
        for (Sprite s : sprites) {
            s.timePassed(dt);
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d draw surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
