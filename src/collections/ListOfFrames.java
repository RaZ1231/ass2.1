package collections;

import complex.Frame;
import shapes.Rectangle;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 18-Mar-16.
 */

/**
 * Manages list of frames.
 */
public class ListOfFrames {
    private List<Frame> frames;

    /**
     * constructor.
     */
    public ListOfFrames() {
        this.frames = new ArrayList<Frame>();
    }

    /**
     * Adds frame to list.
     *
     * @param frame frame to add
     */
    public void add(Frame frame) {
        this.frames.add(frame);
    }

    /**
     * Generates frames from rectangles and balls number.
     *
     * @param rectangles list of rectangles
     * @param sizes      list of arrays of sizes
     */
    public void createFrames(List<Rectangle> rectangles, List<int[]> sizes) {
        for (int i = 0; i < rectangles.size(); i++) {
            this.frames.add(new Frame(rectangles.get(i), sizes.get(i).length));
        }
    }

    /**
     * Generates balls by sizes.
     *
     * @param sizes list of arrays of sizes
     */
    public void generateBalls(List<int[]> sizes) {
        for (int i = 0; i < this.frames.size(); i++) {
            this.frames.get(i).generateBalls(sizes.get(i));
        }
    }

    /**
     * Move frame shapes on frame.
     */
    public void moveOneStep() {
        for (Frame frame : this.frames) {
            frame.moveOneStep();
        }
    }

    /**
     * Draws frame on surface.
     *
     * @param d draw surface
     */
    public void drawOn(DrawSurface d) {
        for (Frame frame : this.frames) {
            frame.drawOn(d);
        }
    }
}
