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
    java.awt.Image image;

    /**
     * constructor.
     *
     * @param color a color.
     * @param path  a path to an image.
     */
    public Image(Color color, String path) {
        super(color);
        this.image = null;
        try {
            this.image = ImageIO.read(new File(path));
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
        d.drawImage(0, 0, image);
    }
}
