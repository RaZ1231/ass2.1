package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import shapes.Point;

/**
 * drawable circle.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Circle extends BaseSprite {
    private Point center;
    private int radius;

    /**
     * constructor
     *
     * @param color  a color.
     * @param center circle's center.
     * @param radius circle's radius.
     */
    public Circle(Color color, Point center, int radius) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    /**
     * draw itself.
     *
     * @param d     a draw surface.
     * @param color a color.
     */
    @Override
    public void drawSelf(DrawSurface d, Color color) {
        d.setColor(color);
        d.fillCircle((int) center.getX(), (int) center.getY(), radius);
    }
}
