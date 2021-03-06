package sprites;

import animations.GameLevel;
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
     * get the color of sprite.
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * notify the sprite that time has passed.
     *
     * @param dt seconds passed.
     */
    @Override
    public void timePassed(double dt) {
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
