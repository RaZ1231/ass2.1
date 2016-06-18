package interfaces;

import shapes.Point;
import shapes.Rectangle;

/**
 * A Filling class.
 *
 * @author Raziel Solomon
 * @since 11-Jun-16.
 */
public interface Fill extends Sprite {
    /**
     * create fill in rectangle size.
     *
     * @param rect rectangle
     * @return new fill
     */
    Fill create(Rectangle rect);

    /**
     * point setter.
     *
     * @param point new point
     */
    void setPoint(Point point);
}
