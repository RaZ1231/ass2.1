package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;
import shapes.Point;

/**
 * drawable line.
 *
 * @author Elisheva Broyer.
 * @since 16/05/2016.
 */
public class ALine extends BaseSprite {
    private Point start;
    private Point end;
    private int thick;

    /**
     * constructor.
     *
     * @param color a color.
     * @param thick line's thickness.
     */
    public ALine(Color color, int thick) {
        super(color);
        this.thick = thick;
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
        for (int i = 0; i < thick / 2; i++) {
            d.drawLine(x.get(0) + i, y.get(0) + i, x.get(1) + i, y.get(1) + i);
            d.drawLine(x.get(0) - i, y.get(0) - i, x.get(1) - i, y.get(1) - i);
        }

    }
}
