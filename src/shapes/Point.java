package shapes;

import biuoop.DrawSurface;


/**
 * point class.
 *
 * @author Raziel Solomon
 * @since 14-Mar-16.
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * returns the distance of this start to the other start.
     *
     * @param other other point.
     * @return the distance of this start to the other start.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(other.getX() - getX(), 2)
                + Math.pow(other.getY() - getY(), 2));
    }

    /**
     * returns x coordinate.
     *
     * @return x coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * Sets x coordinate.
     *
     * @param newX new x
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * returns y coordinate.
     *
     * @return y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * sets y coordinate.
     *
     * @param newY new y
     */
    public void setY(double newY) {
        this.y = newY;
    }

    /**
     * draw point on drawSurface.
     *
     * @param d    draw surface to draw on.
     * @param size radius.
     */
    public void drawOn(DrawSurface d, int size) {
        d.fillCircle((int) getX(), (int) getY(), size);
    }

    /**
     * returns true if the points are equal, false otherwise.
     *
     * @param other object to compare.
     * @return true if the points are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() == getClass()) {
            Point p = (Point) other;
            return ((getX() == p.getX()) && (getY() == p.getY()));
        }
        return false;
    }

    /**
     * return string representation.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ')';
    }

    /**
     * returns the rounded values of a point.
     *
     * @return the rounded values of a point.
     */
    public Point round() {
        return new Point(Math.round(getX()), Math.round(getY()));
    }
}

