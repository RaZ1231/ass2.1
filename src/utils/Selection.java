package utils;

import interfaces.MenuOption;
import interfaces.Task;

/**
 * Menu selection class.
 *
 * @param <T> an option.
 * @author Raziel Solomon
 * @since 03-Jun-16.
 */
public class Selection<T> implements MenuOption {
    private String key;
    private String message;
    private Task<T> task;

    /**
     * constructor.
     *
     * @param key     hot key
     * @param message text
     * @param task    task to run
     */
    public Selection(String key, String message, Task<T> task) {
        this.key = key;
        this.message = message;
        this.task = task;
    }

    /**
     * key getter.
     *
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * text getter.
     *
     * @return text
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * task getter.
     *
     * @return task
     */
    public Task<T> getTask() {
        return task;
    }
}
