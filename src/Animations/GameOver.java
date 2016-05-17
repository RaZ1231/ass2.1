package Animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
import utils.Counter;

/**
 * @author Raziel Solomon
 * @since 17-May-16.
 */
public class GameOver implements Animation {
    private KeyboardSensor sensor;
    private Counter score;
    private boolean running;

    public GameOver(KeyboardSensor sensor, Counter score) {
        this.sensor = sensor;
        this.score = score;
        this.running = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(d.getWidth() / 2 - 100, d.getHeight() / 2, "GAME OVER", 48);
        d.drawText(d.getWidth() / 2 - 50, d.getHeight() / 2 + 50, "Score: " + score.getValue(), 48);

        if (sensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !running;
    }
}
