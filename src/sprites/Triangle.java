package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.awt.Polygon;
import java.util.List;

/**
 * drawable triangle.
 *
 * @author Elisheva Broyer.
 * @since 16/05/2016.
 */
public class Triangle extends BaseSprite {
    private double externalRadius;
    private double internalRadius;
    private double[] angles;

    /**
     * constructor.
     *
     * @param color a color.
     */
    public Triangle(Color color, double externalRadius, double internalRadius) {
        super(color);
        this.externalRadius = externalRadius;
        this.internalRadius = internalRadius;
        this.angles = new double[3];
        for (int i = 0; i < 3; i++) {
            angles[i] = (Math.PI * 2 / 3) * i + Math.PI / 2; // first angle facing up
        }
    }

    @Override
    public void drawSelf(DrawSurface d, List<Integer> x, List<Integer> y, Color color) {
        Polygon polygon = new Polygon();

        for (int i = 0; i < 3; i++) {
            double dx = Math.cos(angles[i]) * externalRadius;
            double dy = Math.sin(angles[i]) * externalRadius;

            polygon.addPoint((int) (x.get(0) + dx), (int) (y.get(0) + dy));
        }

        d.setColor(color);
        d.fillPolygon(polygon);
    }
}
