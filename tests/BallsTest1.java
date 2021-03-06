package tests; /**
 * @author Raziel Solomon
 * @since 16-Mar-16.
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;
import shapes.Ball;


public class BallsTest1 {
    public static void main(String[] args) {
        GUI gui = new GUI("Balls Test 1", 400, 400);
        DrawSurface d = gui.getDrawSurface();

        Ball b1 = new Ball(100, 100, 30, Color.RED, null);
        Ball b2 = new Ball(100, 150, 10, Color.BLUE, null);
        Ball b3 = new Ball(80, 249, 50, Color.GREEN, null);

        b1.drawOn(d);
        b2.drawOn(d);
        b3.drawOn(d);

        gui.show(d);
    }
}
