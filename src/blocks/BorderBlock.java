package blocks;

import biuoop.DrawSurface;
import game.Game;
import interfaces.InterBlock;
import java.awt.Color;
import shapes.Rectangle;

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
    protected void selfAffect() {
        // nothing happens.
    }

    @Override
    public void removeFromGame(Game game) {
        // nothing happens.
    }
}
