package blocks;

import biuoop.DrawSurface;
import game.Game;
import interfaces.InterBlock;
import shapes.Rectangle;

import java.awt.Color;

/**
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public class BorderBlock extends BaseBlock implements InterBlock {
    public BorderBlock(Rectangle rect, Color color) {
        super(rect, color);
    }

    @Override
    protected void drawSelf(DrawSurface d, double x, double y) {
        // nothing happens.
    }

    @Override
    protected void effect() {
        // nothing happens.
    }

    @Override
    public void removeFromGame(Game game) {
        // nothing happens.
    }
}