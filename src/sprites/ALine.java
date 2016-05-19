package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import shapes.Point;

/**
 * drawable line.
 *
 * @author Elisheva Broyer.
 * @since 16/05/2016.
 */
public class ALine extends BaseSprite {
    private Point p1;
    private Point p2;
    private int thick;


    /**
     * constructor.
     *
     * @param color a color.
     * @param p1    a point.
     * @param p2    another point.
     * @param thick lines thickness.
     */
    public ALine(Color color, Point p1, Point p2, int thick) {
        super(color);
        this.p1 = p1;
        this.p2 = p2;
        this.thick = thick;
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
        for (int i = 0; i < thick / 2; i++) {
            d.drawLine((int) p1.getX() + i, (int) p1.getY() + i,
                    (int) p2.getX() + i, (int) p2.getY() + i);
            d.drawLine((int) p1.getX() - i, (int) p1.getY() - i,
                    (int) p2.getX() - i, (int) p2.getY() - i);
        }
    }
}
