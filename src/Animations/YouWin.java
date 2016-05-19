package Animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
import java.awt.Color;
import shapes.Point;
import sprites.Background;
import sprites.Square;
import sprites.Text;
import utils.Counter;

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
        Square back = new Square(new Point(0, 0), 800, 600, new Color(253, 225, 68));
        b.addElement(back);

        Text t1 = new Text(Color.black, new Point(d.getWidth() / 2 - 100, d.getHeight() / 2), "YOU WIN!", 48);
        b.addElement(t1);

        Text t2 = new Text(Color.black, new Point(d.getWidth() / 2 - 50, d.getHeight() / 2 + 50),
                "Score: " + score.getValue(), 48);
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
