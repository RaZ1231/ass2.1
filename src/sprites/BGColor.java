package sprites;

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Elisheva Broyer.
 * @since 09/06/2016.
 */
public class BGColor extends BaseSprite {
    public BGColor(Color color) {
        super(color);
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
    }
}
