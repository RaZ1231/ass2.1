package graphics;

import shapes.Ball;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Raziel Solomon
 * @since 16-Mar-16.
 */

/**
 * BIU's ball animation.
 */
public class BouncingBallAnimation {
    /**
     * Accessing point.
     *
     * @param args no use
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Bouncing Ball Animation", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(0, 0, 30, java.awt.Color.BLACK);
        ball.setVelocity(2, 2);
        while (true) {
            ball.moveBoundedStep(0, 0, 200, 200);
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
