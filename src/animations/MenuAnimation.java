package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Menu;
import interfaces.MenuOption;
import interfaces.Task;
import shapes.Point;
import sprites.Background;
import sprites.CopyRightsS;
import sprites.MenuItem;
import sprites.Square;
import sprites.Text;
import utils.Selection;
import utils.SubMenuSelection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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
    private List<SubMenuSelection<Task<Void>>> subMenus;
    private SubMenuSelection<Task<Void>> subMenuStat;
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
        subMenus = new ArrayList<SubMenuSelection<Task<Void>>>();
        status = null;
        subMenuStat = null;
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
        subMenus.add(new SubMenuSelection<Task<Void>>(key, message, subMenu));
    }

    /**
     * restart menu.
     */
    @Override
    public void restart() {
        stop = false;
        status = null;
        subMenuStat = null;

        //sub-menus
        for (SubMenuSelection<Task<Void>> subMenu : subMenus) {
            subMenu.getMenu().restart();
        }
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

        //sub-menus
        for (SubMenuSelection<Task<Void>> subMenu : subMenus) {
            if (sensor.isPressed(subMenu.getKey())) {
                subMenuStat = subMenu;
            }
        }

        if (getStatus() != null) {
            stop = true;
        }
        //sub-menus management
        if (subMenuStat != null) {
            subMenuStat.getMenu().doOneFrame(d, dt);
            status = subMenuStat.getMenu().getStatus();
        } else {
            drawBG(d);
        }
    }

    /**
     * draw background of animation.
     *
     * @param d draw surface
     */
    public void drawBG(DrawSurface d) {
        Background b = new Background();

        Color backColor = new Color(75, 130, 155);
        Color itemColor = new Color(231, 89, 68);

        Square back = new Square(new Point(0, 0), d.getWidth(), d.getHeight(), backColor);
        b.addElement(back);

        Text menuTitle = new Text(itemColor, new Point(d.getWidth() / 2 - 155, 195), title, 60);
        b.addElement(menuTitle);

        int itemHeight = 55;
        int itemWidth = 350;
        List<MenuOption> options = new ArrayList<>();

        options.addAll(subMenus);
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
