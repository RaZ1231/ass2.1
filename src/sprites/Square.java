package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import shapes.Point;

/**
 * drawable square.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Square extends BaseSprite {
    private Point upperLeft;
    private int width;
    private int height;

    /**
     * constructor.
     *
     * @param uL     square's upper left point.
     * @param width  square's width.
     * @param height square's height.
     * @param color  square's color.
     */
    public Square(Point uL, int width, int height, Color color) {
        super(color);
        this.upperLeft = uL;
        this.width = width;
        this.height = height;
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
        d.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), width, height);
    }
}
