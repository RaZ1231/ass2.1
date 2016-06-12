package blocks;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Fill;
import interfaces.GameBlock;
import shapes.Rectangle;
import sprites.FillColor;

import java.awt.Color;

/**
 * Death region in charge of screen's bottom.
 *
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class DeathRegion extends BaseBlock implements GameBlock {
    /**
     * constructor.
     */
    public DeathRegion() {
        this(new Rectangle(0, 600, 800, 10), new FillColor(Color.white), Color.black);
    }

    /**
     * constructor.
     *
     * @param rect a rectangle.
     * @param fill a filling.
     */
    public DeathRegion(Rectangle rect, Fill fill, Color stroke) {
        super(rect, fill, stroke);
    }

    /**
     * block draws itself.
     *
     * @param d a drawsurface.
     * @param x x-axes coordinate.
     * @param y y-axes coordinate.
     */
    @Override
    protected void drawSelf(DrawSurface d, double x, double y) {
        // nothing happens.
    }

    /**
     * the effect of the hit on the block.
     */
    @Override
    protected void effect() {
        // nothing happens.
    }

    /**
     * remove block from game.
     *
     * @param gameLevel a level.
     */
    @Override
    public void removeFromGame(GameLevel gameLevel) {
        // nothing happens.
    }
}
