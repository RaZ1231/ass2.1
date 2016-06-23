package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Menu;
import interfaces.MenuOption;
import interfaces.Task;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import shapes.Point;
import sprites.Background;
import sprites.CopyRightsS;
import sprites.FillImage;
import sprites.MenuItem;
import sprites.Text;
import utils.Selection;

/**
 * Menu animation class.
 *
 * @author Raziel Solomon
 * @since 03-Jun-16.
 */
public class MenuAnimation implements Menu<Task<Void>> {
    private String title;
    private KeyboardSensor sensor;
    private List<Selection<Void>> selections;
    private Task<Void> status;
    private boolean stop;

    /**
     * Constructor.
     *
     * @param title  menu title
     * @param sensor keyboard sensor
     */
    public MenuAnimation(String title, KeyboardSensor sensor) {
        this.title = title;
        this.sensor = sensor;
        selections = new ArrayList<Selection<Void>>();
        status = null;
        stop = false;
    }

    /**
     * add new option.
     *
     * @param key       shortcut key
     * @param message   text
     * @param returnVal option return value
     */
    @Override
    public void addSelection(String key, String message, Task<Void> returnVal) {
        selections.add(new Selection<Void>(key, message, returnVal));
    }

    /**
     * return selected option.
     *
     * @return selected option
     */
    @Override
    public Task<Void> getStatus() {
        return status;
    }

    /**
     * add new sub menu.
     *
     * @param key     hot key
     * @param message text
     * @param subMenu sub menu
     */
    @Override
    public void addSubMenu(String key, String message, Menu<Task<Void>> subMenu) {
        // none.
    }

    /**
     * restart menu.
     */
    @Override
    public void restart() {
        stop = false;
        status = null;
    }

    /**
     * draw one frame.
     *
     * @param d  a drawsurface.
     * @param dt seconds passed.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        //selections
        for (Selection<Void> selection : selections) {
            if (sensor.isPressed(selection.getKey())) {
                status = selection.getTask();
            }
        }

        if (getStatus() != null) {
            stop = true;
        }

        drawBG(d);
    }

    /**
     * draw background of animation.
     *
     * @param d draw surface
     */
    public void drawBG(DrawSurface d) {
        Background b = new Background();

        Color backColor = new Color(252, 250, 255);
        Color itemColor = new Color(151, 66, 130);

        FillImage backGround = new FillImage("menu_background.jpg");
        b.addElement(backGround);

        Text menuTitle = new Text(itemColor, new Point(d.getWidth() / 2 - 210, 195), title, 60);
        b.addElement(menuTitle);

        int itemHeight = 55;
        int itemWidth = 350;
        List<MenuOption> options = new ArrayList<>();

        options.addAll(selections);

        for (int i = 0; i < options.size(); i++) {
            b.addElement(new MenuItem(
                    new Point(d.getWidth() / 2 - itemWidth / 2, 220 + i * itemHeight),
                    itemColor,
                    backColor,
                    itemWidth,
                    itemHeight - 5,
                    backColor,
                    options.get(i).getMessage()
            ));
        }

        Text credits = new Text(itemColor,
                new Point(d.getWidth() / 2 - 42, 250 + options.size() * itemHeight),
                "EB & RS", 20);
        b.addElement(credits);

        CopyRightsS copyRightsS = new CopyRightsS(itemColor,
                new Point(d.getWidth() / 2 - 9, 275 + options.size() * itemHeight), 20);
        b.addElement(copyRightsS);

        b.drawOn(d);
    }

    /**
     * returns whether turn should stop.
     *
     * @return whether turn should stop.
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }
}
