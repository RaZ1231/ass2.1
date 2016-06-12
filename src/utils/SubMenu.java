package utils;

import animations.MenuAnimation;
import biuoop.KeyboardSensor;

/**
 * Menu animation sub menu class.
 *
 * @author Raziel Solomon
 * @since 11-Jun-16.
 */
public class SubMenu extends MenuAnimation {
    /**
     * constructor.
     *
     * @param title  sub menu title
     * @param sensor keyboard sensor
     */
    public SubMenu(String title, KeyboardSensor sensor) {
        super(title, sensor);
    }
}
