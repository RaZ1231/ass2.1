package shapes;

import biuoop.DrawSurface;

/**
 * @author Raziel Solomon
 * @since 14-Mar-16.
 */

/**
 * Class represent point.
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
     * Get distance between points.
     *
     * @param other other point
     * @return distance
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(other.getX() - getX(), 2) + Math.pow(other.getY() - getY(), 2));
    }

    /**
     * Draw point on drawSurface.
     *
     * @param d    draw surface to draw on
     * @param size radios
     */
    public void drawOn(DrawSurface d, int size) {
        d.fillCircle((int) getX(), (int) getY(), size);
    }

    /**
     * Determine if two points are the same.
     *
     * @param other object to compare
     * @return true\false
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
     * Return x coordinate.
     *
     * @return x coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * Return y coordinate.
     *
     * @return y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * Return string representation.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ')';
    }

    /**
     * Set x coordinate.
     *
     * @param newX new x
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * Set y coordinate.
     *
     * @param newY new y
     */
    public void setY(double newY) {
        this.y = newY;
    }
}

