package spaceinvaders;

/**
 * timing class.
 *
 * @author Elisheva Broyer.
 * @since 15/06/2016.
 */
public class Timer {
    private double value;

    /**
     * constructor.
     *
     * @param value a double.
     */
    public Timer(double value) {
        this.value = value;
    }

    /**
     * timer count down.
     *
     * @param dt a delta.
     */
    public void timePassed(double dt) {
        value = value - dt;
    }

    /**
     * returns if time has passed.
     *
     * @return if time has passed.
     */
    public boolean hasPassed() {
        return value <= 0;
    }
}
