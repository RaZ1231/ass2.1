package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * drawable image.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Image extends BaseSprite {
    String image;

    /**
     * constructor.
     *
     * @param color a color.
     * @param path  a path to an image.
     */
    public Image(Color color, String path) {
        super(color);
        this.image = path;

    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        try {
            d.drawImage(0, 0, ImageIO.read(new File(image)));
        } catch (IOException e) {
            d.setColor(getColor());
            d.drawRectangle(0, 0, d.getWidth(), d.getHeight());
        }
    }
}
