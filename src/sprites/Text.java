package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;

/**
 * drawable text.
 *
 * @author Elisheva Broyer.
 * @since 16/05/2016.
 */
public class Text extends BaseSprite {
    private String text;
    private int size;

    /**
     * constructor.
     *
     * @param color a color.
     * @param text  text to draw.
     * @param size  text's size.
     */
    public Text(Color color, String text, int size) {
        super(color);
        this.text = text;
        this.size = size;
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
        d.drawText(x.get(0), y.get(0), text, size);
    }
}
