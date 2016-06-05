package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Menu;
import interfaces.Task;
import shapes.Point;
import sprites.Background;
import sprites.MenuItem;
import sprites.Square;
import sprites.Text;
import utils.Selection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 03-Jun-16.
 */
public class MenuAnimation implements Menu<Task<Void>> {
    private String title;
    private KeyboardSensor sensor;
    private List<Selection<Void>> selections;
    private Task<Void> status;
    private boolean stop;

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
     * draw one frame.
     *
     * @param d  a drawsurface.
     * @param dt seconds passed.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        for (Selection<Void> selection : selections) {
            if (sensor.isPressed(selection.getKey())) {
                selection.getTask().run();
            }
        }

        drawBG(d);
    }

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

        for (int i = 0; i < selections.size(); i++) {
            b.addElement(new MenuItem(
                    new Point(d.getWidth() / 2 - itemWidth / 2, 220 + i * itemHeight),
                    itemColor,
                    backColor,
                    itemWidth,
                    itemHeight - 5,
                    backColor,
                    selections.get(i).getMessage()
            ));
        }

        Text credits = new Text(itemColor,
                new Point(d.getWidth() / 2 - 42, 250 + selections.size() * itemHeight),
                "EB & RS", 20);
        b.addElement(credits);

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
