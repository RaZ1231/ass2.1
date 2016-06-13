package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import shapes.Point;

/**
 * @author Elisheva Broyer.
 * @since 07/06/2016.
 */
public class CopyRightsS extends BaseSprite {
    private Point pos;
    private int radius;

    /**
     * constructor.
     *
     * @param color  a color
     * @param pos    position on screen.
     * @param radius circle's radius.
     */
    public CopyRightsS(Color color, Point pos, int radius) {
        super(color);
        this.pos = pos;
        this.radius = radius;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.getColor());
        d.drawCircle((int) pos.getX() + radius / 4, (int) pos.getY() - radius / 4, radius / 2);
        d.drawText((int) pos.getX(), (int) pos.getY(), "c", radius);
    }
}
