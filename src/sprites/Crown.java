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
     * @param color a color.
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
     * draw itself.
     *
     * @param d     a draw surface.
     * @param color a color.
     */
    @Override
    public void drawSelf(DrawSurface d, Color color) {
        Background b = new Background();
        int points = 5;

        //body
        b.addElement(new Square(corner, width, height, color));

        //triangles
        for (int i = (int) corner.getX() + width / (2 * points); i <= width + corner.getX(); i += width / points) {
            b.addElement(new Triangle(back, new Point(i, corner.getY()), width / points));
        }

        //top circles
        for (int i = (int) corner.getX(); i <= width + corner.getX(); i += width / points) {
            b.addElement(new Circle(color, new Point(i, corner.getY() + 5), width / (10 * points)));
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
