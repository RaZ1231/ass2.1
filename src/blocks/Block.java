package blocks;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.GameBlock;
import shapes.Rectangle;

import java.awt.Color;

/**
 * Block representation.
 *
 * @author Elisheva
 * @since 30/03/2016.
 */
public class Block extends BaseBlock implements GameBlock {
    private int hitCounter;

    /**
     * constructor.
     *
     * @param rect       a rectangle.
     * @param color      a color.
     * @param hitCounter hits counter. 'null' if none.
     */
    public Block(Rectangle rect, Color color, int hitCounter) {
        super(rect, color);
        this.hitCounter = hitCounter;
    }

    /**
     * returns hits counter.
     *
     * @return hits counter. 'null' in none.
     */
    public Integer getHitPoints() {
        return hitCounter;
    }

    /**
     * Draws on surface.
     *
     * @param d draw surface.
     */
    public void drawSelf(DrawSurface d, double x, double y) {
        String s = hitsAsString();
        d.drawText((int) x, (int) y, s, 18);
    }

    /**
     * returns hits counter as a String.
     *
     * @return hits counter as a String
     */
    private String hitsAsString() {
        if (this.hitCounter == 0) {
            return "X";
        } else {
            return String.valueOf(hitCounter);
        }
    }

    public void effect() {
        this.setHitCounter(hitCounter - 1);
    }

    /**
     * setting hit counter of block.
     *
     * @param hitCount hit counter of block.
     */
    private void setHitCounter(int hitCount) {
        if (hitCount < 1) {
            this.hitCounter = 0;
        } else {
            this.hitCounter = hitCount;
        }
    }

    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }
}
