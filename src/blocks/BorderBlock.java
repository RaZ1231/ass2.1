package blocks;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Fill;
import interfaces.GameBlock;
import shapes.Rectangle;

import java.awt.Color;

/**
 * border block class.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public class BorderBlock extends BaseBlock implements GameBlock {
    /**
     * constructor.
     *
     * @param rect a rectangle.
     * @param fill a filling.
     */
    public BorderBlock(Rectangle rect, Fill fill, Color stroke) {
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
