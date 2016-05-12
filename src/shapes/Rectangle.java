package shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class.
 *
 * @author Raziel Solomon
 * @since 18-Mar-16.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor.
     *
     * @param x      upper left x-axis value.
     * @param y      upper left y-axis value.
     * @param width  rectangle's width.
     * @param height rectangle's height.
     */
    public Rectangle(double x, double y, double width, double height) {
        this(new Point(x, y), width, height);
    }

    /**
     * constructor.
     *
     * @param upperLeft starting point
     * @param width     ending point
     * @param height    color of rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line a line.
     * @return a list of intersection points with the specified line.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new ArrayList<Point>();
        Line[] rectLines = this.fourLines();

        for (Line l : rectLines) {
            if (line.isIntersecting(l)) {
                intersections.add(line.intersectionWith(l));
            }
        }

        return intersections;
    }

    /**
     * return rectangle's lines in array.
     *
     * @return a lines array.
     */
    public Line[] fourLines() {
        Line[] lines = new Line[4];
        lines[0] = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.getUpperRight().getX(), this.getUpperRight().getY());
        lines[1] = new Line(this.getLowerLeft().getX(), this.getLowerLeft().getY(),
                this.getLowerRight().getX(), this.getLowerRight().getY());
        lines[2] = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.getLowerLeft().getX(), this.getLowerLeft().getY());
        lines[3] = new Line(this.getUpperRight().getX(), this.getUpperRight().getY(),
                this.getLowerRight().getX(), this.getLowerRight().getY());
        return lines;
    }

    /**
     * returns the upper right corner.
     *
     * @return the upper right corner.
     */
    public Point getUpperRight() {
        return new Point(this.getUpperLeft().getX() + this.getWidth(),
                this.getUpperLeft().getY());
    }

    /**
     * returns the lower left corner.
     *
     * @return the lower left corner.
     */
    public Point getLowerLeft() {
        return new Point(this.getUpperLeft().getX(),
                this.getUpperLeft().getY() + this.getHeight());
    }

    /**
     * returns the lower right corner.
     *
     * @return the lower right corner.
     */
    public Point getLowerRight() {
        return new Point(this.getUpperLeft().getX() + this.getWidth(),
                this.getUpperLeft().getY() + this.getHeight());
    }

    /**
     * returns start point.
     *
     * @return start point
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * set the rectangle's upper left corner.
     *
     * @param upLeft rectangle's upper left corner.
     */
    public void setUpperLeft(Point upLeft) {
        this.upperLeft = upLeft;
    }

    /**
     * returns rectangle's width.
     *
     * @return rectangle's width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * returns rectangle's height.
     *
     * @return rectangle's height.
     */
    public double getHeight() {
        return height;
    }
}

