package spaceinvaders;

/**
 * @author Elisheva Broyer.
 * @since 15/06/2016.
 */
public class Timer {
    private double value;

    public Timer(double value) {
        this.value = value;
    }

    public void timePassed(double dt) {
        value = value - dt;
    }

    public boolean hasPassed() {
        return value <= 0;
    }

}
