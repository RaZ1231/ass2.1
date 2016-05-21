package sprites;

import biuoop.DrawSurface;
import shapes.Point;

import java.awt.Color;
import java.awt.Polygon;

/**
 * drawable triangle.
 *
 * @author Elisheva Broyer.
 * @since 16/05/2016.
 */
public class Triangle extends BaseSprite {
    private Point center;
    private double externalRadius;
    private double[] angles;


    /**
     * constructor.
     *
     * @param color          a color.
     * @param center         triangle's center.
     * @param externalRadius triangle's external radius.
     */
    public Triangle(Color color, Point center, double externalRadius) {
        super(color);
        this.center = center;
        this.externalRadius = externalRadius;
        this.angles = new double[3];
        for (int i = 0; i < 3; i++) {
            angles[i] = (Math.PI * 2 / 3) * i + Math.PI / 2; // first angle facing up
        }
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d a draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        Polygon polygon = new Polygon();

        for (int i = 0; i < 3; i++) {
            double dx = Math.cos(angles[i]) * externalRadius;
            double dy = Math.sin(angles[i]) * externalRadius;

            polygon.addPoint((int) (center.getX() + dx), (int) (center.getY() + dy));
        }

        d.setColor(getColor());
        d.fillPolygon(polygon);
    }
}
