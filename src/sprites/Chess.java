package sprites;

import biuoop.DrawSurface;
import blocks.Block;
import interfaces.GameBlock;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Chess sprite class.
 *
 * @author Raziel Solomon
 * @since 20-May-16.
 */
public class Chess extends BaseSprite {
    private Color color2;
    private int x;
    private int y;
    private int nWidth;
    private int nHeight;
    private int bWidth;
    private int bHeight;
    private int hit;

    /**
     * constructor.
     *
     * @param color1  first color
     * @param p       start point
     * @param nWidth  blocks in a row
     * @param nHeight blocks in a column
     * @param bWidth  block width
     * @param bHeight block height
     * @param hit     hit counter
     */
    public Chess(Color color1, Point p, int nWidth, int nHeight, int bWidth, int bHeight, int hit) {
        super(color1);

        if (color1.equals(Color.black)) {
            this.color2 = Color.white;
        } else {
            this.color2 = Color.black;
        }

        this.x = (int) p.getX();
        this.y = (int) p.getY();
        this.nWidth = nWidth;
        this.nHeight = nHeight;
        this.bWidth = bWidth;
        this.bHeight = bHeight;
        this.hit = hit;
    }

    /**
     * draw the sprite to the screen..
     *
     * @param d a draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        Color color = getColor();
        Random rand = new Random();

        for (int i = x; i < nWidth * bWidth; i += bWidth) {
            for (int j = y; j < nHeight * bHeight; j += bHeight) {
                new Square(new Point(i, j), bWidth, bHeight, color).drawOn(d);
                color = switchColor(color);

                d.setColor(Color.BLACK);
                d.drawText(i + bWidth / 2 - 4, j + bHeight / 2 + 10, "" + hit, 18);
            }

            if (nHeight % 2 == 0) {
                color = switchColor(color);
            }
        }
    }

    /**
     * flip between color1 and color2.
     *
     * @param color current
     * @return flipped
     */
    private Color switchColor(Color color) {
        if (getColor().equals(color)) {
            return color2;
        } else {
            return getColor();
        }
    }

    /**
     * return chess shaped blocks.
     *
     * @return chess shaped blocks
     */
    public List<GameBlock> getBlocks() {
        List<GameBlock> collidables = new LinkedList<>();
        Color color = getColor();
        Random rand = new Random();

        for (int i = x; i < nWidth * bWidth; i += bWidth) {
            for (int j = y; j < nHeight * bHeight; j += bHeight) {
                collidables.add(new Block(new Rectangle(i, j, bWidth, bHeight),
                        new FillColor(color), Color.black, hit));
                color = switchColor(color);
            }

            if (nHeight % 2 == 0) {
                color = switchColor(color);
            }
        }

        return collidables;
    }
}
