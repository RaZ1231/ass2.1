package sprites;

import biuoop.DrawSurface;
import shapes.Point;

import java.awt.Color;

/**
 * @author Raziel Solomon
 * @since 19-May-16.
 */
public class Crown extends BaseSprite {
    private Point corner;
    private Color scndColor;
    private Color back;
    private int width;
    private int height;

    /**
     * constructor.
     *
     * @param color     color
     * @param scndColor secondary color
     * @param back      back color
     * @param corner    upper left point
     * @param width     width of crown
     * @param height    height of crown
     */
    public Crown(Color color, Color scndColor, Color back, Point corner, int width, int height) {
        super(color);
        this.corner = corner;
        this.scndColor = scndColor;
        this.back = back;
        this.width = width;
        this.height = height;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d a draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        Background b = new Background();
        int points = 5;

        //body
        b.addElement(new Square(corner, width, height, getColor()));

        //triangles
        for (int i = (int) corner.getX() + width / (2 * points); i <= width + corner.getX(); i += width / points) {
            b.addElement(new Triangle(back, new Point(i, corner.getY()), width / points));
        }

        //top circles
        for (int i = (int) corner.getX(); i <= width + corner.getX(); i += width / points) {
            b.addElement(new Circle(getColor(), new Point(i, corner.getY() + 5), width / (10 * points)));
        }

        //bottom circles
        for (int i = (int) corner.getX(); i <= width + corner.getX(); i += width / (2 * points)) {
            b.addElement(new Circle(scndColor, new Point(i, corner.getY() + 6 * height / 7), width / (10 * points)));
        }

        //sides
        b.addElement(new Square(new Point(corner.getX() - 20, corner.getY() - 20), 20, height + 20, back));
        b.addElement(new Square(new Point(corner.getX() + width, corner.getY() - 20), 20, height + 20, back));

        //draw
        b.drawOn(d);
    }
}
