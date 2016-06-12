package utils;

import interfaces.Menu;
import interfaces.MenuOption;

/**
 * Sub menu option class.
 *
 * @author Raziel Solomon
 * @since 11-Jun-16.
 */
public class SubMenuSelection<T> implements MenuOption {
    private String key;
    private String message;
    private Menu<T> menu;

    /**
     * constructor.
     *
     * @param key     hot key
     * @param message text
     * @param menu    sub menu
     */
    public SubMenuSelection(String key, String message, Menu<T> menu) {
        this.key = key;
        this.message = message;
        this.menu = menu;
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
     * sub menu getter.
     *
     * @return sub menu
     */
    public Menu<T> getMenu() {
        return menu;
    }
}
