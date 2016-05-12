package interfaces;

import biuoop.DrawSurface;

/**
 * @author Raziel Solomon
 * @since 12-May-16.
 */
public interface Animation {
    void doOneFrame(DrawSurface d);

    boolean shouldStop();
}
