package utils;

import interfaces.Task;

/**
 * @author Raziel Solomon
 * @since 03-Jun-16.
 */
public class Selection<T> {
    private String key;
    private String message;
    private Task<T> task;

    public Selection(String key, String message, Task<T> task) {
        this.key = key;
        this.message = message;
        this.task = task;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public Task<T> getTask() {
        return task;
    }
}
