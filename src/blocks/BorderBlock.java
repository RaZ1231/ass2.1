package blocks;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.GameBlock;
import java.awt.Color;
import shapes.Rectangle;

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
     * @param rect  a rectangle.
     * @param color a color.
     */
    public BorderBlock(Rectangle rect, Color color) {
        super(rect, color);
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
