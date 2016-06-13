package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import shapes.Point;

/**
 * @author Raziel Solomon
 * @since 03-Jun-16.
 */
public class MenuItem extends BaseSprite {
    private Point corner;
    private Color back;
    private int width;
    private int height;
    private Color textColor;
    private String text;

    /**
     * constructor.
     *
     * @param corner    a point.
     * @param color     a color.
     * @param back      a background.
     * @param width     a width.
     * @param height    a height.
     * @param textColor text's color.
     * @param text      menu's item text.
     */
    public MenuItem(Point corner, Color color, Color back, int width, int height, Color textColor, String text) {
        super(color);
        this.corner = corner;
        this.back = back;
        this.width = width;
        this.height = height;
        this.textColor = textColor;
        this.text = text;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d a draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        Square s = new Square(corner, width, height, getColor());
        s.drawOn(d);

        Triangle t = new Triangle(back, new Point(corner.getX() + width - height / 2, corner.getY() + height / 2 - 5),
                height / 2 - 5);
        t.drawOn(d);

        Text te = new Text(textColor, new Point(corner.getX() + 10, corner.getY() + height / 2 + 12), text, 30);
        te.drawOn(d);
    }
}
