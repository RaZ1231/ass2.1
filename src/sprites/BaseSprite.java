package sprites;

import Animations.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;
import java.awt.Color;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Elisheva Broyer.
 * @since 15/05/2016.
 */
public abstract class BaseSprite implements Sprite {
    private List<Integer> x;
    private List<Integer> y;
    private Color color;

    /**
     * constructor.
     *
     * @param color a color.
     */
    public BaseSprite(Color color) {
        this.color = color;
        x = new LinkedList<>();
        y = new LinkedList<>();
    }

    public void addX(int newX) {
        x.add(newX);
    }

    public void addY(int newY) {
        y.add(newY);
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        drawSelf(d, x, y, color);
    }

    /**
     * draw itself.
     *
     * @param d     a draw surface.
     * @param x     sprite's x positions.
     * @param y     sprite's y positions.
     * @param color a color.
     */
    public void drawSelf(DrawSurface d, List<Integer> x, List<Integer> y, Color color) {
        d.setColor(color);
        int[] arrX = listToArray(x);
        int[] arrY = listToArray(y);
        d.fillPolygon(new Polygon(arrX, arrY, x.size()));
    }

    public int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        // do nothing.
    }

    /**
     * add object to gameLevel.
     *
     * @param gameLevel a gameLevel to add the object to.
     */
    @Override
    public void addToGame(GameLevel gameLevel) {
        // do nothing.
    }
}
