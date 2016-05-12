package blocks;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.GameBlock;
import shapes.Rectangle;

import java.awt.Color;

/**
 * @author Raziel Solomon
 * @since 11-May-16.
 */
public class DeathRegion extends BaseBlock implements GameBlock {
    public DeathRegion() {
        this(new Rectangle(0, 600, 800, 10), Color.WHITE);
    }

    public DeathRegion(Rectangle rect, Color color) {
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
    public void removeFromGame(GameLevel gameLevel) {
        // nothing happens.
    }
}
