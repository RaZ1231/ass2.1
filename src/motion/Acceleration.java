package motion;

/**
 * @author Raziel Solomon
 * @since 14-Jun-16.
 */
public class Acceleration {
    private Velocity velocity;

    /**
     * constructor.
     *
     * @param vel a velocity.
     */
    public Acceleration(Velocity vel) {
        this.velocity = vel;
    }

    /**
     * accelerate current velocity.
     *
     * @param percent percent of acceleration.
     */
    public void accelBy(int percent) {
        velocity = Velocity.fromAngleAndSpeed(velocity.getAngle(),
                velocity.getSpeed() * (percent + 100) / 100);
    }

    /**
     * returns velocity.
     *
     * @return velocity.
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * set velocity.
     *
     * @param aVelocity a new velocity.
     */
    public void setVelocity(Velocity aVelocity) {
        this.velocity = aVelocity;
    }

    /**
     * flip velocity's direction.
     */
    public void flipV() {
        velocity = new Velocity((-1) * velocity.getDx(), (-1) * velocity.getDy());
    }

    /**
     * returns velocity as a string.
     *
     * @return velocity as a string.
     */
    @Override
    public String toString() {
        return "A{" + velocity + '}';
    }
}
