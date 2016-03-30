package graphics;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 30-Mar-16.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    public SpriteCollection() {
        sprites = new LinkedList<Sprite>();
    }

    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    // call timePassed() on all sprites.
    public void notifyAllTimePassed() {
        for (Sprite s : sprites) {
            s.timePassed();
        }
    }

    // call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
