package sprites;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;
import java.awt.Color;

/**
 * Base sprite class.
 *
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public abstract class BaseSprite implements Sprite {
    private Color color;

    /**
     * constructor.
     *
     * @param color a color.
     */
    public BaseSprite(Color color) {
        this.color = color;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        drawSelf(d, color);
    }

    /**
     * draw itself.
     *
     * @param d     a draw surface.
     * @param color a color.
     */
    public abstract void drawSelf(DrawSurface d, Color color);

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        // do nothing.
    }

    /**
     * add object to gameLevel.
     *
     * @param gameLevel a gameLevel to add the object to.
     */
    @Override
    public void addToGame(GameLevel gameLevel) {
        // do nothing.
    }
}
