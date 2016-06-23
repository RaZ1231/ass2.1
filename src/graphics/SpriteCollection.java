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
        for (Sprite s : copy().getSprites()) {
            s.timePassed(dt);
        }
    }

    /**
     * returns a list of all sprites.
     *
     * @return a list of all sprites.
     */
    public List<Sprite> getSprites() {
        return sprites;
    }

    /**
     * returns a copy of the collection.
     *
     * @return a copy of the collection.
     */
    public SpriteCollection copy() {
        SpriteCollection sc = new SpriteCollection();

        for (Sprite s : sprites) {
            sc.addSprite(s);
        }

        return sc;
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
