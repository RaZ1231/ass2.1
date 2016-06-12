package levels;

import motion.Velocity;

import java.util.LinkedList;
import java.util.List;

/**
 * velocity factory class.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class VelocityFactory {
    /**
     * create velocity list.
     *
     * @param velocities velocities string to parse
     * @return list
     */
    public List<Velocity> createVelocities(String velocities) {
        String[] out = velocities.split(" ");
        List<Velocity> vel = new LinkedList<>();

        for (int i = 0; i < out.length; i++) {
            String[] v = out[i].split(",");
            vel.add(Velocity.fromAngleAndSpeed(Integer.parseInt(v[0]), Integer.parseInt(v[1])));
        }
        return vel;
    }
}
