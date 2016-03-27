package shapes;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Raziel Solomon
 * @since 18-Mar-16.
 */

/**
 * Rectangle representation.
 */
public class Rectangle {
    private Point start;
    private double width;
    private double height;
    private Color color;

    /**
     * constructor.
     *
     * @param start starting point
     * @param end   ending point
     * @param color color of rectangle
     */
    public Rectangle(Point start, Point end, Color color) {
        double x = Math.min(start.getX(), end.getX());
        double y = Math.min(start.getY(), end.getY());

        this.start = new Point(x, y);
        this.width = Math.abs(end.getX() - start.getX());
        this.height = Math.abs(end.getY() - start.getY());
        this.color = color;
    }

    /**
     * Returns start point.
     *
     * @return start point
     */
    public Point getStart() {
        return start;
    }

    /**
     * Returns end point.
     *
     * @return end point
     */
    public Point getEnd() {
        return new Point(getStart().getX() + getWidth(), getStart().getY() + getHeight());
    }

    /**
     * Return width.
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns height.
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns color.
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Draws on surface.
     *
     * @param d draw surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.fillRectangle((int) getStart().getX(), (int) getStart().getY(), (int) getWidth(), (int) getHeight());
    }
}
