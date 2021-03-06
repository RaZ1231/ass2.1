package sprites;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Fill;
import java.awt.Color;
import shapes.Point;
import shapes.Rectangle;

/**
 * Fill color class.
 *
 * @author Raziel Solomon
 * @since 09-Jun-16.
 */
public class FillColor extends BaseSprite implements Fill {
    private Rectangle rect;

    /**
     * constructor.
     *
     * @param color fill color
     */
    public FillColor(Color color) {
        super(color);
        this.rect = new Rectangle(0, 0, 800, 600);
    }

    /**
     * constructor.
     *
     * @param color a color.
     * @param rect  rectangle to fill.
     */
    public FillColor(Color color, Rectangle rect) {
        super(color);
        this.rect = rect;
    }

    /**
     * add object to gameLevel.
     *
     * @param gameLevel a gameLevel to add the object to.
     */
    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        if (getColor() != null) {
            d.setColor(getColor());
            d.fillRectangle((int) getRect().getUpperLeft().getX(),
                    (int) getRect().getUpperLeft().getY(),
                    (int) getRect().getWidth(), (int) getRect().getHeight());
        }
    }

    /**
     * rectangle getter.
     *
     * @return rectangle.
     */
    public Rectangle getRect() {
        return rect;
    }

    /**
     * create fill in rectangle size.
     *
     * @param rectangle rectangle.
     * @return new fill.
     */
    @Override
    public Fill create(Rectangle rectangle) {
        return new FillColor(getColor(), rectangle);
    }

    /**
     * point setter.
     *
     * @param point new point
     */
    @Override
    public void setPoint(Point point) {
        rect.setUpperLeft(point);
    }

    /**
     * toString method.
     *
     * @return string representation.
     */
    @Override
    public String toString() {
        return "FillColor{"
                + "color=" + getColor()
                + "rect=" + rect + '}';
    }
}
