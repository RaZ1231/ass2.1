package motion;

import shapes.Point;
import utils.Mathematics;

/**
 * @author Raziel Solomon
 * @since 16-Mar-16.
 */

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor.
     *
     * @param dx delta x
     * @param dy delta y
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Turns angle and speed to new velocity.
     *
     * @param angle angle by degrees
     * @param speed velocity speed
     * @return new velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.round(speed * Math.sin(Math.toRadians(angle)));
        double dy = Math.round(speed * Math.cos(Math.toRadians(angle)) * (-1));

        return new Velocity(dx, dy);
    }

    /**
     * Turn too low speed to minimum.
     *
     * @param num speed
     * @return minimum speed
     */
    public static int minimumSpeed(int num) {
        if (num <= 0) {
            return 1;
        }
        return num;
    }

    /**
     * returns dx.
     *
     * @return dx
     */
    public double getDx() {
        return dx;
    }

    /**
     * returns dy.
     *
     * @return dy
     */
    public double getDy() {
        return dy;
    }

    public double getSpeed() {
        return Mathematics.pythagoras(dx, dy);
    }

    public double getAngle() {
        return Math.toDegrees(Math.asin(dx / getSpeed()));
    }

    /**
     * Take a start with position (x,y) and return a new start with position (x+dx, y+dy).
     *
     * @param p origin point
     * @return change point
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }


}
