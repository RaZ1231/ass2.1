package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.awt.Polygon;
import shapes.Point;

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
     * @param d     a draw surface.
     * @param color a color.
     */
    @Override
    public void drawSelf(DrawSurface d, Color color) {
        Polygon polygon = new Polygon();

        for (int i = 0; i < 3; i++) {
            double dx = Math.cos(angles[i]) * externalRadius;
            double dy = Math.sin(angles[i]) * externalRadius;

            polygon.addPoint((int) (center.getX() + dx), (int) (center.getY() + dy));
        }

        d.setColor(color);
        d.fillPolygon(polygon);
    }
}
