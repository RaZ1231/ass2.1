package blocks;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.GameBlock;
import java.awt.Color;
import shapes.Rectangle;

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
    public Block(Rectangle rect, Color color, Color stroke, int hitCounter) {
        super(rect, color, stroke);
        this.hitCounter = hitCounter;
    }

    /**
     * constructor.
     *
     * @param rect       a rectangle.
     * @param image      a path.
     * @param hitCounter hits counter. 'null' if none.
     */
    public Block(Rectangle rect, String image, Color stroke, int hitCounter) {
        super(rect, image, stroke);
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
     * block draws itself.
     *
     * @param d a drawsurface.
     * @param x x-axes coordinate.
     * @param y y-axes coordinate.
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

    /**
     * the effect of the hit on the block.
     */
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

    /**
     * remove block from game.
     *
     * @param gameLevel a level.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }
}
