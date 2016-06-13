package sprites;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Fill;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import shapes.Rectangle;

/**
 * Fill image class.
 *
 * @author Raziel Solomon
 * @since 09-Jun-16.
 */
public class FillImage implements Fill {
    private String path;
    private Image img;
    private Rectangle rect;

    /**
     * constructor.
     *
     * @param path path to image
     * @param rect rectangle to fill
     */
    public FillImage(String path, Rectangle rect) {
        this(path);
        this.rect = rect;
    }

    /**
     * constructor.
     *
     * @param path path to image
     */
    public FillImage(String path) {
        this.path = path;
        this.rect = new Rectangle(0, 0, 800, 600);
        try {
            this.img = ImageIO.read(new File(path));
            ////.close????
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawImage((int) getRect().getUpperLeft().getX(),
                (int) getRect().getUpperLeft().getY(), img);
    }

    /**
     * rect getter.
     *
     * @return rect
     */
    public Rectangle getRect() {
        return rect;
    }

    /**
     * notify the sprite that time has passed.
     *
     * @param dt seconds passed.
     */
    @Override
    public void timePassed(double dt) {
        //does nothing
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
     * create fill in rectangle size.
     *
     * @param rect rectangle
     * @return new fill
     */
    @Override
    public Fill create(Rectangle rect) {
        return new FillImage(getPath(), rect);
    }

    /**
     * path getter.
     *
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * toString method.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return "FillImage{" +
                "path='" + path + '\'' +
                ", rect=" + rect +
                '}';
    }
}
