package collections;

import biuoop.DrawSurface;
import shapes.Line;

import java.awt.*;
import java.util.Random;

/**
 * @author Raziel Solomon
 * @since 18-Mar-16.
 */

/**
 * Manages array of lines.
 */
public class ArrayOfLines {
    private Line[] lines;

    /**
     * constructor.
     *
     * @param size number of lines
     */
    public ArrayOfLines(int size) {
        this.lines = new Line[size];
    }

    /**
     * Draws lines on surface.
     *
     * @param d     draw surface
     * @param color color of lines
     */
    public void drawOn(DrawSurface d, Color color) {
        d.setColor(color);
        for (Line line : lines) {
            line.drawOn(d);
        }
    }

    /**
     * Draws lines' middle points on surface.
     *
     * @param d     draw surface
     * @param size  size of points
     * @param color color of points
     */
    public void drawMidPoints(DrawSurface d, int size, Color color) {
        d.setColor(color);
        for (Line line : this.lines) {
            line.drawMidPoint(d, size);
        }
    }

    /**
     * Draws lines' intersection points on surface.
     *
     * @param d     draw surface
     * @param size  size of points
     * @param color color of points
     */
    public void drawInterPoints(DrawSurface d, int size, Color color) {
        d.setColor(color);
        for (int i = 0; i < this.lines.length; i++) {
            for (int j = i + 1; j < this.lines.length; j++) {
                if (this.lines[i].isIntersecting(this.lines[j])) {
                    lines[i].intersectionWith(lines[j]).drawOn(d, size);
                }
            }
        }
    }


    /**
     * Fills array with random lines.
     *
     * @param width  width of frame
     * @param height height of frame
     */
    public void generateRandomLines(int width, int height) {
        for (int i = 0; i < this.lines.length; i++) {
            this.lines[i] = generateRandomLine(width, height);
        }
    }

    /**
     * Generate a random line.
     *
     * @param width  width of frame
     * @param height height of frame
     * @return random line
     */
    public Line generateRandomLine(int width, int height) {
        Random rand = new Random();
        return new Line((double) rand.nextInt(width) + 1, (double) rand.nextInt(height) + 1,
                (double) rand.nextInt(width) + 1, (double) rand.nextInt(height) + 1);
    }
}
