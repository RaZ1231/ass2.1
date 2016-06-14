package spaceinvaders;

import motion.Velocity;

/**
 * @author Raziel Solomon
 * @since 14-Jun-16.
 */
public class Acceleration {
    private Velocity v;

    public Acceleration(Velocity v) {
        this.v = v;
    }

    public void accelBy(int percent) {
        v = Velocity.fromAngleAndSpeed(v.getAngle(), v.getSpeed() * percent / 100);
    }

    public Velocity getV() {
        return v;
    }

    public void flipV() {
        v = new Velocity((-1) * v.getDx(), (-1) * v.getDy());
    }
}
