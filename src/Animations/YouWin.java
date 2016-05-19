package Animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
import shapes.Point;
import sprites.Background;
import sprites.Crown;
import sprites.Square;
import sprites.Text;
import utils.Counter;

import java.awt.Color;

/**
 * winning screen class.
 *
 * @author Raziel Solomon
 * @since 17-May-16.
 */
public class YouWin implements Animation {
    private KeyboardSensor sensor;
    private Counter score;
    private boolean running;

    /**
     * constructor.
     *
     * @param sensor a keyboard sensor.
     * @param score  current scores.
     */
    public YouWin(KeyboardSensor sensor, Counter score) {
        this.sensor = sensor;
        this.score = score;
        this.running = true;
    }

    /**
     * draw one turn.
     *
     * @param d a drawsurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        drawBackGround(d);

        if (sensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            running = false;
        }
    }

    /**
     * draws screen's background.
     *
     * @param d a drawsurface.
     */
    public void drawBackGround(DrawSurface d) {
        Background b = new Background();
        Color backColor = new Color(89, 115, 253);

        Square back = new Square(new Point(0, 0), 800, 600, backColor);
        b.addElement(back);

        //crown
        Color cBody = new Color(253, 244, 27);
        Color cScnd = new Color(253, 83, 64);
        Color cText = new Color(253, 185, 73);

        Crown crown = new Crown(cBody, cScnd, backColor, new Point(200, 200), 400, 200);
        b.addElement(crown);


        Text t1 = new Text(cText, new Point(200, 150), "YOU WIN!", 86);
        b.addElement(t1);

        Text t2 = new Text(cText, new Point(200, 500), "Score: " + score.getValue(), 86);
        b.addElement(t2);

        b.drawOn(d);
    }

    /**
     * returns whether turn should stop.
     *
     * @return whether turn should stop.
     */
    @Override
    public boolean shouldStop() {
        return !running;
    }
}
