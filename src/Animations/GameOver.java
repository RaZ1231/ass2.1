package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
import shapes.Point;
import sprites.*;
import utils.Counter;

import java.awt.Color;

/**
 * game over screen class.
 *
 * @author Raziel Solomon
 * @since 17-May-16.
 */
public class GameOver implements Animation {
    private KeyboardSensor sensor;
    private Counter score;
    private boolean running;

    /**
     * constructor.
     *
     * @param sensor a keyboard sensor.
     * @param score  current scores.
     */
    public GameOver(KeyboardSensor sensor, Counter score) {
        this.sensor = sensor;
        this.score = score;
        this.running = true;
    }

    /**
     * draw one frame.
     *
     * @param d  a drawsurface.
     * @param dt seconds passed.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
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

        Square back = new Square(new Point(0, 0), 800, 600, new Color(180, 0, 0));
        b.addElement(back);

        Text t1a = new Text(new Color(110, 0, 0), new Point(d.getWidth() / 2 - 103, d.getHeight() / 2 - 3),
                "GAME OVER", 48);
        b.addElement(t1a);
        Text t2a = new Text(new Color(110, 0, 0), new Point(d.getWidth() / 2 - 53, d.getHeight() / 2 + 47),
                "Score: " + score.getValue(), 48);
        b.addElement(t2a);
        Text t1b = new Text(Color.black, new Point(d.getWidth() / 2 - 100, d.getHeight() / 2),
                "GAME OVER", 48);
        b.addElement(t1b);
        Text t2b = new Text(Color.black, new Point(d.getWidth() / 2 - 50, d.getHeight() / 2 + 50),
                "Score: " + score.getValue(), 48);
        b.addElement(t2b);

        Circle c = new Circle(Color.black, new Point(150, 300), 100);
        b.addElement(c);

        ALine a1 = new ALine(Color.white, new Point(90, 240), new Point(130, 280), 5);
        b.addElement(a1);

        ALine a2 = new ALine(Color.white, new Point(130, 240), new Point(90, 280), 5);
        b.addElement(a2);

        ALine a3 = new ALine(Color.white, new Point(170, 240), new Point(210, 280), 5);
        b.addElement(a3);

        ALine a4 = new ALine(Color.white, new Point(210, 240), new Point(170, 280), 5);
        b.addElement(a4);

        ALine a5 = new ALine(Color.white, new Point(110, 350), new Point(190, 350), 5);
        b.addElement(a5);

        ALine a6 = new ALine(Color.black, new Point(50, 400), new Point(250, 450), 10);
        b.addElement(a6);

        ALine a7 = new ALine(Color.black, new Point(50, 450), new Point(250, 400), 10);
        b.addElement(a7);

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
