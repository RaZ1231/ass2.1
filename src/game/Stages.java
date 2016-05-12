package game;

import blocks.Block;
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
public class Stages {
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

    /**
     * returns a list of blocks for stage one.
     *
     * @param startX a x-axis value of the first upper left block in stage.
     * @param startY a y-axis value of the first upper left block in stage.
     * @param width  block's width.
     * @param height block's height.
     * @return a list of blocks for stage one.
     */
    public static List<GameBlock> getStageOne(double startX, double startY, double width, double height) {
        List<GameBlock> blocks = new LinkedList<>();
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN};
        int hitCounter;
        int rowCapacity = 11;

        for (int row = 0; row <= 5; row++) {
            if (row == 0) {
                hitCounter = 2;
            } else {
                hitCounter = 1;
            }

            for (int col = 0; col <= rowCapacity - row; col++) {
                blocks.add(new Block(
                        new Rectangle(col * width + startX, row * height + startY, width, height),
                        colors[row], hitCounter));
            }
        }
        return blocks;
    }
}
