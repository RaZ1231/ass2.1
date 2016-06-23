package interfaces;

/**
 * A task interface.
 *
 * @param <T> animation screen.
 * @author Raziel Solomon
 * @since 03-Jun-16.
 */
public interface Task<T> {
    /**
     * run the animation.
     *
     * @return run task.
     */
    T run();
}
