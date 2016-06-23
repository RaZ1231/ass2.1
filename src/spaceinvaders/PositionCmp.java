package spaceinvaders;

/**
 * comparing between two invaders.
 *
 * @author Raziel Solomon
 * @since 15-Jun-16.
 */
public interface PositionCmp {
    /**
     * returns boolean value of compare.
     *
     * @param i1 an invader.
     * @param i2 another invader.
     * @return boolean value of compare.
     */
    boolean compare(Invader i1, Invader i2);
}
