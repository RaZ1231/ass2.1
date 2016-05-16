package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;

/**
 * drawable square.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Square extends BaseSprite {
    private int width;
    private int height;

    /**
     * constructor.
     *
     * @param width  square's width.
     * @param height square's height.
     * @param color  square's color.
     */
    public Square(int width, int height, Color color) {
        super(color);
        this.width = width;
        this.height = height;
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
        d.fillRectangle(x.get(0), y.get(0), width, height);
    }

}
