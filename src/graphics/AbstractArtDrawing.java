package graphics;

import biuoop.DrawSurface;
import biuoop.GUI;
import collections.ArrayOfLines;

import java.awt.*;

/**
 * @author Raziel Solomon
 * @since 16-Mar-16.
 */

/**
 * Class draws random lines on screen.
 */
public class AbstractArtDrawing {
    private final int width = 400;
    private final int height = 300;
    private final int numOfLines = 10;
    private final int radios = 3;
    private final Color lineColor = Color.BLACK;
    private final Color midColor = Color.BLUE;
    private final Color interColor = Color.RED;


    /**
     * Accessing point.
     *
     * @param args no use
     */
    public static void main(String[] args) {
        AbstractArtDrawing drawing = new AbstractArtDrawing();
        drawing.drawRandomLines();
    }

    /**
     * Draws randomly generated lines on screen.
     */
    public void drawRandomLines() {
        GUI gui = new GUI("Random Lines", width, height);
        DrawSurface d = gui.getDrawSurface();
        ArrayOfLines lines = new ArrayOfLines(numOfLines);

        lines.generateRandomLines(width, height);
        lines.drawOn(d, lineColor);
        lines.drawMidPoints(d, radios, midColor);
        lines.drawInterPoints(d, radios, interColor);
        gui.show(d);
    }
}
