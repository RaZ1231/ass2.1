package spaceinvaders;

import animations.GameLevel;
import biuoop.DrawSurface;
import blocks.BaseBlock;
import interfaces.GameBlock;
import java.awt.Color;
import shapes.Point;
import shapes.Rectangle;
import sprites.FillColor;

/**
 * @author Elisheva Broyer.
 * @since 15/06/2016.
 */
public class ShieldBlock extends BaseBlock implements GameBlock {
    public ShieldBlock(Point upperLeft) {
        super(new Rectangle(upperLeft, 1, 1), new FillColor(Color.cyan), null);
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
        // none.
    }

    /**
     * the effect of the hit on the block.
     */
    @Override
    protected void effect() {
        // remove self.
    }

    /**
     * remove shield blok from game.
     *
     * @param gameLevel a level.
     */
    @Override
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }
}
