package sprites;

import biuoop.DrawSurface;
import shapes.Point;

import java.awt.Color;

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
     * draw the sprite to the screen.
     *
     * @param d a draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.drawText((int) upperLeft.getX(), (int) upperLeft.getY(), text, size);
    }
}
