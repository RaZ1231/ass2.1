package spaceinvaders;

import motion.Velocity;
import org.junit.Test;
import shapes.Point;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Raziel Solomon
 * @since 16-Jun-16.
 */
public class FormationTest {
    @Test
    public void setAccel() throws Exception {
        List<Invader> invaders = new LinkedList<>();

        invaders.add(new Invader(new Point(90, 17), null));
        invaders.add(new Invader(new Point(90, 56), null));
        invaders.add(new Invader(new Point(90, 23), null));
        invaders.add(new Invader(new Point(80, 15), null));
        invaders.add(new Invader(new Point(80, 19), null));
        invaders.add(new Invader(new Point(80, 20), null));
        invaders.add(new Invader(new Point(70, 80), null));
        invaders.add(new Invader(new Point(70, 20), null));
        invaders.add(new Invader(new Point(70, 69), null));
        invaders.add(new Invader(new Point(60, 40), null));

        Acceleration a = new Acceleration(new Velocity(5, 5));
        Formation formation = new Formation(invaders, a, 0, 0);
        //formation.initInvaders();

        a.setV(new Velocity(6, 6));

        for (Invader invader : formation.getInvaders()) {
            System.out.println(invader);
        }

    }

}