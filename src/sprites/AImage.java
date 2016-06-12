package sprites;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;
import shapes.Point;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * drawable image.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class AImage implements Sprite {
    Point upperLeft;
    String image;

    /**
     * constructor.
     *
     * @param path      a path to an image.
     * @param upperLeft corner point.
     */
    public AImage(String path, Point upperLeft) {
        this.image = path;
        this.upperLeft = upperLeft;
    }

    /**
     * constructor.
     *
     * @param path a path to an image.
     */
    public AImage(String path) {
        this.image = path;
        this.upperLeft = new Point(0, 0);
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        try {
            d.drawImage((int) upperLeft.getX(), (int) upperLeft.getY(), ImageIO.read(new File(image)));
        } catch (IOException ignored) {
        }
    }

    /**
     * notify the sprite that time has passed.
     *
     * @param dt seconds passed.
     */
    @Override
    public void timePassed(double dt) {
        //nothing
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
}
