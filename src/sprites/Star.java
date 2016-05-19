package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.awt.Polygon;
import shapes.Point;

/**
 * drawable star.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Star extends BaseSprite {
    private Point center;
    private double externalRadius;
    private double internalRadius;
    private double[] angles;

    /**
     * constructor.
     *
     * @param color          a color.
     * @param center         star's center.
     * @param externalRadius largest
     * @param internalRadius smallest.
     */
    public Star(Color color, Point center, double externalRadius, double internalRadius) {
        super(color);
        this.center = center;
        this.externalRadius = externalRadius;
        this.internalRadius = internalRadius;
        this.angles = new double[5];
        for (int i = 0; i < 5; i++) {
            angles[i] = (Math.PI * 2 / 5) * i + Math.PI / 2; // first angle facing up
        }
    }

    /**
     * draw itself.
     *
     * @param d     a draw surface.
     * @param color a color.
     */
    @Override
    public void drawSelf(DrawSurface d, Color color) {
        Polygon polygon = new Polygon();

        for (int i = 0; i < 5; i++) {
            double dx = Math.cos(angles[i]) * externalRadius;
            double dy = Math.sin(angles[i]) * externalRadius;

            polygon.addPoint((int) (center.getX() + dx), (int) (center.getY() + dy));

            dx = Math.cos(angles[i] + Math.PI / 5) * internalRadius;
            dy = Math.sin(angles[i] + Math.PI / 5) * internalRadius;

            polygon.addPoint((int) (center.getX() + dx), (int) (center.getY() + dy));
        }

        d.setColor(color);
        d.fillPolygon(polygon);
    }
}
