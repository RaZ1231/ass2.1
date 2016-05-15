package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;

/**
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Square extends BaseSprite {
    private int sX;
    private int sY;
    private int width;
    private int height;

    public Square(int x, int y, int width, int height, Color color) {
        super(color);
        this.sX = x;
        this.sY = y;
        this.width = width;
        this.height = height;
    }

    public void drawSelf(DrawSurface d, List<Integer> x, List<Integer> y, Color color) {
        d.setColor(color);
        d.fillRectangle(sX, sY, width, height);
    }

}
