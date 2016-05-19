package interfaces;

import biuoop.DrawSurface;

/**
 * animation interface.
 *
 * @author Raziel Solomon
 * @since 12-May-16.
 */
public interface Animation {
    /**
     * draw one frame.
     *
     * @param d a drawsurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * returns whether turn should stop.
     *
     * @return whether turn should stop.
     */
    boolean shouldStop();
}
