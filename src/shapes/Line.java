package shapes;

import biuoop.DrawSurface;

import java.util.List;

import static utils.Mathematics.average;
import static utils.Mathematics.isBetween;

/**
 * @author Raziel Solomon
 * @since 14-Mar-16.
 */

/**
 * Line class.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor.
     *
     * @param start Starting point
     * @param end   Ending point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor.
     *
     * @param x1 x of start
     * @param y1 y of start
     * @param x2 x of end
     * @param y2 y of end
     */
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * return the length of the line.
     *
     * @return length of the line
     */
    public double length() {
        return Math.abs(this.start().distance(this.end()));
    }

    /**
     * returns the middle start of the line.
     *
     * @return the start of the line
     */
    public Point middle() {
        double x = average(start().getX(), end().getX());
        double y = average(start().getY(), end().getY());
        return new Point(x, y);
    }

    /**
     * returns the start of the line.
     *
     * @return start of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * returns the end of the line.
     *
     * @return end of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * sets start of line.
     *
     * @param newStart new start
     */
    public void setStart(Point newStart) {
        this.start = newStart;
    }

    /**
     * sets end of line.
     *
     * @param newEnd new end
     */
    public void setEnd(Point newEnd) {
        this.end = newEnd;
    }

    /**
     * returns true if the lines intersect, false otherwise.
     *
     * @param other other line
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        return (intersectionWith(other) != null);
    }

    /**
     * returns the intersection start if the lines intersect,
     * and null otherwise.
     *
     * @param other second line.
     * @return point of intersection.
     */
    public Point intersectionWith(Line other) {
        Double m = calcSlope();
        Double mOther = other.calcSlope();

        if (m == mOther) {
            return null; //parallel
        }

        Point intersection;

        if (mOther == null) {
            intersection = this.getVertInterPoint(other); //other line is vertical
        } else if (m == null) {
            intersection = other.getVertInterPoint(this); //line is vertical
        } else {
            intersection = this.getInterPoint(other);
        }

        if (this.isInline(intersection) && other.isInline(intersection)) { //inline check
            return intersection;
        } else {
            return null;
        }
    }

    /**
     * checks if point is inline.
     *
     * @param p a point.
     * @return true if point in line. false otherwise.
     */
    public boolean isInline(Point p) {
        return isBetween(start().getX(), p.getX(), end().getX())
                && isBetween(start().getY(), p.getY(), end().getY());
    }

    /**
     * returns the point of intersection.
     *
     * @param other second line.
     * @return the point of intersection.
     */
    public Point getInterPoint(Line other) {
        Double m = calcSlope();
        Double mOther = other.calcSlope();
        Double n = calcYAxis();
        Double nOther = other.calcYAxis();

        double x = ((nOther - n) / (m - mOther));
        double y = m * x + n;

        return new Point(Math.round(x), Math.round(y));
    }

    /**
     * returns the point of intersection with vertical line.
     *
     * @param vert vertical line
     * @return the point of intersection with vertical line.
     */
    public Point getVertInterPoint(Line vert) {
        return new Point(Math.round(vert.start().getX()), Math.round(calcSlope() * vert.start().getX() + calcYAxis()));
    }

    /**
     * calculates y-axis intersect.
     *
     * @return point of intersection
     */
    public Double calcYAxis() {
        double x = start().getX();
        double y = start().getY();
        Double m = calcSlope();

        if (m == null) {
            if (x != 0) {
                return null; //line is vertical
            } else {
                return 0.0;
            }
        }

        return y - m * x;
    }

    /**
     * calculates slope.
     *
     * @return line's slope
     */
    public Double calcSlope() {
        double x1 = start().getX();
        double x2 = end().getX();
        double y1 = start().getY();
        double y2 = end().getY();

        if (x1 == x2) {
            return null; //vertical line
        }
        return (y2 - y1) / (x2 - x1);
    }

    /**
     * draws on surface.
     *
     * @param d draw the line in surface.
     */
    public void drawOn(DrawSurface d) {
        d.drawLine((int) start().getX(), (int) start().getY(),
                (int) end().getX(), (int) end().getY());
    }

    /**
     * draws mid point.
     *
     * @param d    draw surface
     * @param size radios
     */
    public void drawMidPoint(DrawSurface d, int size) {
        this.middle().drawOn(d, size);
    }

    /**
     * returns true if the lines are equal, false otherwise.
     *
     * @param other second line
     * @return true if the lines are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() == getClass()) {
            Line line = (Line) other;
            return ((start().equals(line.start()) && (end().equals((line.end()))))
                    || (start().equals(line.end()) && (end().equals((line.start())))));
        }
        return false;
    }

    /**
     * String representation of line.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return String.format("Line{y=%sx+%s, start=%s, end=%s}", calcSlope(), calcYAxis(), start, end);
    }

    /**
     * If line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect a rectangle.
     * @return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> pointsList = rect.intersectionPoints(this);
        if (pointsList.isEmpty()) {
            return null;
        }

        Point closestPoint = this.end();
        for (Point p : pointsList) {
            if (start().distance(p) <= start().distance(closestPoint)) {
                closestPoint = p;
            }
        }

        return closestPoint;
    }
}