package sprites;

import biuoop.DrawSurface;
import shapes.Point;

import java.awt.Color;

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
     * constructor.
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
     * draw the sprite to the screen.
     *
     * @param d a draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.fillCircle((int) center.getX(), (int) center.getY(), radius);
    }
}
