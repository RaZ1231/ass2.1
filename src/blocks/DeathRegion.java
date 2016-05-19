package blocks;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.GameBlock;
import java.awt.Color;
import shapes.Rectangle;

/**
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class DeathRegion extends BaseBlock implements GameBlock {
    /**
     * constructor.
     */
    public DeathRegion() {
        this(new Rectangle(0, 600, 800, 10), Color.WHITE);
    }

    /**
     * constructor.
     *
     * @param rect  a rectangle.
     * @param color a color.
     */
    public DeathRegion(Rectangle rect, Color color) {
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
