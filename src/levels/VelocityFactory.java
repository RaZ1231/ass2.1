package levels;

import java.util.LinkedList;
import java.util.List;
import motion.Velocity;

/**
 * velocity factory class.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class VelocityFactory {
    public List<Velocity> createVelocities(String velocities) {
        String[] out = velocities.split(";");
        List<Velocity> vel = new LinkedList<>();

        for (int i = 0; i < out.length; i++) {
            String[] v = out[i].split(",");
            vel.add(new Velocity(Integer.parseInt(v[0]), Integer.parseInt(v[1])));
        }
        return vel;
    }
}
