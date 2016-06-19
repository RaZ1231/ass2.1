package blocks;

import animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Fill;
import interfaces.GameBlock;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import shapes.Ball;
import shapes.Rectangle;
import utils.Counter;

/**
 * Block representation.
 *
 * @author Elisheva
 * @since 30/03/2016.
 */
public class Block extends BaseBlock implements GameBlock {
    private Integer hitCounter;
    private Map<Integer, Fill> fillK;

    /**
     * constructor.
     *
     * @param rect       a rectangle.
     * @param fill       a filling.
     * @param hitCounter hits counter. 'null' if none.
     * @param stroke     a color.
     */
    public Block(Rectangle rect, Fill fill, Color stroke, int hitCounter) {
        this(rect, fill, new HashMap<Integer, Fill>(), stroke, hitCounter);
    }

    /**
     * constructor.
     *
     * @param rect       a rectangle
     * @param fill       a filling
     * @param fillK      fill-k map
     * @param stroke     stroke color
     * @param hitCounter hit counter
     */
    public Block(Rectangle rect, Fill fill, Map<Integer, Fill> fillK, Color stroke, int hitCounter) {
        super(rect, fill, stroke);
        this.hitCounter = hitCounter;
        this.fillK = fillK;

        for (Map.Entry<Integer, Fill> entry : fillK.entrySet()) {
            fillK.put(entry.getKey(), entry.getValue().create(rect));
        }

        this.fillK.put(-1, fill.create(rect));

        if (fillK.containsKey(hitCounter)) {
            this.setFill(fillK.get(hitCounter));
        }
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
        if (hitCounter == null) {
            return;
        }
        String s = hitsAsString();
        d.setColor(Color.BLACK);
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
        if (hitCounter == null) {
            return;
        }
        this.setHitCounter(hitCounter - 1);

        //fill-k
        if (fillK.containsKey(hitCounter)) {
            setFill(fillK.get(hitCounter).create(getRect()));
        } else {
            setFill(fillK.get(-1).create(getRect()));
        }
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
     * returns a map of fill objects matched to hit points.
     *
     * @return a map of fill objects matched to hit points.
     */
    public Map<Integer, Fill> getFillK() {
        return fillK;
    }

    /**
     * add an object to the map of fill-hit points.
     *
     * @param k    hit points
     * @param fill a fill object.
     */
    public void putFillK(int k, Fill fill) {
        fillK.put(k, fill);
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

    /**
     * deals with different hit events.
     *
     * @param game    the game
     * @param counter a counter
     * @param hitter  the ball of hit.
     */
    @Override
    public void hitEvent(GameLevel game, Counter counter, Ball hitter) {
        //null
    }
}
