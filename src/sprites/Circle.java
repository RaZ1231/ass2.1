package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;

/**
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Circle extends BaseSprite {
    private int radius;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    /**
     * draw itself.
     *
     * @param d     a draw surface.
     * @param x     sprite's x positions.
     * @param y     sprite's y positions.
     * @param color a color.
     */
    @Override
    public void drawSelf(DrawSurface d, List<Integer> x, List<Integer> y, Color color) {
        d.setColor(color);
        d.fillCircle(x.get(0), y.get(0), radius);
    }
}
