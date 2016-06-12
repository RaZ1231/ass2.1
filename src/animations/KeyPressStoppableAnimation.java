package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * Deals with key presses.
 *
 * @author Raziel Solomon
 * @since 02-Jun-16.
 */
public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor sensor;
    private final String key;
    private final Animation animation;
    private boolean running;
    private boolean isAlreadyPressed;

    /**
     * Constructor.
     *
     * @param sensor    keyboard sensor
     * @param key       hot key
     * @param animation animation to manage
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.running = true;
        this.isAlreadyPressed = true;
    }

    /**
     * draw one frame.
     *
     * @param d  a drawsurface.
     * @param dt seconds passed.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        if (sensor.isPressed(key)) {
            running = isAlreadyPressed; //key press bug
        } else {
            isAlreadyPressed = false;
        }

        animation.doOneFrame(d, dt);
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
