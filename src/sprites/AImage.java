package sprites;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import shapes.Point;

/**
 * drawable image.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class AImage implements Sprite {
    private Point upperLeft;
    private String image;

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
        InputStream is = null;
        try {
            is = ClassLoader.getSystemClassLoader().getResourceAsStream(image);
            d.drawImage((int) upperLeft.getX(), (int) upperLeft.getY(), ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                System.out.println("failed to close image!");
            }
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
