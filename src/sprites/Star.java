package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.awt.Polygon;
import java.util.List;

/**
 * drawable star.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public class Star extends BaseSprite {
    private double externalRadius;
    private double internalRadius;
    private double[] angles;

    /**
     * constructor.
     *
     * @param color          a color.
     * @param externalRadius largest
     * @param internalRadius smallest.
     */
    public Star(Color color, double externalRadius, double internalRadius) {
        super(color);
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
     * @param x     sprite's x positions.
     * @param y     sprite's y positions.
     * @param color a color.
     */
    @Override
    public void drawSelf(DrawSurface d, List<Integer> x, List<Integer> y, Color color) {
        Polygon polygon = new Polygon();

        for (int i = 0; i < 5; i++) {
            double dx = Math.cos(angles[i]) * externalRadius;
            double dy = Math.sin(angles[i]) * externalRadius;

            polygon.addPoint((int) (x.get(0) + dx), (int) (y.get(0) + dy));

            dx = Math.cos(angles[i] + Math.PI / 5) * internalRadius;
            dy = Math.sin(angles[i] + Math.PI / 5) * internalRadius;

            polygon.addPoint((int) (x.get(0) + dx), (int) (y.get(0) + dy));
        }

        d.setColor(color);
        d.fillPolygon(polygon);
    }
}
