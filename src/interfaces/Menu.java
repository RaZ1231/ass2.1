package interfaces;

/**
 * Interface of a game menu.
 * @param <T> a screen.
 *
 * @author Raziel Solomon
 * @since 03-Jun-16.
 */
public interface Menu<T> extends Animation {
    /**
     * add new option.
     *
     * @param key       shortcut key
     * @param message   text
     * @param returnVal option return value
     */
    void addSelection(String key, String message, T returnVal);

    /**
     * return selected option.
     *
     * @return selected option
     */
    T getStatus();

    /**
     * add new sub menu.
     *
     * @param key     hot key
     * @param message text
     * @param subMenu sub menu
     */
    void addSubMenu(String key, String message, Menu<T> subMenu);

    /**
     * restart menu.
     */
    void restart();
}
