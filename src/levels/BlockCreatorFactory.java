package levels;

import blocks.Block;
import interfaces.BlockCreator;
import shapes.Point;
import shapes.Rectangle;

/**
 * Block creator factory class.
 *
 * @author Raziel Solomon
 * @since 09-Jun-16.
 */
public class BlockCreatorFactory {
    /**
     * create creator from container.
     *
     * @param block container
     * @return new creator
     */
    public static BlockCreator fromContainer(final ContainerBlock block) {
        return new BlockCreator() {
            @Override
            public Block create(int xpos, int ypos) {
                return new Block(
                        new Rectangle(
                                new Point(xpos, ypos),
                                block.getWidth(),
                                block.getHeight()),
                        block.getFill(),
                        block.getFillK(),
                        block.getStroke(),
                        block.getHits());
            }
        };
    }
}
