package game;

import blocks.BorderBlock;
import blocks.DeathRegion;
import interfaces.GameBlock;
import shapes.Rectangle;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * stages class.
 *
 * @author Raziel Solomon
 * @since 31-Mar-16.
 */
public class Borders {
    /**
     * returns surface's borders.
     *
     * @param width  surface's width borders.
     * @param height surface's height borders.
     * @param size   borders' size.
     * @return surface's borders.
     */
    public static List<GameBlock> getBorders(double width, double height, int size) {
        List<GameBlock> borders = new LinkedList<>();

        borders.add(new BorderBlock(new Rectangle(0, 20, size, height - size), Color.BLACK)); //left
        borders.add(new BorderBlock(new Rectangle(width - size, 20, width, height - size), Color.BLACK)); //right
        borders.add(new BorderBlock(new Rectangle(0, 20, width, size), Color.BLACK)); //top
        borders.add(new DeathRegion()); //bottom

        return borders;
    }
}