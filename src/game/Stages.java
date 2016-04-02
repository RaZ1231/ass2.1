package game;

import shapes.Rectangle;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 31-Mar-16.
 */
public class Stages {
    /**
     * returns surface's borders.
     *
     * @param width  surface's width borders.
     * @param height surface's height borders.
     * @return surface's borders.
     */
    public static List<Block> getBorders(double width, double height) {
        List<Block> borders = new LinkedList<>();
        int size = 15;

        borders.add(new Block(new Rectangle(0, 0, size, height), Color.BLACK, 0)); //left
        borders.add(new Block(new Rectangle(width - size, 0, size, height), Color.BLACK, 0)); //right
        borders.add(new Block(new Rectangle(0, 0, width, size), Color.BLACK, 0)); //top
        borders.add(new Block(new Rectangle(0, height - size, width, size), Color.BLACK, 0)); //bottom

        return borders;
    }

    /**
     * @param startX
     * @param startY
     * @param width
     * @param height
     * @return
     */
    public static List<Block> getStageOne(double startX, double startY, double width, double height) {
        List<Block> blocks = new LinkedList<>();
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
