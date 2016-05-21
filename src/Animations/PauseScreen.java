package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
import shapes.Point;
import sprites.Background;
import sprites.Square;
import sprites.Text;

import java.awt.Color;

/**
 * pause screen class.
 *
 * @author Raziel Solomon
 * @since 12-May-16.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     *
     * @param k a keyboard sensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * drawing the pause screen.
     *
     * @param d a draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        drawBackGround(d);

        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * draws screen's background.
     *
     * @param d a drawsurface.
     */
    public void drawBackGround(DrawSurface d) {
        Background b = new Background();

        Color[] c = {new Color(53, 255, 104), new Color(254, 67, 188)};
        for (int i = 0; i < 8; i++) {
            Square back = new Square(new Point(100 * i, 0), 100, 600, c[i % 2]);
            b.addElement(back);
        }

        Text t1 = new Text(Color.black, new Point(10, d.getHeight() / 2), "paused -- press space to "
                + "continue", 40);
        b.addElement(t1);

        Text t2a = new Text(Color.blue, new Point(630, 450), "Z", 84);
        b.addElement(t2a);

        Text t2b = new Text(Color.blue, new Point(690, 510), "Z", 70);
        b.addElement(t2b);

        Text t2c = new Text(Color.blue, new Point(740, 560), "Z", 60);
        b.addElement(t2c);

        b.drawOn(d);
    }

    /**
     * returns whether turn should stop.
     *
     * @return whether turn should stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
