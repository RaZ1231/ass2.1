package motion;

import shapes.Point;
import utils.Mathematics;

/**
 * Velocity specifies the change in position on the `x` and the `y` axis.
 *
 * @author Raziel Solomon
 * @since 16-Mar-16.
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
        angle = angle % 360;

        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = speed * Math.cos(Math.toRadians(angle)) * (-1);

        return new Velocity(dx, dy);
    }

    /**
     * Take a start with position (x,y) and return a new start
     * with position (x+dx, y+dy).
     *
     * @param p origin point
     * @return change point
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + getDx(), p.getY() + getDy());
    }

    /**
     * returns velocity's dx.
     *
     * @return velocity's dx.
     */
    public double getDx() {
        return Math.round(dx);
    }

    /**
     * returns velocity's dy.
     *
     * @return velocity's dy.
     */
    public double getDy() {
        return Math.round(dy);
    }

    @Override
    public String toString() {
        return "V{" + dx + ", " + dy + "},S[" + getAngle() + ", " + getSpeed() + ']';
    }

    /**
     * returns the hit's angle. test's used.
     *
     * @return the hit's angle. test's used.
     */
    public double getAngle() {
        return Math.toDegrees(Math.atan2(dy, dx)) + 90;
    }

    /**
     * returns pythagoras value of velocity's dx and dy.
     *
     * @return pythagoras value of velocity's dx and dy.
     */
    public double getSpeed() {
        return Mathematics.pythagoras(dx, dy);
    }
}
