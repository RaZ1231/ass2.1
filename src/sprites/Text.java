package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import shapes.Point;

/**
 * drawable text.
 *
 * @author Elisheva Broyer.
 * @since 16/05/2016.
 */
public class Text extends BaseSprite {
    private Point upperLeft;
    private String text;
    private int size;

    /**
     * constructor.
     *
     * @param color a color.
     * @param uL    text's position.
     * @param text  text to draw.
     * @param size  text's size.
     */
    public Text(Color color, Point uL, String text, int size) {
        super(color);
        this.upperLeft = uL;
        this.text = text;
        this.size = size;
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
        d.drawText((int) upperLeft.getX(), (int) upperLeft.getY(), text, size);
    }
}
